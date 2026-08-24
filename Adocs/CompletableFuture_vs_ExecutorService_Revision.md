# CompletableFuture vs ExecutorService --- Quick Revision Notes

## Purpose

Keep this note for future revision/interview preparation.

The key idea is:

> **ExecutorService controls where/how tasks run. CompletableFuture
> represents and composes asynchronous work.**

------------------------------------------------------------------------

## 1. ExecutorService

`ExecutorService` is mainly responsible for managing a pool of threads
and executing submitted tasks.

### `execute()`

``` java
executorService.execute(() -> {
    System.out.println("Hello");
});
```

-   Accepts a `Runnable`
-   Returns `void`
-   Submit the task and do not get a result handle

Conceptually:

``` text
submit task → execute task → nothing returned
```

### `submit()`

``` java
Future<Integer> future = executorService.submit(() -> {
    return 10 + 20;
});

Integer result = future.get();
```

-   Accepts `Runnable` or `Callable`
-   Returns a `Future`
-   `Future.get()` can be used to wait for completion and retrieve the
    result

Conceptually:

``` text
submit()
   ↓
Future
   ↓
get()
   ↓
result
```

------------------------------------------------------------------------

## 2. CompletableFuture

`CompletableFuture` represents an asynchronous computation and provides
APIs for building an asynchronous workflow.

Example:

``` java
CompletableFuture<Integer> future =
        CompletableFuture.supplyAsync(() -> 10, executorService);

future
    .thenApply(x -> x * 2)
    .thenApply(x -> x + 5)
    .thenAccept(System.out::println);
```

Flow:

``` text
10
 ↓
× 2
 ↓
20
 ↓
+ 5
 ↓
25
 ↓
print
```

The important advantage is that you can compose multiple asynchronous
operations without manually blocking between every step.

------------------------------------------------------------------------

## 3. Your Example

You wrote:

``` java
CompletableFuture.runAsync(
        printWithThreadDetais(name),
        executorService
);
```

This means:

> Run this asynchronous task using my custom `ExecutorService`.

The architecture is:

``` text
CompletableFuture
       ↓
ExecutorService
       ↓
Thread Pool
       ↓
Worker Thread
       ↓
Task execution
```

So `CompletableFuture` and `ExecutorService` are not competitors.

They solve different problems.

------------------------------------------------------------------------

## 4. Why Pass ExecutorService to CompletableFuture?

If you write:

``` java
CompletableFuture.runAsync(() -> {
    // task
});
```

without an executor, Java normally uses the common ForkJoinPool.

But if you write:

``` java
CompletableFuture.runAsync(
    () -> {
        // task
    },
    executorService
);
```

you explicitly control the executor/thread pool.

For example:

``` java
ExecutorService executorService =
        Executors.newFixedThreadPool(3);
```

means at most 3 tasks can execute concurrently.

------------------------------------------------------------------------

## 5. `CompletableFuture.allOf()`

Suppose you have:

``` java
CompletableFuture<Void> f1 = ...;
CompletableFuture<Void> f2 = ...;
CompletableFuture<Void> f3 = ...;
CompletableFuture<Void> f4 = ...;
```

You can create one future representing completion of all of them:

``` java
CompletableFuture<Void> all =
        CompletableFuture.allOf(f1, f2, f3, f4);
```

`allOf()` itself does not block.

It creates a new `CompletableFuture` that completes when all supplied
futures complete.

Conceptually:

``` text
f1 ────────✓
f2 ───────────✓
f3 ─────✓
f4 ─────────────✓
                ↓
             allOf()
                ↓
           completed
```

------------------------------------------------------------------------

## 6. What Does `join()` Do?

When you write:

``` java
CompletableFuture.allOf(f1, f2, f3, f4).join();
```

`join()` waits for the combined future to complete.

So:

``` text
allOf()
   ↓
represents "all tasks are complete"
   ↓
join()
   ↓
wait for completion
   ↓
continue execution
```

Important:

