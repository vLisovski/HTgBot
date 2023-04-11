package com.htgbot.dbclasess.tables;

import com.htgbot.dbclasess.dbconnection.DbConnection;
import com.htgbot.dbclasess.entities.Authorize;
import com.htgbot.dbclasess.entities.QuizGame;
import org.hibernate.Session;

import java.util.List;

public class QuizGameTable {
    public List<QuizGame> getQuestionFromWaiter() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select questionText from QuizGame where numberQuiz = 1", QuizGame.class).list();
        }
    }

    public List<QuizGame> getAnswerFromWaiter() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select answerText from QuizGame where numberQuiz = 1", QuizGame.class).list();
        }
    }

    public List<QuizGame> getPhotosFromWaiter() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select photos from QuizGame where numberQuiz = 1", QuizGame.class).list();
        }
    }



    public List<QuizGame> getQuestionGameFromBarmen() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select questionText from QuizGame where numberQuiz = 2", QuizGame.class).list();
        }
    }

    public List<QuizGame> getAnswerFromBarmen() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select answerText from QuizGame where numberQuiz = 2", QuizGame.class).list();
        }
    }

    public List<QuizGame> getPhotosFromBarmen() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select photos from QuizGame where numberQuiz = 2", QuizGame.class).list();
        }
    }



    public List<QuizGame> getQuestionGameFromCook() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select questionText from QuizGame where numberQuiz = 3", QuizGame.class).list();
        }
    }

    public List<QuizGame> getAnswerFromCook() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select answerText from QuizGame where numberQuiz = 3", QuizGame.class).list();
        }
    }

    public List<QuizGame> getPhotosFromCook() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select photos from QuizGame where numberQuiz = 3", QuizGame.class).list();
        }
    }




    //todo ниже 2 селекта для руководства и знакомства они еще не заполнены в БД!!!!
    public List<QuizGame> getQuestionGameFromRestaurant() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select questionText from QuizGame where numberQuiz = 4", QuizGame.class).list();
        }
    }

    public List<QuizGame> getPhotosRestaurantP() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select photos from QuizGame where numberQuiz = 4", QuizGame.class).list();
        }
    }

    public List<QuizGame> getQuestionGameFromAdministration() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select questionText from QuizGame where numberQuiz = 5", QuizGame.class).list();
        }
    }


    public List<QuizGame> getAnswerFromAdministration() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select answerText from QuizGame where numberQuiz = 5", QuizGame.class).list();
        }
    }

    public List<QuizGame> getPhotosAdministration() {

        Session session = DbConnection.getInstance().getSessionFactory().openSession();
        {
            return (List<QuizGame>) session.createQuery("select photos from QuizGame where numberQuiz = 5", QuizGame.class).list();
        }
    }


}
