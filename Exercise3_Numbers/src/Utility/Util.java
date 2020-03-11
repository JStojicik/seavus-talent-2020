package Utility;

import java.util.ArrayList;
import java.util.Arrays;

public final class Util {
    public static String textToNumber(String numberString) {
        String number = "";
        ArrayList<String> digits = new ArrayList<String>(Arrays.asList(numberString.split(" ")));
        for (String s : digits) {
            switch (s.toLowerCase()) {
                case "one":
                    number += "1";
                    break;
                case "two":
                    number += "2";
                    break;
                case "three":
                    number += "3";
                    break;
                case "four":
                    number += "4";
                    break;
                case "five":
                    number += "5";
                    break;
                case "six":
                    number += "6";
                    break;
                case "seven":
                    number += "7";
                    break;
                case "eight":
                    number += "8";
                    break;
                case "nine":
                    number += "9";
                    break;
                case "zero":
                    number += "0";
                    break;

            }
        }
        return number;
    }
}
