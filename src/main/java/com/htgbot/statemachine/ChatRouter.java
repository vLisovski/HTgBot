package com.htgbot.statemachine;

import com.htgbot.service.ServiceManager;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.HashMap;
import java.util.Map;

public class ChatRouter {
    private Map<Long, TransData> chats;
    private ServiceManager serviceManager;

    public ChatRouter() throws Exception {
        chats = new HashMap<>();
        serviceManager = new ServiceManager();
    }

    private State parseState(String textData) {

        return switch (textData) {
            case "LOGIN"->State.LOGIN;
            case "PASSWORD"->State.PASSWORD;
            case "MAIN_MENU" -> State.MAIN_MENU;
            case "ABOUT" -> State.ABOUT;
            case "EDUCATION" -> State.EDUCATION;
            case "EMPLOYEES" -> State.EMPLOYEES;
            case "FAQ" -> State.FAQ;
            case "GUIDING" -> State.GUIDING;
            case "SUPPORT" -> State.SUPPORT;
            case "/start" -> State.START;
            default -> State.MAIN_MENU;
        };

    }

    public SendMessage route(long chatId, String textData) throws Exception {

        if (!chats.containsKey(chatId)) {
            chats.put(chatId, new TransData(chatId));
        }

        TransData transData = chats.get(chatId);

        if (transData.getState().equals(State.LOGIN)) {
            transData.getDataStorage().add("login", textData);
            transData.setState(State.PASSWORD);
        } else if (transData.getState().equals(State.PASSWORD)) {
            transData.getDataStorage().add("password", textData);
            System.out.println("AUTHORIZE: LOGIN - "+transData.getDataStorage().get("login")
                    +" PASSWORD - "+transData.getDataStorage().get("password"));
            transData.setState(State.MAIN_MENU);
        } else {
            transData.setState(parseState(textData));
        }

        return serviceManager.getPage(transData);
    }
}
