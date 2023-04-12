package com.htgbot.service.menupages.education;

import com.htgbot.dbclasess.DbManager;
import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Education {

    private final DbManager dbManager;

    public Education() {
        dbManager = new DbManager();
    }

    public SendMessage sendEducationPage(TransData transData) {

        //нужен метод для получения квиза нужной профессии + знакомство с рестораном + квиз руководство
        // List<String> quizGamesNames = dbManager.getQuizGameTable().getQuizGameNames(transData.getPosition());
        List<String> quizGamesNames = new ArrayList<>();
        quizGamesNames.add("Оффициант");
        quizGamesNames.add("Бармен");
        quizGamesNames.add("Повар");
        List<String> quizGameButtonsCallbacks = new ArrayList<>();

        String position = transData.getPosition();

        if (position.equals("Барен")) {
            quizGameButtonsCallbacks.add("BARMAN1");
        } else if (position.equals("Повар")) {
            quizGameButtonsCallbacks.add("COOK1");
        } else {
            quizGameButtonsCallbacks.add("OFFICIANT1");
        }

        quizGameButtonsCallbacks.add("REST1");
        quizGameButtonsCallbacks.add("GUIDING1");

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsEducation.EDUCATION_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsEducation.getMainKeyboard(quizGamesNames, quizGameButtonsCallbacks));

        return sendMessage;
    }

    public SendMessage sendQuizPage(TransData transData) {

//        if(transData.getPosition().equals("Бармен")){
//            String questionsString = dbManager.getQuizGameTable().getQuestionGameFromBarmen();
//        } else if (transData.getPosition().equals("Повар")) {
//            String questionsString = dbManager.getQuizGameTable().getQuestionGameFromCook();
//        } else {
//            String questionsString = dbManager.getQuizGameTable().getQuestionFromWaiter();
//        }

        String questionsString = "1. Будете ли вы наливать напитки своим друзьям или родственникам бесплатно?" +
                "/2. В каком коктейле присутствует водка?" +
                "/3. Как общаться с клиентом?" +
                "/4. В чем вы будете работать?" +
                "/5. Разрешено ли быть на работе в шляпе?" +
                "/6. Что используют для смешивания коктейлей?" +
                "/7. Что используют для подачи крепких напитков?";

        int numberOfQuestion = transData.getEducationData().getNumberQuestion();

        String answersString = "aa bb cc dd/ee ff gg hh/ii jj kk ll/mm oo pp qq/rr ss tt ii";
        List<String> answersList = UtilEducation
                .parseStringToStringList(
                        (UtilEducation.parseStringToStringList(answersString, "/").get(numberOfQuestion)), " ");

        List<String> quizGameButtonsCallbacks = InlineButtonsEducation.getQuizGameButtonsCallbacks(transData);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(
                UtilEducation.parseStringToStringList(questionsString, "/")
                        .get(numberOfQuestion));
        sendMessage.setReplyMarkup(InlineButtonsEducation.getQuizKeyboard(answersList, quizGameButtonsCallbacks));

        return sendMessage;
    }

}
