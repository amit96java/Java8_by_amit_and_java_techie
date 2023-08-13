package io.amit.by_java_techie.collections_with_java8.mapandflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDatabase {

    public static List<Customer> getAll(){
        return Stream.of(
                new Customer(101,"john","john@gmail.com", Arrays.asList("12345","6789")),
                new Customer(102,"smith","smith@gmail.com",Arrays.asList("102102","102456"))
        ).collect(Collectors.toList());
    }
}
