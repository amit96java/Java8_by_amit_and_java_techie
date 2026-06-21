package io.amit.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;



public class Demo {

    public static void main(String[] args) {
        BinaryOperator<Integer> operator = (x, y) -> {
            return x+y;
        };

        System.out.println(operator.apply(2, 3 ));

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




