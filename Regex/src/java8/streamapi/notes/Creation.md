# 📘 Java Stream API Notes (Part 1)

> **Author:** Personal Learning Notes\
> **Topic:** Introduction to Stream API & Stream Creation

------------------------------------------------------------------------

# 📑 Table of Contents

1.  What is Stream API?
2.  Why was Stream API introduced?
3.  Collection vs Stream
4.  Understanding `list.stream()`
5.  Why is `Stream` an Interface?
6.  How can an Interface return an Object?
7.  Why can't we print a Stream?
8.  Why `forEach()` works
9.  Method References (`::`)
10. Ways to Create Streams
11. `Stream.generate()`
12. `Stream.iterate()`
13. Common Mistakes
14. Interview Questions

------------------------------------------------------------------------

# 1. What is Stream API?

## 📌 Interview Definition

> **A Stream is a sequence of elements that supports functional-style
> operations (such as filtering, mapping, sorting and reducing) on data
> from a source without modifying the original data.**

------------------------------------------------------------------------

## 💡 Simple Definition

A **Collection stores data**.

A **Stream processes data**.

Think of it like this:

``` text
Collection
+-------------------------+
| 10 | 20 | 30 | 40 | 50 |
+-------------------------+

        stream()

           ↓

10 → 20 → 30 → 40 → 50

           ↓

Processing (filter/map/sort/...)
```

A stream is **not another collection**.

It is simply a pipeline through which data flows.

------------------------------------------------------------------------

# 2. Why was Stream API introduced?

Before Java 8:

``` java
for(Integer x : list){
    if(x > 20){
        System.out.println(x);
    }
}
```

Need another loop for mapping.

Another loop for sorting.

Another loop for printing.

Using Streams:

``` java
list.stream()
    .filter(x -> x > 20)
    .map(x -> x * 2)
    .sorted()
    .forEach(x -> System.out.println(x));
```

Cleaner. Readable. Less code.

------------------------------------------------------------------------

# 3. Collection vs Stream

Collection                    Stream
  ----------------------------- ------------------------
Stores data                   Processes data
Can add/remove elements       Cannot add/remove
Can traverse multiple times   Normally consumed once
Data container                Processing pipeline

------------------------------------------------------------------------

# 4. Understanding list.stream()

Suppose

``` java
List<String> list = Arrays.asList("apple","banana","cherry");
```

Now

``` java
Stream<String> stream = list.stream();
```

Many beginners think `list.stream()` is an object.

It is NOT.

It is a **method call**.

The `stream()` method returns a Stream object.

``` text
list (object)
      │
      ▼
 stream() method
      │
returns
      ▼
Stream object
```

------------------------------------------------------------------------

# 5. But Stream is an Interface!

Question:

> If Stream is an interface, how can there be a Stream object?

Answer:

You NEVER create it.

Internally Java creates an object of some implementation class.

Imagine Java internally has something like

``` java
class StreamImpl<T> implements Stream<T>{
}
```

Then

``` java
public Stream<T> stream(){
    return new StreamImpl<>();
}
```

You only receive the interface reference.

Exactly like

``` java
List<String> list = new ArrayList<>();
```

Reference Type

``` java
List
```

Actual Object

``` java
ArrayList
```

Same concept:

``` java
Stream<String> s = list.stream();
```

Reference Type

``` java
Stream
```

Actual Object

``` text
Some Internal Stream Implementation
```

------------------------------------------------------------------------

# 6. If the object is a class, how can the return type be Stream?

Because Java allows returning an interface type.

Example

``` java
interface Animal{}

class Dog implements Animal{}

Animal getAnimal(){
    return new Dog();
}
```

Why valid?

Because

``` text
Dog IS-A Animal
```

Similarly

``` text
StreamImpl IS-A Stream
```

------------------------------------------------------------------------

# 7. Why can't we print a Stream?

Suppose

``` java
Stream<Integer> stream = Stream.of(10,20,30);

System.out.println(stream);
```

Output

``` text
ReferencePipeline$Head@...
```

Why?

Because

``` java
System.out.println(stream);
```

internally calls

