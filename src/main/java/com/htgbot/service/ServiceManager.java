package com.htgbot.service;

import com.htgbot.service.menupages.about.About;
import com.htgbot.service.menupages.authorization.Authorization;
import com.htgbot.service.menupages.education.Education;
import com.htgbot.service.menupages.employees.Employees;
import com.htgbot.service.menupages.guiding.Guiding;
import com.htgbot.service.menupages.mainmenu.MainMenu;
import com.htgbot.service.menupages.result.Result;
import com.htgbot.service.menupages.start.Start;
import com.htgbot.service.menupages.support.Support;
import com.htgbot.statemachine.State;
import com.htgbot.statemachine.TransData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.HashMap;
import java.util.Map;

public class ServiceManager {

    private final Map<State, Service> pages;
    private final Authorization authorization;
    private final MainMenu mainMenu;
    private final Guiding guiding;
    private final About about;
    private final Support support;
    private final Start start;
    private final Employees employees;
    private final Education education;
    private final Result result;

    public ServiceManager() {
        pages = new HashMap<>();

        start = new Start();
        authorization = new Authorization();
        mainMenu = new MainMenu();
        education = new Education();
        guiding = new Guiding();
        employees = new Employees();
        about = new About();
        support = new Support();
        result = new Result();

        pages.put(State.START, start::sendStartPage);

        pages.put(State.LOGIN, authorization::sendLoginPage);
        pages.put(State.PASSWORD, authorization::sendMessagePasswordPage);

        pages.put(State.MAIN_MENU, mainMenu::sendMainMenuPage);

        pages.put(State.EDUCATION, education::sendEducationPage);
        pages.put(State.OFFICIANT1, education::sendQuizPage);
        pages.put(State.OFFICIANT2, education::sendQuizPage);
        pages.put(State.OFFICIANT3, education::sendQuizPage);
        pages.put(State.OFFICIANT4, education::sendQuizPage);
        pages.put(State.OFFICIANT5, education::sendQuizPage);
        pages.put(State.OFFICIANT6, education::sendQuizPage);
        pages.put(State.OFFICIANT7, education::sendQuizPage);
        pages.put(State.BARMAN1, education::sendQuizPage);
        pages.put(State.BARMAN2, education::sendQuizPage);
        pages.put(State.BARMAN3, education::sendQuizPage);
        pages.put(State.BARMAN4, education::sendQuizPage);
        pages.put(State.BARMAN5, education::sendQuizPage);
        pages.put(State.BARMAN6, education::sendQuizPage);
        pages.put(State.BARMAN7, education::sendQuizPage);
        pages.put(State.COOK1, education::sendQuizPage);
        pages.put(State.COOK2, education::sendQuizPage);
        pages.put(State.COOK3, education::sendQuizPage);
        pages.put(State.COOK4, education::sendQuizPage);
        pages.put(State.COOK5, education::sendQuizPage);
        pages.put(State.COOK6, education::sendQuizPage);
        pages.put(State.COOK7, education::sendQuizPage);
        pages.put(State.REST1, education::sendQuizPage);
        pages.put(State.REST2, education::sendQuizPage);
        pages.put(State.REST3, education::sendQuizPage);
        pages.put(State.REST4, education::sendQuizPage);
        pages.put(State.GUIDING1, education::sendQuizPage);
        pages.put(State.GUIDING2, education::sendQuizPage);
        pages.put(State.GUIDING3, education::sendQuizPage);
        pages.put(State.GUIDING4, education::sendQuizPage);
        pages.put(State.RESULT, result::sendResultPage);

        pages.put(State.EMPLOYEES, employees::sendEmployeesMainPage);
        pages.put(State.EMPLOYEE1, employees::sendEmployeePage);
        pages.put(State.EMPLOYEE2, employees::sendEmployeePage);
        pages.put(State.EMPLOYEE3, employees::sendEmployeePage);
        pages.put(State.EMPLOYEE4, employees::sendEmployeePage);
        pages.put(State.EMPLOYEE5, employees::sendEmployeePage);
        pages.put(State.EMPLOYEE6, employees::sendEmployeePage);
        pages.put(State.ABOUT, about::sendAboutPage);

        pages.put(State.SUPPORT, support::sendEnterAppealPage);
    }

    public SendMessage getPage(TransData transData) {
        return pages.get(transData.getState()).sendPage(transData);
    }
}
