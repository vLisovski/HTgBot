package com.htgbot.dbclasess.tables;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.Authorize;
import com.htgbot.dbclasess.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorizeTable {

    public List<String> getLoginUsers() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<String>) session.createQuery("select login from Authorize ", String.class).list();
        }
    }
    public List<String> getPassUsers() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<String>) session.createQuery("select password from Authorize ", String.class).list();
        }
    }

    public int getId(String login){

        Session session = DbConnection.getInstance().getSessionFactory().openSession();

        String queryString = "select id from Authorize where login=:login";
        Query query = session.createQuery(queryString);
        query.setParameter("login",login);

        return (Integer) query.list().get(0);

    }
}
