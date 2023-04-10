package com.htgbot.dbclasess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "quiz_text")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class QuizText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text_quiz")
    private String textQuiz;
}
