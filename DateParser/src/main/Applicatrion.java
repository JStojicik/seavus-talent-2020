package main;

import utility.Util;

import java.util.Scanner;

public class Applicatrion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date in the format 'MM/DD/YYYY' such as '12/04/2007'");
        String date = sc.nextLine();
        System.out.println("The date you have entered is: ");
        Util.dateList(date);
    }
}
