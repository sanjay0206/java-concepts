
# Java Concurrency: 
`Executors`, `Runnable`, `Callable`, `Future`, `CompletableFuture`, `ScheduledExecutorService`

## 1. Executors
**Purpose**: To manage a pool of threads and simplify concurrent task execution.

### Why Use Executors?
- **Thread Pool Management**: Executors manage a pool of threads, reducing the overhead of thread creation.
- **Simplified Code**: Abstracts thread management, allowing developers to focus on task logic rather than thread handling.
- **Resource Optimization**: Reuses existing threads, leading to more efficient resource utilization.
- **Task Scheduling**: Executors provide built-in support for scheduling tasks with `ScheduledExecutorService`.

### Advantages of Using Executors
- **Better Performance**: Reduces the latency of task execution by reusing threads.
- **Improved Resource Management**: Controls the number of concurrent threads to avoid overwhelming system resources.
- **Flexibility**: Supports different types of task submission (single, periodic, or asynchronous).
- **Error Handling**: Offers mechanisms to handle errors gracefully using `Future` and `Callable`.

### Flow of Executors
1. **Task Creation**: Create a task that implements `Runnable` or `Callable`.
2. **Thread Pool Creation**: Use `Executors` to create a thread pool.
3. **Task Submission**: Submit the task to the executor for execution.
4. **Task Execution**: The executor schedules and executes the task using available threads.
5. **Result Retrieval**: For tasks submitted using `Callable`, retrieve results via `Future`.

### Diagram of Executor Flow
```
[Task Creation] 
       ? 
[Thread Pool Creation] 
       ? 
[Task Submission] 
       ? 
[Task Execution] <----- [Thread Pool] 
       ? 
[Result Retrieval]
```

## 2. Runnable
**Purpose**: Represents a task that does not return a result and cannot throw a checked exception.

```java
public class RunnableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Runnable task = () -> System.out.println("Runnable task executed by: " + Thread.currentThread().getName());
        executor.submit(task);
        executor.shutdown();
    }
}
```

## 3. Callable
**Purpose**: Represents a task that returns a result and can throw a checked exception.

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            int a = 5, b = 10;
            return a + b;
        };

        Future<Integer> future = executor.submit(task); // Submit the task for execution

        try {
            Integer result = future.get(); // Retrieve the result
            System.out.println("Callable task result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown(); // Shut down the executor
    }
}
```

## 4. Future
**Purpose**: Represents the result of an asynchronous computation.

```java
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> "Hello from Callable!";
        Future<String> future = executor.submit(task);

        try {
            System.out.println("Task result: " + future.get()); // Block and get the result
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
```

## 5. CompletableFuture
**Purpose**: Extends `Future` with more capabilities for asynchronous programming and chaining tasks.

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 executed by: " + Thread.currentThread().getName());
            return 10;
        }).thenApply(result -> {
            System.out.println("Task 2 executed by: " + Thread.currentThread().getName());
            return result * 2;
        }).thenAccept(result -> System.out.println("Final result: " + result));

        // Block the main thread to ensure async tasks complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

## 6. ScheduledExecutorService
**Purpose**: To execute tasks after a given delay or to execute them periodically.

**Example**: Schedule a task to run after a delay.

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule a task to run after a 2-second delay
        scheduler.schedule(() -> System.out.println("Task executed after a 2-second delay"), 2, TimeUnit.SECONDS);

        // Schedule a task to run every 3 seconds
        scheduler.scheduleAtFixedRate(() -> System.out.println("Repeated task executed every 3 seconds"), 0, 3, TimeUnit.SECONDS);

        // Shutdown the scheduler after 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.shutdown(); // Shut down the scheduler
    }
}
```

## Main Thread and Task Execution
- **Main Thread**: Always runs and may continue executing tasks while the new thread runs concurrently.
- **New Thread** (created via `Runnable` or `Callable`): Executes the task in parallel with the main thread.

## Difference Between `execute()` and `submit()`

| **Feature**               | **execute()**                                      | **submit()**                                                 |
|---------------------------|---------------------------------------------------|--------------------------------------------------------------|
| **Return Type**            | `void`                                            | `Future<T>`                                                   |
| **Error Handling**         | Throws an exception immediately if the task fails | Captures exceptions within `Future`, and can check later with `future.get()` |
| **Task Type**              | Accepts only `Runnable`                           | Accepts both `Runnable` and `Callable`                         |
| **Blocking Behavior**      | No return, continues execution                    | Can block if `future.get()` is called                         |
| **Usage**                  | Fire-and-forget style task execution              | Used when you need to monitor the status or result of the task |

## Summary

- **Executors**: Manage a pool of threads for concurrent execution.
- **Runnable**: Simple tasks without a result or checked exceptions.
- **Callable**: Tasks with a result or checked exceptions.
- **Future**: Retrieve results of asynchronous tasks.
- **CompletableFuture**: More flexible asynchronous programming with task chaining and combination.
- **ScheduledExecutorService**: Allows scheduling of tasks for delayed or periodic execution.
- **execute() vs submit()**: `execute()` runs `Runnable` tasks without expecting a result, while `submit()` returns a `Future` that can hold the result of `Runnable` or `Callable`.
