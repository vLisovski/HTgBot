package com.htgbot.dbclasess.tables;


import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.Support;
import com.htgbot.dbclasess.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.management.Query;
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

    public void quizStatus(int id) {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {


 session.createQuery("update User u SET u.quizStatus = true WHERE u.id = 1 ", User.class);

        }
    }

    public void setTextSupportAndChatId( int id) {
        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user2 = session.get(User.class,id);
        user2.setQuizStatus(true);
        session.saveOrUpdate(user2);
        transaction.commit();
    }


}

