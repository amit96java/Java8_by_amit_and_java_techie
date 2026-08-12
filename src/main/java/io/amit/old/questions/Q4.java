package io.amit.old.questions;

import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Q4 {
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
                .map(Q4::printName)
                .toList();

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .join();

        /**
         * What does shutdown() do?
         * It tells the executor:
         * “Do not accept any new tasks, but complete already submitted tasks.”
         */
        executorService.shutdown();
    }

    public static CompletableFuture<Void> printName(String name) {
        return CompletableFuture
                .runAsync(printWithThreadDetais(name),
                        executorService);
    }

    private static @NonNull Runnable printWithThreadDetais(String name) {
        return () -> System.out.println("Thread: " + Thread.currentThread().getName() + " : " + name);
    }

}
