package com.htgbot.service.menupages.education;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Education {
    public SendMessage sendEducationPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsEducation.EDUCATION_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsEducation.getKeyboard());

        return sendMessage;
    }
}
