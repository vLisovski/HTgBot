package com.htgbot.service.menupages.employees;

import com.htgbot.dbclasess.DbManager;
import com.htgbot.statemachine.State;
import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private final DbManager dbManager;

    public Employees() {
        dbManager = new DbManager();
    }

    public SendMessage sendEmployeesMainPage(TransData transData) {

        List<String> employeesNamesFull = dbManager.getUserTable().getAllUsersNames();
        List<String> employeesNames = employeesNamesFull.subList(0, 5);//для демонстрации
        List<String> callbacks = new ArrayList<>();
        callbacks.add(State.EMPLOYEE1.toString());
        callbacks.add(State.EMPLOYEE2.toString());
        callbacks.add(State.EMPLOYEE3.toString());
        callbacks.add(State.EMPLOYEE4.toString());
        callbacks.add(State.EMPLOYEE5.toString());
        callbacks.add(State.EMPLOYEE6.toString());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(transData.getChatId());
        sendMessage.setText(StringsEmployees.EMPLOYEES_TEXT);
        sendMessage.setReplyMarkup(InlineButtonsEmployees.getMainKeyboard(employeesNames, callbacks));

        return sendMessage;
    }

    public SendMessage sendEmployeePage(TransData transData) {

        List<String> employeesNamesFull = dbManager.getUserTable().getAllUsersNames();
        List<String> employeesContacts = dbManager.getUserTable().getAllUsersContacts();
        SendMessage sendMessage = new SendMessage();

        switch (transData.getState()) {
            case EMPLOYEE1: {
                sendMessage.setChatId(transData.getChatId());
                sendMessage.setText(employeesNamesFull.get(0) + "\n\n" + employeesContacts.get(0));
                sendMessage.setReplyMarkup(InlineButtonsEmployees.getBackKeyboard());
            }
            break;
            case EMPLOYEE2: {
                sendMessage.setChatId(transData.getChatId());
                sendMessage.setText(employeesNamesFull.get(1) + "\n\n" + employeesContacts.get(1));
                sendMessage.setReplyMarkup(InlineButtonsEmployees.getBackKeyboard());
            }
            break;
            case EMPLOYEE3: {
                sendMessage.setChatId(transData.getChatId());
                sendMessage.setText(employeesNamesFull.get(2) + "\n\n" + employeesContacts.get(2));
                sendMessage.setReplyMarkup(InlineButtonsEmployees.getBackKeyboard());
            }
            break;
            case EMPLOYEE4: {
                sendMessage.setChatId(transData.getChatId());
                sendMessage.setText(employeesNamesFull.get(3) + "\n\n" + employeesContacts.get(3));
                sendMessage.setReplyMarkup(InlineButtonsEmployees.getBackKeyboard());
            }
            break;
            case EMPLOYEE5: {
                sendMessage.setChatId(transData.getChatId());
                sendMessage.setText(employeesNamesFull.get(4) + "\n\n" + employeesContacts.get(4));
                sendMessage.setReplyMarkup(InlineButtonsEmployees.getBackKeyboard());
            }
            break;
            case EMPLOYEE6: {
                sendMessage.setChatId(transData.getChatId());
                sendMessage.setText(employeesNamesFull.get(5) + "\n\n" + employeesContacts.get(5));
                sendMessage.setReplyMarkup(InlineButtonsEmployees.getBackKeyboard());
            }
            break;
        }

        return sendMessage;
    }
}
