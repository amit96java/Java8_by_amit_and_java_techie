package io.amit.old.by_amit.asynchronous.thread_demo;

/**
 * Explanation
 *
 * t1.start() and t2.start() run concurrently.
 *
 * The join() calls make the main thread wait until both threads finish.
 *
 * Each thread runs its own run() method independently.
 */
class FirstThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("FirstThread: " + i);
            try {
                Thread.sleep(500); // pause for half a second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("FirstThread completed");
    }
}

class SecondThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("SecondThread: " + i);
            try {
                Thread.sleep(700); // pause for 0.7 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("SecondThread completed");
    }
}

public class TwoThreadExample {
    public static void main(String[] args) {
        FirstThread t1 = new FirstThread();
        SecondThread t2 = new SecondThread();

        t1.start();
        t2.start();

        try {
            // main thread waits until both t1 and t2 finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main thread finished after both threads completed");
    }
}

