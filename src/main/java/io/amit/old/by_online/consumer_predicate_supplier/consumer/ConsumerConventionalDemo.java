package io.amit.old.by_online.consumer_predicate_supplier.consumer;

import java.util.function.Consumer;

public class ConsumerConventionalDemo implements Consumer<Integer> {
    /**
     * Performs this operation on the given argument.
     *
     * @param integer the input argument
     */
    @Override
    public void accept(Integer integer) {
        System.out.println("printing : " + integer);
    }

    public static void main(String[] args) {
        ConsumerConventionalDemo consumerConventionalDemo = new ConsumerConventionalDemo();
        consumerConventionalDemo.accept(8);
    }
}
