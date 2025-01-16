package io.amit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        List<Integer> collect = Arrays.asList(nums)
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
