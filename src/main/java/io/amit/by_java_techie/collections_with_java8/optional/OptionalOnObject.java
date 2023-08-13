package io.amit.by_java_techie.collections_with_java8.optional;

import io.amit.by_java_techie.collections_with_java8.mapandflatmap.Customer;
import io.amit.by_java_techie.collections_with_java8.mapandflatmap.EkartDatabase;

import java.util.List;

public class OptionalOnObject {

    public static Customer getCustomerByemailId(String emailId){
        List<Customer> customers = EkartDatabase.getAll();
        return customers.stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(emailId))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("no customer present with this mail address..."));
    }

    public static void main(String[] args) {
        getCustomerByemailId("pqr");
    }
}
