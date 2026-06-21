package io.amit.old.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: 10)
 *
 * find max sum in given array and one time only one number can reverse in a loop :
 *     ![img.png](img.png)
 *     Example:
 *     given array is [2, 34, 671, 15]
 *     Solution:
 *     [2, 43, 671, 15] || [2, 34, 176, 15] || [2, 34, 671, 51]
 *     731		   || 227		  || 758
 *     758 is the answer
 *     
 */
public class Q10 {
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
                    dedicatedMaxNum = getReverseNum(nums[j]);
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

    private static int getReverseNum(int num) {
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
