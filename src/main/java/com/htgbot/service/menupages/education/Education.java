package com.htgbot.service.menupages.education;

import com.htgbot.dbclasess.DbManager;
import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class Education {

    private final DbManager dbManager;

    public Education() {
        dbManager = new DbManager();
    }

    public SendMessage sendEducationPage(TransData transData) {

        boolean quizStatus = dbManager.getUserTable().getQuizStatus(transData.getChatId());

        List<String> quizGamesNames = dbManager.getQuizGameTable().getQuizNamesList();

        List<String> quizGameButtonsCallbacks = new ArrayList<>();

        String position = transData.getPosition();

        if (!quizStatus) {
            if (position.equals("Бармен")) {
                quizGameButtonsCallbacks.add("BARMAN1");
                quizGamesNames.remove("Оффициант");
                quizGamesNames.remove("Повар");

            } else if (position.equals("Повар")) {
                quizGameButtonsCallbacks.add("COOK1");
                quizGamesNames.remove("Оффициант");
                quizGamesNames.remove("Бармен");

            } else {
                quizGameButtonsCallbacks.add("OFFICIANT1");
                quizGamesNames.remove("Повар");
                quizGamesNames.remove("Бармен");
            }
        } else {
            quizGamesNames.remove("Оффициант");
            quizGamesNames.remove("Повар");
            quizGamesNames.remove("Бармен");
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

        String questionsString;
        String answersString;

        if (!dbManager.getUserTable().getQuizStatus(transData.getChatId())) {
            if (transData.getPosition().equals("Бармен")) {
                questionsString = dbManager.getQuizGameTable().getQuestionGameFromBarmen();
                answersString = dbManager.getQuizGameTable().getAnswerFromBarmen();
            } else if (transData.getPosition().equals("Повар")) {
                questionsString = dbManager.getQuizGameTable().getQuestionGameFromCook();
                answersString = dbManager.getQuizGameTable().getAnswerFromCook();
            } else {
                questionsString = dbManager.getQuizGameTable().getQuestionFromWaiter();
                answersString = dbManager.getQuizGameTable().getAnswerFromWaiter();
            }
        } else if (transData.getState().toString().contains("REST")) {
            questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
            answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
        } else {
            questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
            answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
        }

        int numberOfQuestion = transData.getEducationData().getNumberQuestion();

        List<String> answersList = UtilEducation
                .parseStringToStringList(
                        (UtilEducation.parseStringToStringList(answersString, "/").get(numberOfQuestion)), "\\.");
        System.out.println(answersList);

        List<String> quizGameButtonsCallbacks = InlineButtonsEducation.getQuizGameButtonsCallbacks(transData);
        System.out.println("QUIZ BUTTONS CALLBACKS:" + quizGameButtonsCallbacks);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(
                UtilEducation.parseStringToStringList(questionsString, "/")
                        .get(numberOfQuestion));

        sendMessage.setReplyMarkup(InlineButtonsEducation.getQuizKeyboard(answersList, quizGameButtonsCallbacks));

        return sendMessage;
    }

}
