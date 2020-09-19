package main;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number as a string Example:'one five seven'for 157");
        String numberString = sc.nextLine();
        System.out.println("the number you have entered as a string is " + textToNumber(numberString));
    }

    public static String textToNumber(String numberString) {
        StringBuilder number = new StringBuilder();
        for (String s : numberString.split(" ")) {
            switch (s.toLowerCase()) {
                case "one":
                    number.append("1");
                    break;
                case "two":
                    number.append("2");
                    break;
                case "three":
                    number.append("3");
                    break;
                case "four":
                    number.append("4");
                    break;
                case "five":
                    number.append("5");
                    break;
                case "six":
                    number.append("6");
                    break;
                case "seven":
                    number.append("7");
                    break;
                case "eight":
                    number.append("8");
                    break;
                case "nine":
                    number.append("9");
                    break;
                case "zero":
                    number.append("0");
                    break;
            }
        }
        return number.toString();
    }
}
