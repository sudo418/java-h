# 5. But Stream is an Interface!

One of the most common beginner questions is:

> **"Stream is an interface. We know we cannot create an object of an
> interface. Then how does this work?"**

``` java
Stream<String> myStream = list.stream();
```

At first glance, it looks like Java is creating an object of `Stream`.

But **that is NOT what is happening.**

------------------------------------------------------------------------

## Step 1: Remember what an Interface is

Suppose we have:

``` java
interface Animal{
    void sound();
}
```

Can we do this?

``` java
Animal a = new Animal();   // ❌ Not Allowed
```

No.

Because an interface only tells Java **what methods should exist**.

It does **not** provide the complete implementation.

So an interface itself cannot have objects.

------------------------------------------------------------------------

## Step 2: Then how do we normally use interfaces?

You have already seen this pattern in Collections.

``` java
List<String> list = new ArrayList<>();
```

Let's break it down.

### Reference Type

``` java
List<String>
```

### Actual Object

``` java
new ArrayList<>()
```

Visualize it like this:

``` text
Reference Variable
        │
        ▼
List<String> list
        │
        ▼
+----------------------+
|   ArrayList Object   |
+----------------------+
```

Notice something important.

We did **NOT** create an object of `List`.

We created an object of **ArrayList**.

`List` is only the reference type.

------------------------------------------------------------------------

## Step 3: Stream follows the EXACT same rule

When you write

``` java
Stream<String> myStream = list.stream();
```

many beginners imagine:

``` java
new Stream();     // ❌ Impossible
```

That never happens.

Instead Java internally creates an object of **some implementation
class**.

Imagine Java has something like this (not the real code):

``` java
class StreamImpl<T> implements Stream<T>{

}
```

Then internally the method may behave like

``` java
public Stream<T> stream(){

    return new StreamImpl<>();
}
```

Notice carefully.

The object being created is

``` java
new StreamImpl<>();
```

NOT

``` java
new Stream();
```

------------------------------------------------------------------------

## Visual Diagram

``` text
              Stream (Interface)
                     ▲
                     │ implements
                     │
             StreamImpl (Class)
                     │
                     ▼
             new StreamImpl()

                     │
                     ▼
Stream<String> myStream
```

So,

`myStream` is pointing to an object of an implementation class.

------------------------------------------------------------------------

## Why doesn't Java tell us the implementation class?

Because Java follows a very important design principle:

> **Program to the Interface, not the Implementation.**

As a programmer, you only need to know:

``` java
filter()

map()

sorted()

forEach()
```

You don't need to know which internal class Java uses.

That gives Java freedom to change its implementation in future versions
without changing your code.

------------------------------------------------------------------------

## Interview Point

**Question: Can we create an object of Stream?**

Answer:

No.

`Stream` is an interface.

Java internally returns an object of a class that implements the Stream
interface.

------------------------------------------------------------------------

# 6. If the object is a class, how can the return type be Stream?

This question naturally comes after the previous one.

You now know Java creates an implementation object.

But then another doubt appears:

> **"If the object is actually StreamImpl, then why is the return type
> Stream?"**

The answer lies in one of Java's most important OOP concepts.

------------------------------------------------------------------------

## Let's start with a simpler example

``` java
interface Animal{
    void sound();
}

class Dog implements Animal{

    public void sound(){
        System.out.println("Bark");
    }
}
```

Now look at this method.

``` java
public Animal getAnimal(){

    return new Dog();
}
```

Many beginners think this should give an error.

But it doesn't.

Why?

Because

``` text
Dog IS-A Animal
```

A Dog object can always be treated as an Animal.

------------------------------------------------------------------------

## The same thing happens with Streams

Imagine Java has

``` java
class StreamImpl<T> implements Stream<T>{

}
```

Now suppose

``` java
public Stream<T> stream(){

    return new StreamImpl<>();
}
```

Is this valid?

Yes.

Because

``` text
StreamImpl IS-A Stream
```

The object belongs to a class that implements the interface.

