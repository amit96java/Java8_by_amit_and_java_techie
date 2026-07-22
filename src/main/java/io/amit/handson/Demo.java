package io.amit.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;


public class Demo {

    public static void main(String[] args) {
        String s = "hello jake, how are you?";
        String collect = Arrays.asList(s.split(" "))
                .stream()
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        System.out.println("co "+collect);
    }

    private static int reverseNum(int num) {
        List<Integer> digits = new ArrayList<>();

        while (num > 0) {
            int digit = num%10;
            num = num/10;
            digits.add(digit);
            System.out.println("num is "+num);
        }
        int reverseNum = 0;
        for(int n: digits) {
            reverseNum = reverseNum*10 + n;
        }
        return reverseNum;
    }








}




