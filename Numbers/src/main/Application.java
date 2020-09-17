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
                case "one" -> number.append("1");
                case "two" -> number.append("2");
                case "three" -> number.append("3");
                case "four" -> number.append("4");
                case "five" -> number.append("5");
                case "six" -> number.append("6");
                case "seven" -> number.append("7");
                case "eight" -> number.append("8");
                case "nine" -> number.append("9");
                case "zero" -> number.append("0");
            }
        }
        return number.toString();
    }
}
