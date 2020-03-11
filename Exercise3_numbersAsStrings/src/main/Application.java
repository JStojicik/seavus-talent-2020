package main;

import Utility.Util;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number as a string Example:'one five seven'for 157");
        String numberString=sc.nextLine();
        System.out.println("the number you have entered as a string is "+ Util.textToNumber(numberString));
    }
}
