package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year to print the dates");
        int year = sc.nextInt();
        ArrayList<String> dates = getDates(year);
        System.out.println("The dates for the year " + year + " are\n");
        dates.forEach(System.out::println);
    }

    static ArrayList<String> getDates(int year) {
        int daysInMonth;
        ArrayList<String> dates = new ArrayList<>();
        for (int m = 1; m <= 12; m++) {
            switch (m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    daysInMonth = 31;
                    break;
                case 2:
                    if (year % 4 == 0) {
                        daysInMonth = 29;
                    } else {
                        daysInMonth = 28;
                    }
                    break;
                default:
                    daysInMonth = 30;
                    break;
            }
            for (int d = 1; d <= daysInMonth; d++) {
                String date = year + "/" + m + "/" + d;
                dates.add(date);
            }
        }

        return dates;
    }
}
