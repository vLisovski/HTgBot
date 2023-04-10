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

    public SendMessage route(long chatId, String textData) throws Exception {
        if (!chats.containsKey(chatId)) {
            chats.put(chatId, new TransData(chatId));
        }

        TransData transData = chats.get(chatId);


        return serviceManager.getPage(transData);
    }
}
