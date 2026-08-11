package io.amit.old.questions;

import java.util.function.BiFunction;

public class Q7_Bifunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> addString = (a, b) -> a.toString()+b.toString();

        System.out.println(addString.apply(2,3));
    }
}
