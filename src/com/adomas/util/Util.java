package com.adomas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    private Util() {
    }

    public static boolean isPhoneValid(String phone) {
        Pattern pattern = Pattern.compile("^(\\+)?([\\d|\\w]{1,}[ |-]\\([\\d|\\w]{2,}\\)|(\\([\\d|\\w]{1,}\\)[ |-])([\\d|\\w]{2,})|(([\\d|\\w]{1,}[ |-])([\\d|\\w]{2,}))|(\\(?[\\d|\\w]{1,}\\)?))([ |\\-][\\d|\\w]{2,})*");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isInputNumber(String input) {
        try {
            int i = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
