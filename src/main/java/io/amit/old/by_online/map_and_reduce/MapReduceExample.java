package io.amit.old.by_online.map_and_reduce;

import io.amit.old.by_online.mapandflatmap.EkartDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);
        List<String> words = Arrays.asList("amit", "sonu", "deepak", "raj");

        /**
         * sum using conventional way
         */
        int sum = 0;
        for (int no : numbers) {
            sum = sum + no;
        }
        System.out.println(sum);

        /**
         * sum using map.
         */
        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);

        /**
         * here identity is the initial value.
         */
        Integer reduceSum = numbers.stream().reduce(1, (a, b) -> a + b);
        System.out.println(reduceSum);
        /**
         * sum using reduce method
         */
        Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodReference.get());
        /**
         * find max
         */
        int max = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(max);

        /**
         * max using reduce
         */
        int maxValuewithMethodref = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxValuewithMethodref);

        /**
         * string length comparison using reduce
         */
        String maxLength = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println(maxLength);

        /**
         * operation on dao
         */
        double avgId = EkartDatabase.getAll().stream()
                .filter(customer -> customer.getEmail().contains("gmail"))
                .map(customer -> customer.getId())
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(avgId);

        double sumId = EkartDatabase.getAll().stream()
                .map(customer -> customer.getId())
                .mapToDouble(i -> i)
                .sum();

        System.out.println(sumId);
    }
}
