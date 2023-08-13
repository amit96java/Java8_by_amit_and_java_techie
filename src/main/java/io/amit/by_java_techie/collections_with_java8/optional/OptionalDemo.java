package io.amit.by_java_techie.collections_with_java8.optional;

import io.amit.by_java_techie.collections_with_java8.mapandflatmap.Customer;

import java.util.Arrays;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Customer customer = new Customer(101, "john",/*null*/"abc", Arrays.asList("7275118711", "9140606694"));
        //empty
        //of
        //ofNullable

        Optional<Object> emptyOptional = Optional.empty();

        System.out.println(emptyOptional);

/***********************************************************************************************************************/

        /**
         * if value is null than it will not throw null pointer exception
         *
         * if you not sure that value may or may not null. than use this method.
         */
        Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
//        if (emailOptional2.isPresent()) {
//            System.out.println(emailOptional2.get());
//        }

        System.out.println(emailOptional2.orElse("default@gmail.com"));

/*********************************************************************************************************************/
        /**
         * if customer.getEmail is null than Optional.of will throw null pointer exception.
         *
         * note: if you sure that value is not null than use this method.
         */
//        Optional<String> emailOptional = Optional.of(customer.getEmail());
//
//        System.out.println(emailOptional);
    }
}
