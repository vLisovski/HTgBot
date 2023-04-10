package com.htgbot.statemachine;

public class TransData {
    private State state;
    private DataStorage dataStorage;
    private long chatId;

    public TransData(long chatId) {
        this.chatId = chatId;
        state = State.LOGIN;
        dataStorage = new DataStorage();
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }

    public DataStorage getDataStorage() {
        return dataStorage;
    }
    public long getChatId() {
        return chatId;
    }
}
