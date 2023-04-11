package com.htgbot.dbclasess.tables;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.QuizGame;
import com.htgbot.dbclasess.entities.Support;
import org.hibernate.Session;

import java.util.List;

public class SupportTable {
   //тут sandMessage??

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return  session.createQuery("insert into Support (textFromSupport, chatId)  ", Support.class);
            //TODO
        }
    }
}
