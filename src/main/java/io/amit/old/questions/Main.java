package io.amit.old.questions;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        String str = "fourhead";
        printLuckyString(str);
    }

    private static void printLuckyString(String str) {
        if(str.length() <= 1){
            return;
        }
        int length = str.length();
        int mid = (length+0)/2;

        String left = str.substring(0, mid);
        String right = str.substring(mid, length);

        System.out.println("left "+left+" right "+right);

        printLuckyString(left);
        printLuckyString(right);
    }
}
