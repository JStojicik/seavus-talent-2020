package com.company;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence");
        String text = sc.nextLine().toLowerCase();
        System.out.println("The characters printed with the number of apearences in the sentance you entered");
        for (Map.Entry<Character, Integer> entry : charCounter(text).entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    static Map<Character,Integer> charCounter(String text) {
        ArrayList<Character> charList = new ArrayList<>();
        HashMap<Character,Integer> countedCharMap = new HashMap<>();
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
            countedCharMap.put(c,count);
        }
        return countedCharMap;
    }
}
