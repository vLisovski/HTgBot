package com.htgbot.service.menupages.guiding;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Guiding {

    public SendMessage sendGuidingPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsGuiding.GUIDING_MENU_TEXT);

        return sendMessage;

    }
}
