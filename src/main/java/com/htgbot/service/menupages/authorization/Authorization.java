package com.htgbot.service.menupages.authorization;

import com.htgbot.service.ButtonsCallbacks;
import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Authorization {

    public SendMessage sendLoginPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsAuthorization.LOGIN_TEXT);

        return sendMessage;
    }

    public SendMessage sendMessagePasswordPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsAuthorization.PASSWORD_TEXT);

        return sendMessage;
    }

}

