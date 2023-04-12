package com.htgbot.statemachine;

public class TransData {
    private State state;
    private String serviceText;
    private DataStorage dataStorage;
    private String position;
    private EducationData educationData;
    private long chatId;


    public TransData(long chatId) {
        this.chatId = chatId;
        state = State.START;
        dataStorage = new DataStorage();
        educationData = new EducationData(0,0);
        serviceText = "";
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

    public void setServiceText(String serviceText){
        this.serviceText = serviceText;
    }
    public String getServiceText(){
        return serviceText;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public EducationData getEducationData(){
        return educationData;
    }
}
