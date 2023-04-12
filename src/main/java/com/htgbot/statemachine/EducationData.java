package com.htgbot.statemachine;

import java.util.ArrayList;
import java.util.List;

public class EducationData {

    private int numberQuiz;
    private int numberQuestion;
    private List<Integer> chosenAnswers;

    public EducationData(int numberQuiz, int numberQuestion) {

        this.numberQuiz = numberQuiz;
        this.numberQuestion = numberQuestion;
        chosenAnswers = new ArrayList<>();
    }

    public void setNumberQuiz(int numberQuiz) {
        this.numberQuiz = numberQuiz;
    }
    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }
    public int getNumberQuiz() {
        return numberQuiz;
    }
    public int getNumberQuestion() {
        return numberQuestion;
    }

    public List<Integer> getChosenAnswers(){
        return chosenAnswers;
    }

    public void addAnswerToChosenAnswers(int answer){
        chosenAnswers.add(answer);
    }
    public void clearChosenAnswers(){
        chosenAnswers.clear();
    }
}
