package com.htgbot.service.menupages.education;

import com.htgbot.service.ButtonsCallbacks;
import com.htgbot.statemachine.TransData;
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

    public static InlineKeyboardMarkup getQuizKeyboard(List<String> answers,  List<String> quizGameButtonsCallbacks){

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        for (int i = 0; i < answers.size() ; i++) {
            row = new ArrayList<>();
            quizGameButtonsCallbacks.add(answers.get(i));
            button = new InlineKeyboardButton();
            button.setText(answers.get(i));
            button.setCallbackData(quizGameButtonsCallbacks.get(i));
            row.add(button);
            keyboard.add(row);
        }

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;

    }

    private static List<String> getCallbacksToListFromStatesList(TransData transData, List<String> callbacks){

        int numberOfQuestion = transData.getEducationData().getNumberQuestion();
        List<String> quizGameButtonsCallbacks = new ArrayList<>();
        switch (numberOfQuestion){
            case 1:{
                quizGameButtonsCallbacks.add(callbacks.get(0));
                quizGameButtonsCallbacks.add(callbacks.get(1));
                quizGameButtonsCallbacks.add(callbacks.get(2));
                quizGameButtonsCallbacks.add(callbacks.get(3));
            }break;
            case 2:{
                quizGameButtonsCallbacks.add(callbacks.get(4));
                quizGameButtonsCallbacks.add(callbacks.get(5));
                quizGameButtonsCallbacks.add(callbacks.get(6));
                quizGameButtonsCallbacks.add(callbacks.get(7));
            }break;
            case 3:{
                quizGameButtonsCallbacks.add(callbacks.get(8));
                quizGameButtonsCallbacks.add(callbacks.get(9));
                quizGameButtonsCallbacks.add(callbacks.get(10));
                quizGameButtonsCallbacks.add(callbacks.get(11));
            }break;
            case 4:{
                quizGameButtonsCallbacks.add(callbacks.get(12));
                quizGameButtonsCallbacks.add(callbacks.get(13));
                quizGameButtonsCallbacks.add(callbacks.get(14));
                quizGameButtonsCallbacks.add(callbacks.get(15));
            }break;
            case 5:{
                quizGameButtonsCallbacks.add(callbacks.get(16));
                quizGameButtonsCallbacks.add(callbacks.get(17));
                quizGameButtonsCallbacks.add(callbacks.get(18));
                quizGameButtonsCallbacks.add(callbacks.get(19));
            }break;
            case 6:{
                quizGameButtonsCallbacks.add(callbacks.get(20));
                quizGameButtonsCallbacks.add(callbacks.get(21));
                quizGameButtonsCallbacks.add(callbacks.get(22));
                quizGameButtonsCallbacks.add(callbacks.get(23));
            }break;
            case 7:{
                quizGameButtonsCallbacks.add(callbacks.get(24));
                quizGameButtonsCallbacks.add(callbacks.get(25));
                quizGameButtonsCallbacks.add(callbacks.get(26));
                quizGameButtonsCallbacks.add(callbacks.get(27));
            }break;
        }
        return quizGameButtonsCallbacks;
    }
    public static List<String> getQuizGameButtonsCallbacks(TransData transData){

        int numberOfQuiz = transData.getEducationData().getNumberQuiz();
        List<String> quizGameButtonsCallbacks;

        if(numberOfQuiz == 1){
            List<String> callbacks = new ArrayList<>();
            callbacks.add("OFFICIANT11"); callbacks.add("OFFICIANT31"); callbacks.add("OFFICIANT51"); callbacks.add("OFFICIANT71");
            callbacks.add("OFFICIANT12"); callbacks.add("OFFICIANT32"); callbacks.add("OFFICIANT52"); callbacks.add("OFFICIANT72");
            callbacks.add("OFFICIANT13"); callbacks.add("OFFICIANT33"); callbacks.add("OFFICIANT53"); callbacks.add("OFFICIANT73");
            callbacks.add("OFFICIANT14"); callbacks.add("OFFICIANT34"); callbacks.add("OFFICIANT54"); callbacks.add("OFFICIANT74");

            callbacks.add("OFFICIANT21"); callbacks.add("OFFICIANT41"); callbacks.add("OFFICIANT61");
            callbacks.add("OFFICIANT22"); callbacks.add("OFFICIANT42"); callbacks.add("OFFICIANT62");
            callbacks.add("OFFICIANT23"); callbacks.add("OFFICIANT43"); callbacks.add("OFFICIANT63");
            callbacks.add("OFFICIANT24"); callbacks.add("OFFICIANT44"); callbacks.add("OFFICIANT64");
            quizGameButtonsCallbacks = getCallbacksToListFromStatesList(transData, callbacks);
        } else if (numberOfQuiz == 2) {
            List<String> callbacks = new ArrayList<>();
            callbacks.add("BARMAN11"); callbacks.add("BARMAN31"); callbacks.add("BARMAN51"); callbacks.add("BARMAN71");
            callbacks.add("BARMAN12"); callbacks.add("BARMAN32"); callbacks.add("BARMAN52"); callbacks.add("BARMAN72");
            callbacks.add("BARMAN13"); callbacks.add("BARMAN33"); callbacks.add("BARMAN53"); callbacks.add("BARMAN73");
            callbacks.add("BARMAN14"); callbacks.add("BARMAN34"); callbacks.add("BARMAN54"); callbacks.add("BARMAN74");

            callbacks.add("BARMAN21"); callbacks.add("BARMAN41"); callbacks.add("BARMAN61");
            callbacks.add("BARMAN22"); callbacks.add("BARMAN42"); callbacks.add("BARMAN62");
            callbacks.add("BARMAN23"); callbacks.add("BARMAN43"); callbacks.add("BARMAN63");
            callbacks.add("BARMAN24"); callbacks.add("BARMAN44"); callbacks.add("BARMAN64");
            quizGameButtonsCallbacks = getCallbacksToListFromStatesList(transData, callbacks);
        } else if (numberOfQuiz == 3) {
            List<String> callbacks = new ArrayList<>();
            callbacks.add("COOK11"); callbacks.add("COOK31"); callbacks.add("COOK51"); callbacks.add("COOK71");
            callbacks.add("COOK12"); callbacks.add("COOK32"); callbacks.add("COOK52"); callbacks.add("COOK72");
            callbacks.add("COOK13"); callbacks.add("COOK33"); callbacks.add("COOK53"); callbacks.add("COOK73");
            callbacks.add("COOK14"); callbacks.add("COOK34"); callbacks.add("COOK54"); callbacks.add("COOK74");

            callbacks.add("COOK21"); callbacks.add("COOK41"); callbacks.add("COOK61");
            callbacks.add("COOK22"); callbacks.add("COOK42"); callbacks.add("COOK62");
            callbacks.add("COOK23"); callbacks.add("COOK43"); callbacks.add("COOK63");
            callbacks.add("COOK24"); callbacks.add("COOK44"); callbacks.add("COOK64");
            quizGameButtonsCallbacks = getCallbacksToListFromStatesList(transData, callbacks);
        } else if (numberOfQuiz == 4) {
            List<String> callbacks = new ArrayList<>();
            callbacks.add("REST11"); callbacks.add("REST31");
            callbacks.add("REST12"); callbacks.add("REST32");
            callbacks.add("REST13"); callbacks.add("REST33");
            callbacks.add("REST14"); callbacks.add("REST34");

            callbacks.add("REST21"); callbacks.add("REST41");
            callbacks.add("REST22"); callbacks.add("REST42");
            callbacks.add("REST23"); callbacks.add("REST43");
            callbacks.add("REST24"); callbacks.add("REST44");
            quizGameButtonsCallbacks = getCallbacksToListFromStatesList(transData, callbacks);
        } else {
            List<String> callbacks = new ArrayList<>();
            callbacks.add("GUIDING11"); callbacks.add("GUIDING31");
            callbacks.add("GUIDING12"); callbacks.add("GUIDING32");
            callbacks.add("GUIDING13"); callbacks.add("GUIDING33");
            callbacks.add("GUIDING14"); callbacks.add("GUIDING34");

            callbacks.add("GUIDING21"); callbacks.add("GUIDING41");
            callbacks.add("GUIDING22"); callbacks.add("GUIDING42");
            callbacks.add("GUIDING23"); callbacks.add("GUIDING43");
            callbacks.add("GUIDING24"); callbacks.add("GUIDING44");
            quizGameButtonsCallbacks = getCallbacksToListFromStatesList(transData, callbacks);
        }

        return quizGameButtonsCallbacks;
    }


}
