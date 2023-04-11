package com.htgbot.dao;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.User;


public class UserDao {

    public User getAll(int id){
        return DbConnection.getInstance().getSessionFactory().openSession().get(User.class,id);
    }

}
