package com.htgbot.service;

import com.htgbot.service.menupages.about.About;
import com.htgbot.service.menupages.authorization.Authorization;
import com.htgbot.service.menupages.education.Education;
import com.htgbot.service.menupages.employees.Employees;
import com.htgbot.service.menupages.faq.FAQ;
import com.htgbot.service.menupages.guiding.Guiding;
import com.htgbot.service.menupages.mainmenu.MainMenu;
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
    private final FAQ faq;
    private final Support support;
    private final Start start;
    private final Employees employees;
    private final Education education;

    public ServiceManager() {
        pages = new HashMap<>();

        start = new Start();
        authorization = new Authorization();
        mainMenu = new MainMenu();
        education = new Education();
        guiding = new Guiding();
        employees = new Employees();
        about = new About();
        faq = new FAQ();
        support = new Support();


        pages.put(State.START, start::sendStartPage);

        pages.put(State.LOGIN, authorization::sendLoginPage);
        pages.put(State.PASSWORD, authorization::sendMessagePasswordPage);

        pages.put(State.MAIN_MENU, mainMenu::sendMainMenuPage);

        pages.put(State.EDUCATION, education::sendEducationPage);
        pages.put(State.GUIDING, guiding::sendGuidingPage);
        pages.put(State.EMPLOYEES, employees::sendEmployeesPage);
        pages.put(State.ABOUT, about::sendAboutPage);
        pages.put(State.FAQ, faq::sendFAQPage);
        pages.put(State.SUPPORT, support::sendEnterAppealPage);
    }

    public SendMessage getPage(TransData transData) {
        return pages.get(transData.getState()).sendPage(transData);
    }
}
