package com.htgbot.service.menupages.about;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class About {
    public SendMessage sendAboutPage(TransData transData){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsAbout.ABOUT_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsAbout.getKeyboard());

        return sendMessage;
    }
}
