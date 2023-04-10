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
        button.setCallbackData(ButtonsCallbacks.mainMenuButtonQuizGame);
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsMain.MAIN_MENU_BUTTON_GUIDING_TEXT);
        button.setCallbackData(ButtonsCallbacks.mainMenuButtonGuiding);
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsMain.MAIN_MENU_BUTTON_EMPLOYEES_TEXT);
        button.setCallbackData(ButtonsCallbacks.mainMenuButtonEmployees);
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsMain.MAIN_MENU_BUTTON_ABOUT_TEXT);
        button.setCallbackData(ButtonsCallbacks.mainMenuButtonAbout);
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsMain.MAIN_MENU_BUTTON_FAQ_TEXT);
        button.setCallbackData(ButtonsCallbacks.mainMenuButtonFAQ);
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsMain.MAIN_MENU_BUTTON_SUPPORT_TEXT);
        button.setCallbackData(ButtonsCallbacks.mainMenuButtonSupport);
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}
