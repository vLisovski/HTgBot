package com.htgbot.service.menupages.education;

import com.htgbot.dbclasess.DbManager;
import com.htgbot.statemachine.State;
import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

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

        quizGameButtonsCallbacks.add("GUIDING1");
        quizGameButtonsCallbacks.add("REST1");

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
                if(transData.getState().toString().contains("REST")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
                }
                if(transData.getState().toString().contains("GUIDING")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
                }
            } else if (transData.getPosition().equals("Повар")) {
                questionsString = dbManager.getQuizGameTable().getQuestionGameFromCook();
                answersString = dbManager.getQuizGameTable().getAnswerFromCook();
                if(transData.getState().toString().contains("REST")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
                }
                if(transData.getState().toString().contains("GUIDING")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
                }
            } else {
                questionsString = dbManager.getQuizGameTable().getQuestionFromWaiter();
                answersString = dbManager.getQuizGameTable().getAnswerFromWaiter();
                if(transData.getState().toString().contains("REST")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
                }
                if(transData.getState().toString().contains("GUIDING")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
                }
            }
        } else if (transData.getState().toString().contains("REST")) {
            questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
            answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
        } else {
            questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
            answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
        }

        int numberOfQuestion = transData.getEducationData().getNumberQuestion();

        List<String> answersList = new ArrayList<>();

        if(transData.getState().toString().contains("REST")||transData.getState().toString().contains("GUIDING")){
            List<String> answ = UtilEducation
                    .parseStringToStringList(answersString,"/");
            answersList.add(answ.get(numberOfQuestion));
            System.out.println("ВЕТКА 1:"+answersList);
        } else {
            answersList = UtilEducation
                    .parseStringToStringList(
                            (UtilEducation.parseStringToStringList(answersString, "/").get(numberOfQuestion)), "\\.");
            System.out.println("ВЕТКА 2:"+answersList);
        }

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

    public SendPhoto sendQuizPageWithPhoto(TransData transData) {

        String questionsString;
        String answersString;

        if (!dbManager.getUserTable().getQuizStatus(transData.getChatId())) {
            if (transData.getPosition().equals("Бармен")) {
                questionsString = dbManager.getQuizGameTable().getQuestionGameFromBarmen();
                answersString = dbManager.getQuizGameTable().getAnswerFromBarmen();
                if(transData.getState().toString().contains("REST")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
                }
                if(transData.getState().toString().contains("GUIDING")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
                }
            } else if (transData.getPosition().equals("Повар")) {
                questionsString = dbManager.getQuizGameTable().getQuestionGameFromCook();
                answersString = dbManager.getQuizGameTable().getAnswerFromCook();
                if(transData.getState().toString().contains("REST")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
                }
                if(transData.getState().toString().contains("GUIDING")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
                }
            } else {
                questionsString = dbManager.getQuizGameTable().getQuestionFromWaiter();
                answersString = dbManager.getQuizGameTable().getAnswerFromWaiter();
                if(transData.getState().toString().contains("REST")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
                }
                if(transData.getState().toString().contains("GUIDING")){
                    questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
                    answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
                }
            }
        } else if (transData.getState().toString().contains("REST")) {
            questionsString = dbManager.getQuizGameTable().getQuestionGameFromRestaurant();
            answersString = dbManager.getQuizGameTable().getQuizAnswers(4);
        } else {
            questionsString = dbManager.getQuizGameTable().getQuestionGameFromAdministration();
            answersString = dbManager.getQuizGameTable().getQuizAnswers(5);
        }

        int numberOfQuestion = transData.getEducationData().getNumberQuestion();

        List<String> answersList = new ArrayList<>();

        if(transData.getState().toString().contains("REST")||transData.getState().toString().contains("GUIDING")){
            List<String> answ = UtilEducation
                    .parseStringToStringList(answersString,"/");
            answersList.add(answ.get(numberOfQuestion));
            System.out.println("ВЕТКА 1:"+answersList);
        } else {
            answersList = UtilEducation
                    .parseStringToStringList(
                            (UtilEducation.parseStringToStringList(answersString, "/").get(numberOfQuestion)), "\\.");
            System.out.println("ВЕТКА 2:"+answersList);
        }

        List<String> quizGameButtonsCallbacks = InlineButtonsEducation.getQuizGameButtonsCallbacks(transData);
        System.out.println("QUIZ BUTTONS CALLBACKS:" + quizGameButtonsCallbacks);

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(transData.getChatId());
        sendPhoto.setCaption(
                UtilEducation.parseStringToStringList(questionsString, "/")
                        .get(numberOfQuestion));

        sendPhoto.setReplyMarkup(InlineButtonsEducation.getQuizKeyboard(answersList, quizGameButtonsCallbacks));

        InputFile inputFile = new InputFile();

        if(transData.getState().toString().contains("REST")||transData.getState().toString().contains("GUIDING")){
            inputFile = new InputFile("C:\\Users\\Vladislav\\IdeaProjects\\HTgBot\\src\\main\\resources" +
                    "\\Photos\\Guiding\\" + numberOfQuestion + ".jpg");
        } else {
            inputFile = new InputFile("C:\\Users\\Vladislav\\IdeaProjects\\HTgBot\\src\\main\\resources" +
                    "\\Photos\\Rest\\" + numberOfQuestion + ".jpg");
        }

        sendPhoto.setPhoto(inputFile);

        return sendPhoto;
    }

}
