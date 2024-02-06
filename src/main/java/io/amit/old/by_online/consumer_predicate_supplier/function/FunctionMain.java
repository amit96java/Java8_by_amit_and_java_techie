package io.amit.old.by_online.consumer_predicate_supplier.function;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class FunctionMain {
    public static void main(String[] args) {
        List<String> firstNames = List.of("amit", "shivam");
        Optional<String> resolveId = firstNames.stream()
                .map(resolveId("pal"))
                .findFirst();
        System.out.println(resolveId);
    }

    private static Function<String, String> resolveId(String lastName) {
        return pattern -> pattern + "::"+lastName;
    }
}
