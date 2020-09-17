package com.company;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        String text = sc.nextLine();
        System.out.println("The characters printed with the number of apearences in the sentance you entered");
        charCounter(text.toLowerCase()).forEach(System.out::println);
    }

    static Set<String> charCounter(String text) {
        ArrayList<Character> charList = new ArrayList<>();
        LinkedHashSet<String> countedCharList = new LinkedHashSet<>();
        for (int i = 0; i < text.length(); i++) {
            charList.add(text.charAt(i));
        }
        for (Character c : charList) {
            int count = 0;
            for (Character c1 : charList) {
                if (c.equals(c1)) {
                    count++;
                }
            }
            countedCharList.add(c + " : " + count);

        }
        return countedCharList;
    }
}
