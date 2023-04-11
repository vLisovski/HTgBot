package com.htgbot.dbclasess.tables;


import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.User;
import com.htgbot.statemachine.TransData;
import org.hibernate.Session;


import java.util.List;

public class UserTable {
    // waiter - официант
    public List<User> getWaiterUsers() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<User>) session.createQuery("from User WHERE quizGame.numberQuiz = 1 ", User.class).list();
        }
    }

    public List<User> getBarmanUsers() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<User>) session.createQuery("from User WHERE quizGame.numberQuiz = 2 ", User.class).list();
        }
    }

    public List<User> getCookUsers() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<User>) session.createQuery("from User WHERE quizGame.numberQuiz = 3 ", User.class).list();
        }
    }

}

