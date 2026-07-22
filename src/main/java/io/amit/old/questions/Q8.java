package io.amit.old.questions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Q8 {
    public static void main(String[] args) {
        String s = "hello jake, how are you?";
        String collect = Arrays.asList(s.split(" "))
                .stream()
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        System.out.println("co "+collect);
    }
}