> `join()` blocks the **current thread**. It does not block the worker
> threads that are executing the tasks.

------------------------------------------------------------------------

## 7. Example with Three Threads

Suppose:

``` java
ExecutorService executorService =
        Executors.newFixedThreadPool(3);
```

And you submit four tasks:

``` text
Task 1 → amit
Task 2 → karan
Task 3 → aman
Task 4 → vikas
```

Initially:

``` text
Thread 1 → Task 1
Thread 2 → Task 2
Thread 3 → Task 3
```

When one thread becomes free:

``` text
Thread 1 → Task 4
```

So the fourth task waits in the executor's queue until a worker becomes
available.

------------------------------------------------------------------------

## 8. `execute()` vs `submit()` vs `CompletableFuture`

  ---------------------------------------------------------------------------
  Feature           `execute()`       `submit()`        `CompletableFuture`
  ----------------- ----------------- ----------------- ---------------------
  Submit task       Yes               Yes               Yes

  Uses              Yes               Yes               Yes
  ExecutorService                                       

  Return value      No                `Future`          `CompletableFuture`

  Wait for result   No                `get()`           `join()` / `get()`

  Async chaining    No                No                Yes

  Combine tasks     No                Difficult         `allOf()`, `anyOf()`

  Transform result  No                No                `thenApply()`

  Chain another     No                No                `thenCompose()`
  async operation                                       

  Combine           No                No                `thenCombine()`
  independent                                           
  results                                               

  Built-in async    No                Limited           `exceptionally()`,
  error pipeline                                        `handle()`,
                                                        `whenComplete()`
  ---------------------------------------------------------------------------

------------------------------------------------------------------------

## 9. Most Important Interview Difference

### ExecutorService

Think:

> **"Where and with how many threads should my tasks execute?"**

Example:

``` java
ExecutorService executor =
        Executors.newFixedThreadPool(3);
```

It manages the threads and executes tasks.

### CompletableFuture

Think:

> **"What should happen when my asynchronous task completes?"**

Example:

``` java
CompletableFuture
    .supplyAsync(() -> getUser(), executor)
    .thenApply(user -> getAddress(user))
    .thenAccept(System.out::println);
```

It manages the asynchronous workflow/composition.

------------------------------------------------------------------------

## 10. One-Line Memory Trick

``` text
ExecutorService  → controls execution/thread pool

CompletableFuture → controls asynchronous workflow
```

And they are commonly used together:

``` text
                ExecutorService
                      ↓
                 Thread Pool
                      ↓
              Async Task Execution
                      ↓
                CompletableFuture
                      ↓
          thenApply / thenCompose /
          thenCombine / allOf / etc.
```

------------------------------------------------------------------------

## 11. Your Code in Simple Terms

Your code:

``` java
List<CompletableFuture<Void>> futures = names.stream()
        .map(Q4::printName)
        .toList();

CompletableFuture
        .allOf(futures.toArray(new CompletableFuture[0]))
        .join();

executorService.shutdown();
```

Means:

1.  Create asynchronous tasks for all names.
2.  Execute them using your custom 3-thread executor.
3.  Store the returned `CompletableFuture` objects.
4.  Create one combined future using `allOf()`.
5.  `join()` waits until all tasks finish.
6.  Call `shutdown()` so the executor does not accept new tasks and can
    finish already-submitted tasks.

------------------------------------------------------------------------

## Final Mental Model

``` text
                  CompletableFuture
                         |
                         | "What happens
                         |  asynchronously?"
                         ↓
             ┌─────────────────────────┐
             │ thenApply()             │
             │ thenCompose()           │
             │ thenCombine()           │
             │ allOf()                 │
             │ exceptionally()         │
             └─────────────────────────┘
                         |
                         ↓
                  ExecutorService
                         |
                         | "Where does
                         |  it execute?"
                         ↓
                 ┌───────────────┐
                 │ Thread 1      │
                 │ Thread 2      │
                 │ Thread 3      │
                 └───────────────┘
```
