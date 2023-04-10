package com.htgbot.service;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface Service {
    SendMessage sendPage(TransData transData);
}
