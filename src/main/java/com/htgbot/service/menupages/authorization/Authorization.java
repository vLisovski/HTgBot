package com.htgbot.service.menupages.authorization;

import com.htgbot.service.ButtonsCallbacks;
import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Authorization {

    public SendMessage sendLoginPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsAuthorization.LOGIN_TEXT);
       // sendMessage.setReplyMarkup(InlineButtonsAuth.getKeyboard(StringsAuthorization.BUTTON_TEXT,
             //   ButtonsCallbacks.loginButton));

        return sendMessage;
    }

    public SendMessage sendMessagePasswordPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsAuthorization.PASSWORD_TEXT);
       // sendMessage.setReplyMarkup(InlineButtonsAuth.getKeyboard(StringsAuthorization.PASSWORD_TEXT,
            //    ButtonsCallbacks.passwordButton));

        return sendMessage;
    }
}

