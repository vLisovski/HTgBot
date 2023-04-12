package com.htgbot.dbclasess.tables;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.Positions;
import com.htgbot.dbclasess.entities.QuizGame;
import org.hibernate.Session;

import java.util.List;

public class PositionsTable {

    public String getPositionWaiter() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<Positions> query = (List<Positions>) session.createQuery("from Positions WHERE id = 1", Positions.class).list();
            return query.get(0).getType();
        }
    }


    public String getPositionBarmen() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<Positions> query = (List<Positions>) session.createQuery("from Positions WHERE id = 2", Positions.class).list();
            return query.get(0).getType();
        }
    }

    public String getPositionCook() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<Positions> query = (List<Positions>) session.createQuery("from Positions WHERE id = 3", Positions.class).list();
            return query.get(0).getType();
        }
    }
}
