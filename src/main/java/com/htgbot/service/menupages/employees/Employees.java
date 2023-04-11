package com.htgbot.service.menupages.employees;

import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Employees {
    public SendMessage sendEmployeesPage(TransData transData){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsEmployees.EMPLOYEES_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsEmployees.getKeyboard());

        return sendMessage;
    }
}
