package com.htgbot.dbclasess.tables;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.QuizGame;
import org.hibernate.Session;

import java.util.List;

public class QuizGameTable {
    public String getQuestionFromWaiter() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 1", QuizGame.class).list();
            return query.get(0).getQuestionText();
        }
    }


    public String getAnswerFromWaiter() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 1", QuizGame.class).list();
            return query.get(0).getAnswerText();
        }
    }


    public String getPhotosFromWaiter() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 1", QuizGame.class).list();
            return query.get(0).getPhotos();
        }
    }


    public String getQuestionGameFromBarmen() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 2", QuizGame.class).list();
            return query.get(0).getQuestionText();
        }
    }


    public String getAnswerFromBarmen() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 2", QuizGame.class).list();
            return query.get(0).getAnswerText();
        }
    }


    public String getPhotosFromBarmen() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 2", QuizGame.class).list();
            return query.get(0).getPhotos();
        }
    }


    public String getQuestionGameFromCook() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 3", QuizGame.class).list();
            return query.get(0).getQuestionText();
        }
    }


    public String getAnswerFromCook() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 3", QuizGame.class).list();
            return query.get(0).getAnswerText();
        }
    }


    public String getPhotosFromCook() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 3", QuizGame.class).list();
            return query.get(0).getPhotos();
        }
    }


    //todo ниже 2 селекта для руководства и знакомства они еще не заполнены в БД!!!!
    public String getQuestionGameFromRestaurant() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 4", QuizGame.class).list();
            return query.get(0).getQuestionText();
        }
    }


    public String getPhotosRestaurant() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 4", QuizGame.class).list();
            return query.get(0).getPhotos();
        }
    }


    public String getQuestionGameFromAdministration() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 5", QuizGame.class).list();
            return query.get(0).getQuestionText();
        }
    }


    public String getAnswerFromAdministration() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 5", QuizGame.class).list();
            return query.get(0).getAnswerText();
        }
    }


    public String getPhotosAdministration() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {

            List<QuizGame> query = (List<QuizGame>) session.createQuery("from QuizGame WHERE numberQuiz = 5", QuizGame.class).list();
            return query.get(0).getPhotos();
        }
    }
}
