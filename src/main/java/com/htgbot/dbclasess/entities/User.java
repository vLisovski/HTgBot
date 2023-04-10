package com.htgbot.dbclasess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "chat_id")
    private long chatId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_position")
    private Positions position;

    @Column(name = "names")
    private String names;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "quiz_game")
    private int quizGame;

    @Column(name = "photos")
    private long photos;


}
