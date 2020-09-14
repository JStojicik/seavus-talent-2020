package com.company.utility;

import java.util.ArrayList;

public class Util {
    public static int charCounter(String text, String chr) {
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            charList.add(text.charAt(i));
        }
        int count = 0;
        for (Character c : charList) {
            if (c.equals(chr.charAt(0))) {
                count++;
            }
        }
        return count;
    }
}