``` java
stream.toString();
```

The Stream object doesn't print its elements.

It prints its object representation.

To access elements you need a **terminal operation**.

------------------------------------------------------------------------

# 8. Why does forEach() print?

``` java
stream.forEach(x -> System.out.println(x));
```

Dry Run

``` text
Stream

10
20
30

↓

forEach()

↓

println(10)

↓

println(20)

↓

println(30)
```

`forEach()` visits every element.

That is why it prints.

------------------------------------------------------------------------

# 9. What is System.out::println ?

This is called a **Method Reference**.

Instead of

``` java
.forEach(x -> System.out.println(x))
```

you can write

``` java
.forEach(System.out::println)
```

Both are exactly the same.

Since you haven't studied Method References yet, prefer the lambda
version.

------------------------------------------------------------------------

# 10. Ways to Create Streams

## From List

``` java
List<String> list = Arrays.asList("A","B","C");

Stream<String> s = list.stream();
```

Reason:

List has a `stream()` method.

------------------------------------------------------------------------

## From Array

``` java
String[] arr={"A","B","C"};

Stream<String> s=Arrays.stream(arr);
```

Why not

``` java
arr.stream();
```

Because arrays do not have a stream() method.

The utility class `Arrays` provides one.

------------------------------------------------------------------------

## Using Stream.of()

``` java
Stream<Integer> s = Stream.of(10,20,30);
```

No List.

No Array.

Values are directly converted into a Stream.

------------------------------------------------------------------------

## Using Stream.generate()

Syntax

``` java
Stream.generate(Supplier<T>)
```

A Supplier

-   Takes no input.
-   Returns one value.

Example

``` java
Stream.generate(() -> 5)
      .limit(4)
      .forEach(System.out::println);
```

Output

``` text
5
5
5
5
```

### Internal Working

Java repeatedly calls the Supplier.

``` text
Supplier

↓

5

↓

Supplier

↓

5

↓

Supplier

↓

5
```

Every value is generated independently.

Random Example

``` java
Stream.generate(() -> (int)(Math.random()*10))
      .limit(5)
      .forEach(System.out::println);
```

### ⚠ Common Mistake

Wrong

``` java
(int)Math.random()*10
```

Reason

``` text
Math.random() = 0.87

(int)0.87 = 0

0 * 10 = 0
```

Correct

``` java
(int)(Math.random()*10)
```

Now

``` text
0.87 * 10 = 8.7

(int)8.7 = 8
```

------------------------------------------------------------------------

## Using Stream.iterate()

Syntax

``` java
Stream.iterate(seed, rule)
```

Example

``` java
Stream.iterate(1, x -> x + 1)
      .limit(5)
```

Dry Run

``` text
Seed = 1

↓

1

↓

1+1=2

↓

2

↓

2+1=3

↓

3
```

Output

``` text
1
2
3
4
5
```

Every next value depends on the previous one.

------------------------------------------------------------------------

### Common Mistake

``` java
Stream.iterate(1, x -> x*x)
```

People expect

``` text
1
4
9
16
...
```

Actual Output

``` text
1
1
1
1
...
```

Reason

``` text
Seed = 1

1*1 = 1

1*1 = 1

1*1 = 1
```

Correct

``` java
Stream.iterate(1,x->x+1)
      .limit(10)
      .map(x->x*x)
```

------------------------------------------------------------------------

# generate() vs iterate()

generate()                iterate()
  ------------------------- ---------------------------------
Uses Supplier             Uses Seed + Rule
Values are independent    Values depend on previous value
Great for random values   Great for sequences
Usually infinite          Usually infinite

------------------------------------------------------------------------

# Interview Questions

### Q1. Does Stream store data?

❌ No.

It processes data.

### Q2. Can we reuse a Stream?

❌ No.

After a terminal operation it is consumed.

### Q3. Why is limit() commonly used?

Because `generate()` and `iterate()` create infinite streams.

------------------------------------------------------------------------

# End of Part 1

Next Topics

-   filter()
-   map()
-   sorted()
-   distinct()
-   peek()
-   collect()
-   reduce()
-   flatMap()
-   Optional
