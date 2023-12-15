package io.amit.old.by_online.find;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAny {
    public static void main(String[] args) {
        List<Integer> nums= Arrays.asList(1,2,5,9,3,4);
        Optional<Integer> retNum= nums.stream().findAny();
        if(retNum.isPresent())
            System.out.println("result is "+retNum.get());
        else
            System.out.println("no value");
    }

}
