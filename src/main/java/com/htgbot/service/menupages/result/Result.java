package com.htgbot.service.menupages.result;

import com.htgbot.dbclasess.DbManager;
import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class Result {
    DbManager dbManager;

    public Result(){
        dbManager = new DbManager();
    }

    private static boolean getEducationResult(TransData transData){

        List<Integer> correctAnswers = new ArrayList<>();
        correctAnswers.add(3);
        correctAnswers.add(1);
        correctAnswers.add(4);
        correctAnswers.add(2);
        correctAnswers.add(1);
        correctAnswers.add(3);
        correctAnswers.add(4);

        return transData.getEducationData().getChosenAnswers().equals(correctAnswers);

    }

    public SendMessage sendResultPage(TransData transData){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());

        if(getEducationResult(transData)){
            sendMessage.setText("Тест выполнен верно!");
        }else {
            sendMessage.setText("Тест выполнен c ошибками. Вернитесь к списку тестов и попробуйте еще раз!");
        }

        sendMessage.setReplyMarkup(InlineButtonsResult.getKeyboard());

        return sendMessage;
    }
}
