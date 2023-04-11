package com.htgbot.service.menupages.education;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class Education {
    public SendMessage sendEducationPage(TransData transData){

        //TODO методы по доставанию листов викторин и заполнить лист калбеков
        List<String> quizGamesNames = new ArrayList<>();
        List<String> quizGameButtonsCallbacks = new ArrayList<>();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsEducation.EDUCATION_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsEducation.getMainKeyboard(quizGamesNames,quizGameButtonsCallbacks ));

        return sendMessage;
    }

    public SendMessage sendQuizCook1(TransData transData){
        return null;
    }
    public SendMessage sendQuizCook2(TransData transData){
        return null;
    }
    public SendMessage sendQuizCook3(TransData transData){
        return null;
    }
    public SendMessage sendQuizCook4(TransData transData){
        return null;
    }
    public SendMessage sendQuizOfficiant1(TransData transData){
        return null;
    }
    public SendMessage sendQuizOfficiant2(TransData transData){
        return null;
    }
    public SendMessage sendQuizOfficiant3(TransData transData){
        return null;
    }
    public SendMessage sendQuizOfficiant4(TransData transData){
        return null;
    }
    public SendMessage sendQuizBarman1(TransData transData){
        return null;
    }
    public SendMessage sendQuizBarman2(TransData transData){
        return null;
    }
    public SendMessage sendQuizBarman3(TransData transData){
        return null;
    }
    public SendMessage sendQuizBarman4(TransData transData){
        return null;
    }
    public SendMessage sendQuizSafety1(TransData transData){
        return null;
    }
    public SendMessage sendQuizSafety2(TransData transData){
        return null;
    }
    public SendMessage sendQuizSafety3(TransData transData){
        return null;
    }
    public SendMessage sendQuizSafety4(TransData transData){
        return null;
    }
    public SendMessage sendQuizRest1(TransData transData){
        return null;
    }
    public SendMessage sendQuizRest2(TransData transData){
        return null;
    }
    public SendMessage sendQuizRest3(TransData transData){
        return null;
    }
    public SendMessage sendQuizRest4(TransData transData){
        return null;
    }
}
