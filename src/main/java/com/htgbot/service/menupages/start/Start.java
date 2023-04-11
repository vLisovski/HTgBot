package com.htgbot.service.menupages.start;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Start {

    public SendMessage sendStartPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsStart.START_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsStart.getKeyboard());

        return sendMessage;
    }
}
