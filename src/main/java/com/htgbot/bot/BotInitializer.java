package com.htgbot.bot;

import com.htgbot.statemachine.ChatRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotInitializer extends TelegramLongPollingBot {

    private ChatRouter chatRouter;

    public BotInitializer() throws Exception {
        this.chatRouter = new ChatRouter();
    }

    private class SessionThread extends Thread {

        private final Logger logger = LoggerFactory.getLogger(BotInitializer.class);
        private ChatRouter chatRouter;
        private Update update;
        private TelegramLongPollingBot bot;

        public SessionThread(ChatRouter chatRouter, Update update, TelegramLongPollingBot bot) {
            this.chatRouter = chatRouter;
            this.update = update;
            this.bot = bot;
        }

        @Override
        public void run() {
            System.out.println("session started");
            long chatId = 0;
            int messageId = 0;
            String textData;

            try {
                if (update.hasMessage()) {
                    chatId = update.getMessage().getChatId();
                    textData = update.getMessage().getText();

                    logger.info(String.format("INPUT: %d:%s", chatId, textData));

                    SendMessage sendMessage = chatRouter.route(chatId, textData);

                    logger.info(String.format("OUTPUT:\n%d\ntext=%s", chatId, sendMessage.getText()));

                    bot.execute(sendMessage);

                } else if (update.hasCallbackQuery()) {

                    chatId = update.getCallbackQuery().getMessage().getChatId();
                    messageId = update.getCallbackQuery().getMessage().getMessageId();
                    textData = update.getCallbackQuery().getData();
                    SendMessage message = chatRouter.route(chatId, textData);

                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(chatId);
                    editMessageText.setMessageId(messageId);
                    editMessageText.setText(message.getText());
                    if(message.getReplyMarkup()!=null){
                        editMessageText.setReplyMarkup((InlineKeyboardMarkup)message.getReplyMarkup());
                    }

                    logger.info(String.format("OUTPUT:\n%d\n%d\ntext=%s", chatId, messageId, message.getText()));

                    bot.execute(editMessageText);

                }

            } catch (Exception e) {

                e.printStackTrace();
                DeleteMessage message = new DeleteMessage();
                message.setChatId(chatId);
                message.setMessageId(messageId);

                try {
                    bot.execute(message);
                } catch (TelegramApiException telegramApiException) {
                    telegramApiException.printStackTrace();
                }
            }
        }

    }

    @Override
    public String getBotUsername() {
        return BotInitStrings.BOT_USERNAME;
    }
    @Override
    public String getBotToken() {
        return BotInitStrings.BOT_TOKEN;
    }
    @Override
    public void onUpdateReceived(Update update) {
        SessionThread sessionThread = new SessionThread(chatRouter, update, this);
        sessionThread.start();
    }
}
