package com.htgbot.dbclasess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "quiz_game")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number_quiz")
    private int numberQuiz;

    @Column(name = "name_quiz")
    private String nameQuiz;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "photos")
    private String photos;

    public QuizGame(int numberQuiz, String nameQuiz, String answerText, String questionText, String photos) {
        this.numberQuiz = numberQuiz;
        this.nameQuiz = nameQuiz;
        this.answerText = answerText;
        this.questionText = questionText;
        this.photos = photos;
    }

    public int getId() {
        return id;
    }

    public int getNumberQuiz() {
        return numberQuiz;
    }

    public String getNameQuiz() {
        return nameQuiz;
    }

    public String getAnswerText() {
        return answerText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getPhotos() {
        return photos;
    }
}
