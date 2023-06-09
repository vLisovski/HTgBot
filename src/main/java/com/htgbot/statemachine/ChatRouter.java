package com.htgbot.statemachine;

import com.htgbot.dbclasess.DbManager;
import com.htgbot.service.ButtonsCallbacks;
import com.htgbot.service.ServiceManager;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatRouter {
    private Map<Long, TransData> chats;
    private Map<String, State> parseMap;
    private final ServiceManager serviceManager;

    private final DbManager dbManager;

    public ChatRouter() {
        chats = new HashMap<>();
        serviceManager = new ServiceManager();
        dbManager = new DbManager();
        parseMap = new HashMap<>();
        parseMap.put("LOGIN", State.LOGIN);
        parseMap.put("PASSWORD", State.PASSWORD);
        parseMap.put("MAIN_MENU", State.MAIN_MENU);
        parseMap.put("ABOUT", State.ABOUT);
        parseMap.put("EDUCATION", State.EDUCATION);
        parseMap.put("COOK1", State.COOK1);
        parseMap.put("COOK2", State.COOK2);
        parseMap.put("COOK3", State.COOK3);
        parseMap.put("COOK4", State.COOK4);
        parseMap.put("COOK5", State.COOK5);
        parseMap.put("COOK6", State.COOK6);
        parseMap.put("COOK7", State.COOK7);
        parseMap.put("OFFICIANT1", State.OFFICIANT1);
        parseMap.put("OFFICIANT2", State.OFFICIANT2);
        parseMap.put("OFFICIANT3", State.OFFICIANT3);
        parseMap.put("OFFICIANT4", State.OFFICIANT4);
        parseMap.put("OFFICIANT5", State.OFFICIANT5);
        parseMap.put("OFFICIANT6", State.OFFICIANT6);
        parseMap.put("OFFICIANT7", State.OFFICIANT7);
        parseMap.put("BARMAN1", State.BARMAN1);
        parseMap.put("BARMAN2", State.BARMAN2);
        parseMap.put("BARMAN3", State.BARMAN3);
        parseMap.put("BARMAN4", State.BARMAN4);
        parseMap.put("BARMAN5", State.BARMAN5);
        parseMap.put("BARMAN6", State.BARMAN6);
        parseMap.put("BARMAN7", State.BARMAN7);
        parseMap.put("EMPLOYEES", State.EMPLOYEES);
        parseMap.put("EMPLOYEE1", State.EMPLOYEE1);
        parseMap.put("EMPLOYEE2", State.EMPLOYEE2);
        parseMap.put("EMPLOYEE3", State.EMPLOYEE3);
        parseMap.put("EMPLOYEE4", State.EMPLOYEE4);
        parseMap.put("EMPLOYEE5", State.EMPLOYEE5);
        parseMap.put("EMPLOYEE6", State.EMPLOYEE6);
        parseMap.put("SUPPORT", State.SUPPORT);
        parseMap.put("/start", State.START);

    }

    private State parseState(String textData) {
        return parseMap.get(textData);
    }

    private State parseEducationState(String textData) {

        if (textData.equals(State.RESULT.toString())) {
            return State.MAIN_MENU;
        } else if (textData.contains("OFFICIANT1")) {
            return State.OFFICIANT2;
        } else if (textData.contains("OFFICIANT2")) {
            return State.OFFICIANT3;
        } else if (textData.contains("OFFICIANT3")) {
            return State.OFFICIANT4;
        } else if (textData.contains("OFFICIANT4")) {
            return State.OFFICIANT5;
        } else if (textData.contains("OFFICIANT5")) {
            return State.OFFICIANT6;
        } else if (textData.contains("OFFICIANT6")) {
            return State.OFFICIANT7;
        } else if (textData.contains("OFFICIANT7")) {
            return State.RESULT;
        } else if (textData.contains("BARMAN1")) {
            return State.BARMAN2;
        } else if (textData.contains("BARMAN2")) {
            return State.BARMAN3;
        } else if (textData.contains("BARMAN3")) {
            return State.BARMAN4;
        } else if (textData.contains("BARMAN4")) {
            return State.BARMAN5;
        } else if (textData.contains("BARMAN5")) {
            return State.BARMAN6;
        } else if (textData.contains("BARMAN6")) {
            return State.BARMAN7;
        } else if (textData.contains("BARMAN7")) {
            return State.RESULT;
        } else if (textData.contains("COOK1")) {
            return State.COOK2;
        } else if (textData.contains("COOK2")) {
            return State.COOK3;
        } else if (textData.contains("COOK3")) {
            return State.COOK4;
        } else if (textData.contains("COOK4")) {
            return State.COOK5;
        } else if (textData.contains("COOK5")) {
            return State.COOK6;
        } else if (textData.contains("COOK6")) {
            return State.COOK7;
        } else if (textData.contains("COOK7")) {
            return State.RESULT;
        } else if (textData.contains("REST1")) {
            return State.REST2;
        } else if (textData.contains("REST2")) {
            return State.REST3;
        } else if (textData.contains("REST3")) {
            return State.REST4;
        } else if (textData.contains("REST4")) {
            return State.REST5;
        } else if(textData.contains("REST5")){
            return State.REST6;
        } else if (textData.contains("REST6")) {
            return State.MAIN_MENU;
        } else if (textData.contains("GUIDING1")) {
            return State.GUIDING2;
        } else if (textData.contains("GUIDING2")) {
            return State.GUIDING3;
        } else if (textData.contains("GUIDING3")) {
            return State.GUIDING4;
        } else if (textData.contains("GUIDING4")) {
            return State.MAIN_MENU;
        } else {
            return State.MAIN_MENU;
        }
    }

    public SendMessage route(long chatId, String textData) {

        if (!chats.containsKey(chatId)) {
            chats.put(chatId, new TransData(chatId));
        }

        TransData transData = chats.get(chatId);
        transData.setServiceText("");

        if (transData.getState().equals(State.LOGIN)) {
            transData.getDataStorage().add("login", textData);
            transData.setState(State.PASSWORD);
        } else if (transData.getState().equals(State.PASSWORD)) {

            transData.getDataStorage().add("password", textData);

            List<String> passwords = dbManager.getAuthorizeTable().getPassUsers();
            List<String> logins = dbManager.getAuthorizeTable().getLoginUsers();

            if (logins.contains((String) transData.getDataStorage().get("login"))) {
                if (passwords.contains((String) transData.getDataStorage().get("password"))) {

                    int id = dbManager.getAuthorizeTable().getId((String) transData.getDataStorage().get("login"));
                    System.out.println(id);
                    dbManager.getUserTable().setChatId(id,chatId);

                    transData.getDataStorage().clear();
                    transData.setPosition(dbManager.getUserTable().getTypePosition(chatId));
                    transData.setState(State.MAIN_MENU);
                }
            }


        } else if (transData.getState().equals(State.SUPPORT)) {
            if(!textData.equals(ButtonsCallbacks.SUPPORT_BUTTON_BACK)){
                dbManager.getSupportTable().setTextSupportAndChatId(textData,chatId);
                transData.setServiceText("Заявка успешно создана! Ожидайте ответа в разделе поддержки");
                transData.setState(State.MAIN_MENU);
            }
            transData.setState(State.MAIN_MENU);
        } else if (transData.getState().equals(State.EDUCATION)) {

            transData.getEducationData().clearChosenAnswers();

            switch (textData) {
                case "OFFICIANT1": {
                    transData.getEducationData().setNumberQuiz(1);
                    transData.getEducationData().setNumberQuestion(0);
                    transData.setState(State.OFFICIANT1);
                }
                break;
                case "BARMAN1": {
                    transData.getEducationData().setNumberQuiz(2);
                    transData.getEducationData().setNumberQuestion(0);
                    transData.setState(State.BARMAN1);
                }
                break;
                case "COOK1": {
                    transData.getEducationData().setNumberQuiz(3);
                    transData.getEducationData().setNumberQuestion(0);
                    transData.setState(State.COOK1);
                }
                break;
                case "REST1": {
                    transData.getEducationData().setNumberQuiz(4);
                    transData.getEducationData().setNumberQuestion(0);
                    transData.setState(State.REST1);
                }
                break;
                case "GUIDING1": {
                    transData.getEducationData().setNumberQuiz(5);
                    transData.getEducationData().setNumberQuestion(0);
                    transData.setState(State.GUIDING1);
                }
                break;
                default: transData.setState(State.MAIN_MENU);
            }

        } else if (textData.matches("^[a-zA-Z]+\\d{2}$")) {

            int numberOfQuestion = Integer.parseInt(textData.replaceAll("\\D", "")) / 10;
            System.out.println("НОМЕР ВОПРОСА: " +numberOfQuestion);
            int numberOfAnswer = Integer.parseInt(textData.replaceAll("\\D", "")) % 10;

            transData.getEducationData().setNumberQuestion(numberOfQuestion);
            transData.getEducationData().addAnswerToChosenAnswers(numberOfAnswer);
            transData.setState(parseEducationState(textData));
            return serviceManager.getPage(transData);

        } else {
            System.out.println("TEXT DATA CALLBACK: "+textData);
            transData.setState(parseState(textData));
            return serviceManager.getPage(transData);
        }

        return serviceManager.getPage(transData);
    }
}
