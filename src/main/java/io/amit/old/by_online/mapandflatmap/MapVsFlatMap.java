package io.amit.old.by_online.mapandflatmap;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Customer> customers = EkartDatabase.getAll();

        //List<Customer> convert List<String> -> Data Transformatio
        //mapping customer -> customer.getEmail()
        // customer -> customer.getEmail() one to one mapping because one customer have only one emailid.

        List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());

        System.out.println(emails);

        /**************************************************************************/

        //customer -> customer.getPhoneNumbers -> one to many mapping
        List<List<String>> phoneNums = customers.stream()
                .map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneNums);

        /************************************************************************/
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phones);
    }
}
