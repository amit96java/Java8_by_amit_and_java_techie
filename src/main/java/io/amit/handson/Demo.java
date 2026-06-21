package io.amit.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Integer nums[] = new Integer[] {2, 34, 671, 15};
        int sum = 0;
        int temp = 0;
        for (int i = 0; i< nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                int num = nums[j];
                if(i == j) {
                    num = reverseNum(num);
                }
                sum = sum + num;
            }
            if(sum > temp) {
                temp = sum;
            }
            sum = 0;
        }
        System.out.println("max sum is "+temp);

//        System.out.println("rev "+reverseNum(123));

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




