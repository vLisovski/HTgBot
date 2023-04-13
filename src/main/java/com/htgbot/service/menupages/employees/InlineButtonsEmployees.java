package com.htgbot.service.menupages.employees;

import com.htgbot.service.ButtonsCallbacks;

import com.htgbot.service.menupages.support.StringsSupport;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineButtonsEmployees {

    public static InlineKeyboardMarkup getMainKeyboard(List<String> employeesNames, List<String> callbacks){

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        for (int i = 0; i < employeesNames.size() ; i++) {
            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText(employeesNames.get(i));
            button.setCallbackData(callbacks.get(i));
            row.add(button);
            keyboard.add(row);
        }

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsEmployees.BUTTON_BACK_TEXT);
        button.setCallbackData(ButtonsCallbacks.EMPLOYEES_BUTTON_BACK);
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getBackKeyboard(){

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsEmployees.BUTTON_BACK_TEXT);
        button.setCallbackData(ButtonsCallbacks.EMPLOYEE_BUTTON_BACK);
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}

