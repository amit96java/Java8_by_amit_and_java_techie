package io.amit.old.by_online.optional;

import io.amit.old.by_online.mapandflatmap.Customer;

import java.util.Arrays;
import java.util.Optional;

public class OptionalThrowException {
    public static void main(String[] args) {
        Customer customer = new Customer(101, "john",null, Arrays.asList("7275118711", "9140606694"));

        Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());


        System.out.println(emailOptional2.orElseThrow(()-> new IllegalArgumentException("email is not present")));
    }



}
