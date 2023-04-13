package com.htgbot.service.menupages.mainmenu;

import com.htgbot.service.ButtonsCallbacks;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineButtonsMain {

    public static InlineKeyboardMarkup getKeyboard(){

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsMain.MAIN_MENU_BUTTON_QUIZ_GAME_TEXT);
        button.setCallbackData(ButtonsCallbacks.MAIN_MENU_BUTTON_EDUCATION);
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsMain.MAIN_MENU_BUTTON_EMPLOYEES_TEXT);
        button.setCallbackData(ButtonsCallbacks.MAIN_MENU_BUTTON_EMPLOYEES);
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsMain.MAIN_MENU_BUTTON_SUPPORT_TEXT);
        button.setCallbackData(ButtonsCallbacks.MAIN_MENU_BUTTON_SUPPORT);
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}
