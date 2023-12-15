package io.amit.old.by_amit.comparator_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortBySalary implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.salary - o2.salary;
    }


    public static void main(String[] args) {
        Comparator<Customer> compareBasedOnSalary = new Comparator<>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.salary - o2.salary;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        var customers = new ArrayList<Customer>();
        customers.add(new Customer(1, "amit", 120000));
        customers.add(new Customer(3, "Rudra", 160000));
        customers.add(new Customer(2, "Shiva", 140000));
        customers.forEach(System.out::println);
        Collections.sort(customers, compareBasedOnSalary);
        customers.forEach(System.out::println);
    }
}
