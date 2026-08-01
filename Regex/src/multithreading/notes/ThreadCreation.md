# Thread Creation in Java

## Interview Definition

> In Java, a thread can be created in two primary ways: by **extending the `Thread` class** and overriding its `run()` method, or by **implementing the `Runnable` interface** and passing it to a `Thread` object. Both approaches ultimately require calling the `start()` method, which internally invokes `run()` in a new call stack, enabling concurrent execution.

---

## Method 1: Extending the `Thread` class

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();   // NOT t1.run()
    }
}
```

### What's happening here?
1. `MyThread` **extends** `Thread` → it inherits all thread capabilities.
2. You **override `run()`** → this is where you write the code you want to execute in a separate thread.
3. You call **`start()`**, not `run()` directly.

### ⚠️ Very important interview question: `start()` vs `run()`

| `start()` | `run()` |
|---|---|
| Creates a **new thread** and a new call stack | Runs like a **normal method call** |
| Actual multithreading happens | No new thread — executes on the **same** (calling) thread |
| Internally calls `run()` after thread setup | Just executes the code sequentially |
| Can only be called **once** per thread object | Can be called multiple times (like any method) |

**If you accidentally call `t1.run()` instead of `t1.start()`, your code will run — but it will NOT be multithreaded.** It just behaves like a regular function call on the main thread. This is a classic trick question.

### Limitation of this approach
Since Java doesn't support multiple inheritance, if your class **extends `Thread`**, it **cannot extend any other class**. This is the biggest drawback — which leads us to Method 2.

---

## Method 2: Implementing the `Runnable` interface

```java
class MyTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task);   // wrap the task in a Thread object
        t1.start();
    }
}
```

### What's happening here?
1. `MyTask` **implements `Runnable`** → it only defines *what task to do* (the `run()` method) — it doesn't become a thread itself.
2. You then create a **`Thread` object**, passing your `Runnable` task into its constructor.
3. Calling `t1.start()` on that `Thread` object executes `run()` in a new thread.

### Why this is the preferred/better approach

| Extending `Thread` | Implementing `Runnable` |
|---|---|
| Uses up your one shot at inheritance | Class is free to extend another class too |
| Tighter coupling — the class *is-a* Thread | Looser coupling — the class just *has-a* task |
| Less flexible | More flexible, follows good OOP design (favor composition over inheritance) |
| Fine for small/simple programs | Recommended for real-world, larger applications |

---

## Simple Analogy

- Extending `Thread` is like saying **"I am an employee"** — you literally become the worker, and now you can't also "be" something else (single inheritance limit).
- Implementing `Runnable` is like saying **"I have a task/job description"** — you can hand that task to any worker (Thread object) to execute, and you're still free to "be" other things too.

---

## Quick Summary (exam-ready)

> A thread in Java can be created either by extending the `Thread` class and overriding `run()`, or by implementing the `Runnable` interface and passing the object to a `Thread` instance. The `Runnable` approach is generally preferred since Java doesn't support multiple inheritance, and implementing an interface keeps the class free to extend another class if needed. In both cases, `start()` must be called (not `run()` directly) to actually begin execution on a new thread.
