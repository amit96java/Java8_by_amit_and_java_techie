package io.amit.old.questions;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger THREAD_COUNTER = new AtomicInteger(1);

    private static final ExecutorService executorService =
            Executors.newFixedThreadPool(3, new ThreadFactory() {
                @Override
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("my-custom-thread-" + THREAD_COUNTER.getAndIncrement());
                    return thread;
                }
            });

    public static void main(String[] args) throws InterruptedException {
        List<String> names = List.of("amit", "karan", "aman", "vikas");

        List<CompletableFuture<Void>> futures = names.stream()
                .map(Main::printName)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        /**
         * What does shutdown() do?
         * It tells the executor:
         * “Do not accept any new tasks, but complete already submitted tasks.”
         */
//        executorService.shutdown();
    }

    public static CompletableFuture<Void> printName(String name) {
        return CompletableFuture
                .runAsync(() -> System.out.println("Thread: "+Thread.currentThread().getName()+" : "+name),
                        executorService);
    }


}
