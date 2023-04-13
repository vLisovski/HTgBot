package com.htgbot.service;

import com.htgbot.statemachine.State;

public class ButtonsCallbacks {
    public static final String START_BUTTON = State.LOGIN.toString();
    public static final String MAIN_MENU_BUTTON_EDUCATION = State.EDUCATION.toString();
    public static final String MAIN_MENU_BUTTON_EMPLOYEES = State.EMPLOYEES.toString();
    public static final String MAIN_MENU_BUTTON_ABOUT = State.ABOUT.toString();
    public static final String MAIN_MENU_BUTTON_SUPPORT = State.SUPPORT.toString();
    public static final String ABOUT_BUTTON_BACK = State.MAIN_MENU.toString();
    public static final String EDUCATION_BUTTON_BACK = State.MAIN_MENU.toString();
    public static final String SUPPORT_BUTTON_BACK = State.MAIN_MENU.toString();
    public static final String GUIDING_BUTTON_BACK = State.MAIN_MENU.toString();
    public static final String EMPLOYEE_BUTTON_BACK = State.EMPLOYEES.toString();
    public static final String EMPLOYEES_BUTTON_BACK = State.MAIN_MENU.toString();
    public static final String RESULT_BUTTON_TO_MAIN_MENU = State.MAIN_MENU.toString();

}

