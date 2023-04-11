package com.htgbot.dbclasess.tables;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.Authorize;
import com.htgbot.dbclasess.entities.User;
import org.hibernate.Session;

import java.util.List;

public class AuthorizeTable {

    public List<Authorize> getLoginUsers() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<Authorize>) session.createQuery("select login from Authorize ", Authorize.class).list();
        }
    }
    public List<Authorize> getPassUsers() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<Authorize>) session.createQuery("select password from Authorize ", Authorize.class).list();
        }
    }
}
