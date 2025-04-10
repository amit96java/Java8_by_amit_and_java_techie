package io.amit.old.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1 {

    public static void main(String[] args) {
        List<Integer> original = Arrays.asList(1, 2, 8, 4, 5);

        List<Integer> reversed = IntStream.range(0, original.size())
                .mapToObj(i -> original.get(original.size() - 1 - i))
                .collect(Collectors.toList());

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