So Java allows it.

------------------------------------------------------------------------

## Visualize the relationship

``` text
                 Stream
                (Interface)

                     ▲
                     │

          implements │

                     │

               StreamImpl

                     │

          new StreamImpl()
```

The method promises only one thing:

> "I will return something that behaves like a Stream."

It does **NOT** promise which implementation class it will return.

------------------------------------------------------------------------

## Compare with List

Exactly the same concept exists here.

``` java
List<String> list = new ArrayList<>();
```

Reference Type

``` text
List
```

Object Type

``` text
ArrayList
```

Similarly,

``` java
Stream<String> s = list.stream();
```

Reference Type

``` text
Stream
```

Object Type

``` text
Some Internal Stream Implementation
```

The principle is identical.

------------------------------------------------------------------------

## Rule to Remember

A method can return

-   the exact class
-   a superclass
-   an interface implemented by that class

Example

``` java
Dog d = new Dog();

Animal a = new Dog();

Object o = new Dog();
```

All three are valid.

------------------------------------------------------------------------

## Interview Point

A method whose return type is an interface can return an object of **any
class that implements that interface**.

------------------------------------------------------------------------

# 7. Why can't we print a Stream?

Another beginner question:

> **"If a Stream contains elements, why can't we simply write
> System.out.println(stream)?"**

Example

``` java
Stream<Integer> stream = Stream.of(10,20,30);

System.out.println(stream);
```

Most beginners expect

``` text
10
20
30
```

Instead Java prints something similar to

``` text
java.util.stream.ReferencePipeline$Head@5e2de80c
```

Why?

------------------------------------------------------------------------

## Step 1: What exactly is 'stream'?

When you write

``` java
Stream<Integer> stream = Stream.of(10,20,30);
```

`stream` is **not the data**.

It is simply a reference variable pointing to a Stream object.

Just like

``` java
Student s = new Student();
```

Here,

``` java
System.out.println(s);
```

prints something like

``` text
Student@15db9742
```

unless you override `toString()`.

The same thing happens with Stream.

------------------------------------------------------------------------

## Step 2: What does println() actually do?

When you write

``` java
System.out.println(stream);
```

Java internally behaves like

``` java
System.out.println(stream.toString());
```

Since Stream does not override `toString()` to display all its elements,

Java prints the default object representation.

------------------------------------------------------------------------

## Then how do we access the elements?

We need a **Terminal Operation**.

For example

``` java
stream.forEach(x -> System.out.println(x));
```

Now Java starts processing the Stream.

------------------------------------------------------------------------

## Dry Run

Suppose

``` text
Stream

10
20
30
```

Java calls

``` java
forEach(...)
```

Internally it behaves like

``` text
Take 10

↓

println(10)

↓

Take 20

↓

println(20)

↓

Take 30

↓

println(30)
```

Output

``` text
10
20
30
```

------------------------------------------------------------------------

## Why is forEach() called a Terminal Operation?

Because it tells Java:

> "Now start processing the Stream."

Until a terminal operation is called,

nothing actually happens.

Streams are **lazy**.

Example

``` java
Stream<Integer> s =
        Stream.of(1,2,3)
              .filter(x -> x > 1);
```

Has filtering happened yet?

No.

Only after

``` java
s.forEach(System.out::println);
```

does Java begin processing.

------------------------------------------------------------------------

## Pipe Analogy

Think of a Stream as a water pipe.

``` text
Water Tank

     │

     ▼

   Stream Pipe

     │

     ▼

 Terminal Operation
```

The Stream is **not** the water.

It is the **pipe through which the data flows**.

`System.out.println(stream)` prints information about the pipe.

`forEach()` opens the tap and lets the water (elements) flow.

------------------------------------------------------------------------

## Interview Points

-   A Stream is **not a container**.
-   A Stream is a **pipeline** for processing data.
-   `System.out.println(stream)` prints the Stream object's
    representation.
-   To access elements, a **terminal operation** such as `forEach()`,
    `collect()`, or `count()` is required.
