package io.amit.old.questions;

import java.util.ArrayList;
import java.util.List;

public class Q14 {
    public static void main(String[] args) {
        Integer nums[] = new Integer[]{2, 34, 671, 15};

//      //iterate
        int totalMaxNum = 0;
        int dedicatedMaxNum = 0;
        int temp = 0;
        for (int i = 0; i< nums.length; i++) {
            for (int j = 0; j< nums.length; j++) {
                dedicatedMaxNum = nums[j];
                if(i == j) {
                    dedicatedMaxNum = getLargeNumber(nums[j]);
                }
                totalMaxNum = totalMaxNum +dedicatedMaxNum;
            }
            if(totalMaxNum > temp) {
                temp = totalMaxNum;
            }
            totalMaxNum = 0;
        }


        System.out.println("max num is "+temp);



    }

    private static int getLargeNumber(int num) {
        // get list of digit in a number
        List<Integer> digits = new ArrayList<>();

        while (num > 0) {
            digits.add(num % 10); // get last digit
            num = num / 10;    // remove last digit
        }
        System.out.println("digit are "+digits);
        int maxNum = 0;
        for (int digit : digits) {
            maxNum = maxNum * 10 + digit;

        }
        return maxNum;
    }
}
