package com.htgbot.dbclasess.dbconnection;

import com.htgbot.dbclasess.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class DbConnection {
    private static DbConnection instance = null;

    private SessionFactory sessionFactory;

    private DbConnection() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(QuizGame.class);
            configuration.addAnnotatedClass(Support.class);
            configuration.addAnnotatedClass(Authorize.class);
            configuration.addAnnotatedClass(Positions.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

        } catch (Exception e) {
            System.out.println("HibernateSession init error:" + e);
        }
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}