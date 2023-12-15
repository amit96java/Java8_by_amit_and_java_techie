package io.amit.old.by_amit.interview_questions;

import java.util.ArrayList;
import java.util.List;

public class SplitLuckyString {

    private static List<String> container = new ArrayList<>();

    private static List<Character> splitString(String str) {
        int strLength = str.length();
        if(isEven(strLength)) {
            System.out.println("yes even");
            splitEven(str);
        } else {
            System.out.println("odd");
        }
        return null;
    }

    private static void splitEven(String str) {
        int strLength = str.length();
        int half = strLength/2;
        String s = str.substring(0, half);
        String s2 = str.substring(half, strLength);
        System.out.println("s "+s);
        System.out.println("s2 "+s2);
    }

    private static boolean isEven(int num) {
        System.out.println("num "+num);
        int rem = num%2;
        return rem == 0;
    }

    public static void main(String[] args) {
        splitString("amitmang");
    }
}
