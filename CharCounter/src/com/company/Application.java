package com.company;

import com.company.utility.Util;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        String text = sc.nextLine();
        System.out.println("enter a character to check how many times it shows up in your sentence. Enter 0 to exit.\n If you enter more than 1 character the first will be taken!");
        String chr = sc.nextLine();
        int count = Util.charCounter(text.toLowerCase(), chr.toLowerCase());
        System.out.println("The character " + chr.charAt(0) + " is found " + count + " times in the sentence");
    }
}
