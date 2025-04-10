package io.amit.old.questions;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Q4 {
    public static void main(String[] args) throws InterruptedException {
        List<String> names = List.of("amit", "aman", "vikas");
        names.forEach(Q4::printName);
        Thread.sleep(5000);
    }

    public static void printName(String name) {
        CompletableFuture
                .runAsync(() -> System.out.println(Thread.currentThread().getName()+" : "+name));
    }
}
