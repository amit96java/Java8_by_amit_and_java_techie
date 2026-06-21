package io.amit.old.questions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args) {
        List<Integer> salaries = List.of(11000, 12345, 9000, 12000);

        Integer desiredSalary = salaries
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .get(3);

        System.out.println(" "+desiredSalary);
    }
}
