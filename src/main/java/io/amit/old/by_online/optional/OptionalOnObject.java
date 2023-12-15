package io.amit.old.by_online.optional;

import io.amit.old.by_online.mapandflatmap.Customer;
import io.amit.old.by_online.mapandflatmap.EkartDatabase;

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
