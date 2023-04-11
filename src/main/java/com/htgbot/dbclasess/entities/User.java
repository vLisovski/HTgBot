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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_game")
    private QuizGame quizGame;


    @Column(name = "photos")
    private long photos;

    public User(long chatId, Positions position, String names, String contacts, QuizGame quizGame, long photos) {
        this.chatId = chatId;
        this.position = position;
        this.names = names;
        this.contacts = contacts;
        this.quizGame = quizGame;
        this.photos = photos;
    }

    public int getId() {
        return id;
    }

    public long getChatId() {
        return chatId;
    }

    public Positions getPosition() {
        return position;
    }

    public String getNames() {
        return names;
    }

    public String getContacts() {
        return contacts;
    }

    public long getPhotos() {
        return photos;
    }
}
