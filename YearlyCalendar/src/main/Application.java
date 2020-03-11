package main;

import Utility.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the year to print the dates");
        int year=sc.nextInt();
        ArrayList dates= Util.getDates(year);
        System.out.println("The dates for the year "+year+" are\n" );
        dates.forEach(System.out::println);

    }
}
