difference between t1.run and t1.start

```java
class MyThread extends Thread {
public void run() {
System.out.println("Running in: " + Thread.currentThread().getName());
}
}

public class ThreadDemo {
public static void main(String[] args) {
MyThread t1 = new MyThread();

        // Case 1: Using start()
        t1.start(); // creates new thread
        System.out.println("After start(): " + Thread.currentThread().getName());

        // Case 2: Using run()
        t1.run();   // runs in main thread like a normal method
        System.out.println("After run(): " + Thread.currentThread().getName());
    }
}

```

```text
Explanation

When you call t1.start(), the JVM creates a new thread, assigns it a name (like Thread-0), and runs run() inside that new thread.

When you call t1.run(), it behaves just like a normal method call, so everything runs inside the main thread — no new thread is created.
```



