package com.htgbot.service;

import com.htgbot.statemachine.State;

public class ButtonsCallbacks {
    public static final String loginButton = State.PASSWORD.toString();
    public static final String passwordButton = State.MAIN_MENU.toString();
    public static final String startButton = State.LOGIN.toString();
    public static final String mainMenuButtonQuizGame = State.EDUCATION.toString();
    public static final String mainMenuButtonGuiding = State.GUIDING.toString();
    public static final String mainMenuButtonEmployees = State.EMPLOYEES.toString();
    public static final String mainMenuButtonAbout = State.ABOUT.toString();
    public static final String mainMenuButtonFAQ = State.FAQ.toString();
    public static final String mainMenuButtonSupport = State.SUPPORT.toString();
}
