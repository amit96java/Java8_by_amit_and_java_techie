package io.amit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        List<String> names = List.of("amit", "aman", "rahul");
        names.forEach(Demo::printName);
        Thread.sleep(2000);
    }

    public static void printName(String name) {

        CompletableFuture.runAsync(() -> System.out.println("Thread is "+Thread.currentThread().getName()+" name is "+name));
    }
}
