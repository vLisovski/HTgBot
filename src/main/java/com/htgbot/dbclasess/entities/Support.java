package com.htgbot.dbclasess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Table(name = "support")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Support {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text_from_support")
    private String textFromSupport;

    @Column(name = "chat_id")
    private long chatId;
}