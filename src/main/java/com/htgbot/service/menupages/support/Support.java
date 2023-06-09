package com.htgbot.service.menupages.support;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Support {

    public SendMessage sendEnterAppealPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsSupport.SUPPORT_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsSupport.getKeyboard());

        return sendMessage;
    }
}
