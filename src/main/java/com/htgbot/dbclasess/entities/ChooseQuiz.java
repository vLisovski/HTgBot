package com.htgbot.dbclasess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "choose_quiz")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChooseQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number_quiz")
    private int numberQuiz;


}
