package io.amit.old.by_online.consumer_predicate_supplier.predicate;

import java.util.function.Predicate;

public class PredicateDemoByInterface implements Predicate<Integer> {
    /**
     * Evaluates this predicate on the given argument.
     *
     * @param integer the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    @Override
    public boolean test(Integer integer) {
        if(integer%2==0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Predicate<Integer> predicate = new PredicateDemoByInterface();
        System.out.println(predicate.test(5));
    }
}
