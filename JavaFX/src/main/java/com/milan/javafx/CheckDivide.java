package com.milan.javafx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckDivide {
    Message message = new Message();
    public Double zeroDivide(Double num1,Double num2) {

        String num2Str = String.valueOf(num2);
        Pattern digit = Pattern.compile("[1-9]");
        Matcher m = digit.matcher(num2Str);
        boolean b = m.find();
        double num;
        if (!b) {
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException e) {
                message.errorMessage("Exception" + e,"You Can't Divide By Zero");
                num = Double.NaN;
                return num;
            }
        } else {
            num = num1 / num2;
        }
        return num;
    }

}
