package io.amit.by_java_techie.collections_with_java8.streams;

import java.util.ArrayList;
import java.util.List;

public class FilterDemo {
    public static void main(String[] args) {
        List<String>  lists = new ArrayList<>();
        lists.add("amit");
        lists.add("karan");
        lists.add("aman");
        lists.add("rahul");

        lists.stream()
                .filter(t -> t.startsWith("a"))
                .forEach(n -> System.out.println(n));
    }
}
