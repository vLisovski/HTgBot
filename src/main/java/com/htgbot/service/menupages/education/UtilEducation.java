package com.htgbot.service.menupages.education;

import java.util.Arrays;
import java.util.List;

public class UtilEducation {
    public static List<String> parseStringToStringList(String string, String regex){

        String[] stringArray = string.split(regex);
        return Arrays.stream(stringArray).toList();

    }



}
