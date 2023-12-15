package io.amit.old.by_online.find;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirst {
    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(1,2,5,9,3,4);
        Optional<Integer> answer=nums.stream().findFirst();
        if(answer.isPresent())
            System.out.println("answer is "+answer.get());
        else
            System.out.println("no value");
    }
}
