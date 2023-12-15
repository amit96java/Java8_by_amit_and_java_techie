package io.amit.old.by_online.consumer_predicate_supplier.bi_consumer;

import java.util.function.BiConsumer;

public class Demo {
    public static void main(String[] args) {

        BiConsumer<String, Integer> biConsumer = (name, age) -> {
            System.out.println("name is "+name+" age is "+age);
        };

        biConsumer.accept("amit", 27);
    }
}
