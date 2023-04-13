package com.htgbot.dbclasess.tables;


import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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

    public void setQuizStatusTrue(int id) {
        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        user.setQuizStatus(true);
        session.saveOrUpdate(user);
        transaction.commit();
    }

    public int getUserId(long chatId){
        Session session = DbConnection.getInstance().getSessionFactory().openSession();

        String queryString = "select id from User where chatId=:chatId";
        Query query = session.createQuery(queryString);
        query.setParameter("chatId",chatId);

        return (Integer) query.list().get(0);
    }

    public boolean getQuizStatus(long chatId){
        Session session = DbConnection.getInstance().getSessionFactory().openSession();

        String queryString = "select quizStatus from User where chatId=:chatId";
        Query query = session.createQuery(queryString);
        query.setParameter("chatId",chatId);

        return (Boolean) query.list().get(0);
    }





    public void setChatId(int id, long chat_id) {
        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        user.setChatId(chat_id);
        session.saveOrUpdate(user);
        transaction.commit();
    }

    public String getTypePosition(long chatId){

        Session session = DbConnection.getInstance().getSessionFactory().openSession();

        String queryString = "select position.type from User where chatId=:chatId";
        Query query = session.createQuery(queryString);
        query.setParameter("chatId",chatId);

        return (String) query.list().get(0);

    }

    public List<String> getAllUsersNames() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return  session.createQuery("select names from User", String.class).list();
        }
    }

    public List<String> getAllUsersContacts() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return  session.createQuery("select contacts from User", String.class).list();
        }
    }


}

