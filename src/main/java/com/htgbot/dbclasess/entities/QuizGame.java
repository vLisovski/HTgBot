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
    private int nameQuiz;

    @Column(name = "answer_text")
    private int answerText;

    @Column(name = "question_text")
    private int questionText;

    @Column(name = "photos")
    private int photos;

}
