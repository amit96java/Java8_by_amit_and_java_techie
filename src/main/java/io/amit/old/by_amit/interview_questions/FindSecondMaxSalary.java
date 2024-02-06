package io.amit.old.by_amit.interview_questions;

import java.util.Comparator;
import java.util.List;

public class FindSecondMaxSalary {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,3,4,5,6);
        int resp = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("resp is "+resp);
    }
}
