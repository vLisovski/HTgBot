package com.htgbot.dbclasess;

import com.htgbot.dbclasess.tables.*;

public class DbManager {

    private AuthorizeTable authorizeTable;
    private PositionsTable positionsTable;
    private QuizGameTable quizGameTable;
    private SupportTable supportTable;
    private UserTable userTable;

    public DbManager() {
        this.authorizeTable = new AuthorizeTable();
        this.positionsTable = new PositionsTable();
        this.quizGameTable = new QuizGameTable();
        this.supportTable = new SupportTable();
        this.userTable = new UserTable();
    }

    //todo methods
    public UserTable getUserTable() {
        return userTable;
    }

    public SupportTable getSupportTable() {
        return supportTable;
    }

    public QuizGameTable getQuizGameTable() {
        return quizGameTable;
    }

    public PositionsTable getPositionsTable() {
        return positionsTable;
    }

    public AuthorizeTable getAuthorizeTable() {
        return authorizeTable;
    }
}
