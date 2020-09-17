package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Applicatrion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date in the format 'MM/DD/YYYY' such as '12/04/2007'");
        String date = sc.nextLine();
        System.out.println("The date you have entered is: ");
        dateList(date);
    }

    static void dateList(String date) {
        ArrayList<String> dateList = new ArrayList<>(Arrays.asList(date.split("/")));
        for (int i = 0; i < dateList.size(); i++) {
            switch (i) {
                case 0 -> System.out.println("Month: " + dateList.get(i));
                case 1 -> System.out.println("Day: " + dateList.get(i));
                case 2 -> System.out.println("Year: " + dateList.get(i));
            }
        }
    }
}
