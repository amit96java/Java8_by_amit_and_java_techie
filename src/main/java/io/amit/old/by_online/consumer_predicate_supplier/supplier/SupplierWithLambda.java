package io.amit.old.by_online.consumer_predicate_supplier.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierWithLambda {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            return "hi amit";
        };
        System.out.println(supplier.get());

        List<String> lists = Arrays.asList("a","b");

        /**
         * if list is empty then it returns supplier.
         */
        System.out.println(lists.stream().findAny().orElseGet(supplier));
    }
}
