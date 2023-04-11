package com.htgbot.service.menupages.guiding;

import com.htgbot.service.ButtonsCallbacks;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineButtonsGuiding {

    //TODO кнопки с сотрудниками и просмотр информации по ним при нажатии
    //fuck
    public static InlineKeyboardMarkup getKeyboard(){

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsGuiding.BUTTON_BACK_TEXT);
        button.setCallbackData(ButtonsCallbacks.GUIDING_BUTTON_BACK);
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}
