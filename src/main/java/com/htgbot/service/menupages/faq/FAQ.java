package com.htgbot.service.menupages.faq;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class FAQ {
    public SendMessage sendFAQPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsFAQ.FAQ_TEXT);

        return sendMessage;

    }
}
