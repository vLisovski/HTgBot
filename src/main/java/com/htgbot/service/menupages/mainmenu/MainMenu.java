package com.htgbot.service.menupages.mainmenu;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class MainMenu {

    public SendMessage sendMainMenuPage(TransData transData) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsMain.MAIN_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsMain.getKeyboard());

        return sendMessage;
    }
}