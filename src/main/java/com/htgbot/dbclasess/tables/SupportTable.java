package com.htgbot.dbclasess.tables;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.QuizGame;
import com.htgbot.dbclasess.entities.Support;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SupportTable {


    public void setTextSupportAndChatId(String supportText, long chatId) {
        Session session = DbConnection.getInstance().getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        Support support = new Support();
        support.setTextFromSupport(supportText);
        support.setChatId(chatId);
        session.save(support);
        transaction.commit();
    }


}
