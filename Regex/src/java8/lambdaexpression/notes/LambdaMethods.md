# 🧵 Lambda Expression Inside `Thread` Constructor

## 🤔 Question

How is this valid?

``` java
Thread t1 = new Thread(() -> System.out.println("Thread is Running"));
t1.start();
```

The constructor expects a `Runnable`, not a lambda. So how does it work?

------------------------------------------------------------------------

## Step 1: Check the Constructor

``` java
public Thread(Runnable target)
```

The constructor expects a **Runnable** object.

------------------------------------------------------------------------

## Step 2: Runnable is a Functional Interface

``` java
@FunctionalInterface
public interface Runnable {
    void run();
}
```

Since it has exactly one abstract method, Java allows a lambda
expression wherever a `Runnable` is expected.

------------------------------------------------------------------------

## Important Rule ⭐

> A Lambda Expression can be used wherever a Functional Interface is
> expected.

------------------------------------------------------------------------

## Before Java 8

``` java
Thread t1 = new Thread(

    new Runnable() {

        @Override
        public void run() {
            System.out.println("Thread is Running");
        }
    }

);
```

------------------------------------------------------------------------

## Java 8

``` java
Thread t1 = new Thread(
    () -> System.out.println("Thread is Running")
);
```

------------------------------------------------------------------------

## Internal Working

Conceptually, the compiler converts

``` java
Thread t1 = new Thread(
    () -> System.out.println("Thread is Running")
);
```

into

``` java
Runnable r = new Runnable() {

    @Override
    public void run() {
        System.out.println("Thread is Running");
    }
};

Thread t1 = new Thread(r);
```

The generated Runnable object is passed to the constructor.

------------------------------------------------------------------------

## Flow

``` text
Lambda Expression
        │
        ▼
Compiler
        │
Creates Runnable implementation
        │
        ▼
Passes Runnable object
        │
        ▼
Thread Constructor
        │
        ▼
t1.start()
        │
        ▼
JVM calls run()
```

------------------------------------------------------------------------

## Think Like This

Whenever you see:

``` java
someMethod(() -> { ... });
```

Ask yourself:

**What parameter type does the method or constructor expect?**

If it expects a Functional Interface, a lambda expression is allowed.

------------------------------------------------------------------------

## Interview Point

> A lambda expression is not passed directly to the constructor. The
> Java compiler converts it into an implementation of the required
> Functional Interface and passes the generated object.

------------------------------------------------------------------------

## Revision Summary

-   ✅ `Thread` constructor expects a `Runnable`.
-   ✅ `Runnable` is a Functional Interface.
-   ✅ Lambda expressions work with Functional Interfaces.
-   ✅ Compiler creates the `Runnable` implementation.
-   ✅ The generated object is passed to the constructor.
