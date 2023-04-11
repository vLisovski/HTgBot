package com.htgbot.service.menupages.education;

import com.htgbot.service.ButtonsCallbacks;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineButtonsEducation {
    public static InlineKeyboardMarkup getMainKeyboard(List<String> quizGamesNames, List<String> quizGameButtonsCallbacks){

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        for (int i = 0; i < quizGamesNames.size() ; i++) {
            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText(quizGamesNames.get(i));
            button.setCallbackData(quizGameButtonsCallbacks.get(i));
            row.add(button);
            keyboard.add(row);
        }

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsEducation.BUTTON_BACK_TEXT);
        button.setCallbackData(ButtonsCallbacks.EDUCATION_BUTTON_BACK);
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getQuizKeyboard(List<String> answers, List<String> quizGameButtonsCallbacks){

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        for (int i = 0; i < answers.size() ; i++) {
            row = new ArrayList<>();
            button = new InlineKeyboardButton();
            button.setText(answers.get(i));
            button.setCallbackData(quizGameButtonsCallbacks.get(i));
            row.add(button);
            keyboard.add(row);
        }

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(StringsEducation.BUTTON_BACK_TEXT);
        button.setCallbackData(ButtonsCallbacks.EDUCATION_BUTTON_BACK);
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;

    }


}
