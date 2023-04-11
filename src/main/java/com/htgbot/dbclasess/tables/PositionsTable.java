package com.htgbot.dbclasess.tables;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.Positions;
import com.htgbot.dbclasess.entities.QuizGame;
import org.hibernate.Session;

import java.util.List;

public class PositionsTable {
    public Positions getWaiter() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (Positions) session.createQuery("select type from Positions where id = 1", QuizGame.class).list();
        }
    }

    public Positions getBarmen() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (Positions) session.createQuery("select type from Positions where id = 2", QuizGame.class).list();
        }
    }

    public Positions getCook() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (Positions) session.createQuery("select type from Positions where id = 3", QuizGame.class).list();
        }
    }
}
