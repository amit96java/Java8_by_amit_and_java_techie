package io.amit.old.by_online.consumer_predicate_supplier.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerWithLambda {
    public static void main(String[] args) {
        Consumer<Integer> consumer = (t) -> {
            System.out.println("printing with lambda "+t);
        };
        consumer.accept(8);

        List<Integer> lists = Arrays.asList(1,2,3,4,5);

        lists.stream().forEach(consumer);

    }
}
