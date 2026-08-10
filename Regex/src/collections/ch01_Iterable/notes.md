# Iterable and Iterator --- Easy Internal Flow

## 1. The main idea

There are **two different interfaces**:

-   `Iterable` → gives us an `Iterator`
-   `Iterator` → helps us move through elements one by one

Think of it like this:

``` text
Iterable
   |
   | iterator()
   v
Iterator
   |
   +---- hasNext()
   |
   +---- next()
```

------------------------------------------------------------------------

## 2. `Iterable` is an interface

A simplified version of `Iterable` looks like this:

``` java
interface Iterable<T> {

    Iterator<T> iterator();
}
```

The important part is:

``` java
Iterator<T> iterator();
```

This means:

> Any class that implements `Iterable` must provide an implementation of
> `iterator()`.

Notice that `Iterable` does **not** extend `Iterator`.

It simply has a method whose **return type is `Iterator`**.

------------------------------------------------------------------------

## 3. `ArrayList` implements `Iterable`

Conceptually, `ArrayList` is like:

``` java
class ArrayList<E> implements Iterable<E> {

    public Iterator<E> iterator() {
        // return an Iterator object
    }
}
```

Because `ArrayList` implements `Iterable`, it has to provide the
implementation of:

``` java
iterator()
```

So when we write:

``` java
ArrayList<Integer> list = new ArrayList<>();
```

the list can give us an iterator.

------------------------------------------------------------------------

## 4. What does `iterator()` return?

`iterator()` returns an **Iterator object**.

Conceptually, `ArrayList` can have something like:

``` java
public Iterator<E> iterator() {
    return new ArrayListIterator();
}
```

So:

``` java
Iterator<Integer> it = list.iterator();
```

means:

``` text
list.iterator()
      |
      | calls ArrayList's iterator() implementation
      v
new ArrayListIterator()
      |
      | returns
      v
Iterator object
      |
      v
stored in variable `it`
```

------------------------------------------------------------------------

# 5. But what is `ArrayListIterator`?

`ArrayListIterator` is an object that implements the `Iterator`
interface.

Conceptually:

``` java
class ArrayListIterator<E> implements Iterator<E> {

    public boolean hasNext() {
        // implementation
    }

    public E next() {
        // implementation
    }
}
```

Because it implements `Iterator`, it must provide the methods required
by `Iterator`, such as:

``` java
hasNext()
next()
```

------------------------------------------------------------------------

# 6. The complete relationship

This is the most important diagram:

``` text
                    Iterable
                       |
                       | interface
                       |
                       | has method
                       v
              Iterator<T> iterator()
                       |
                       | implemented by
                       v
                   ArrayList
                       |
                       | iterator() returns
                       v
              ArrayListIterator
                       |
                       | implements
                       v
                   Iterator
                  /        \
                 /          \
                v            v
           hasNext()       next()
```

Another way to see it:

``` text
┌───────────────────────────────┐
│        Iterable<T>            │
│          INTERFACE            │
│                               │
│ Iterator<T> iterator();       │
└───────────────┬───────────────┘
                │
                │ implements
                ▼
┌───────────────────────────────┐
│          ArrayList            │
│                               │
│ Iterator<T> iterator() {      │
│     return new                │
│     ArrayListIterator();      │
│ }                             │
└───────────────┬───────────────┘
                │
                │ returns
                ▼
┌───────────────────────────────┐
│     ArrayListIterator         │
│                               │
│ implements Iterator<T>        │
│                               │
│ hasNext()                     │
│ next()                        │
└───────────────────────────────┘
```

------------------------------------------------------------------------

# 7. What is `Iterator`?

`Iterator` is also an interface.

A simplified version:

``` java
interface Iterator<T> {

    boolean hasNext();

    T next();
}
```

So there are two interfaces:

``` text
Iterable
   |
   | iterator()
   v
Iterator
   |
   +---- hasNext()
   |
   +---- next()
```

Their jobs are different:

### `Iterable`

Its job is:

> "I can provide an Iterator."

### `Iterator`

Its job is:

> "I can move through the elements."

------------------------------------------------------------------------

# 8. Complete example

Suppose:

``` java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
```

Now:

``` java
Iterator<Integer> it = list.iterator();
```

The flow is:

``` text
list
  |
  | iterator()
  v
ArrayList's iterator() method
  |
  | creates/returns
  v
ArrayListIterator object
  |
  | is an
  v
Iterator
  |
  v
it
```

Now:

``` java
it.hasNext();
```

calls the iterator's implementation of `hasNext()`.

And:

``` java
it.next();
```

calls the iterator's implementation of `next()`.

------------------------------------------------------------------------

# 9. How the elements are visited

Suppose:

``` text
list = [10, 20, 30]
```

Initially:

``` text
       ↓
[10] [20] [30]
```

Then:

``` java
it.hasNext();   // true
it.next();      // 10
```

The iterator moves forward:

``` text
      ↓
[10] [20] [30]
```

Then:

``` java
it.hasNext();   // true
it.next();      // 20
```

Then:

``` java
it.hasNext();   // true
it.next();      // 30
```

Finally:

``` java
it.hasNext();   // false
```

------------------------------------------------------------------------

# 10. Why can we write `Iterator<Integer> it`?

Because the actual object returned can be a class that **implements
`Iterator`**.

For example:

``` java
Iterator<Integer> it = new ArrayListIterator();
```

This works because:

``` text
ArrayListIterator
       |
       | implements
       v
   Iterator
```

It is the same idea as:

``` java
Animal a = new Dog();
```

because:

``` text
Dog
 |
 | extends
 v
Animal
```

Similarly:

``` text
ArrayListIterator
 |
 | implements
 v
Iterator
```

------------------------------------------------------------------------

# 11. The entire flow in one diagram

``` text
                  ┌─────────────────────┐
                  │    Iterable<T>      │
                  │      INTERFACE       │
                  │                     │
                  │ iterator()          │
                  │ returns Iterator<T> │
                  └──────────┬──────────┘
                             │
                             │ implemented by
                             ▼
                  ┌─────────────────────┐
                  │      ArrayList      │
                  │                     │
                  │ iterator() {        │
                  │   return new        │
                  │   ArrayListIterator │
                  │ }                   │
                  └──────────┬──────────┘
                             │
                             │ returns
                             ▼
                  ┌─────────────────────┐
                  │ ArrayListIterator   │
                  │                     │
                  │ implements          │
                  │ Iterator<T>         │
                  └──────────┬──────────┘
                             │
                             ▼
                  ┌─────────────────────┐
                  │     Iterator<T>     │
                  │      INTERFACE      │
                  │                     │
                  │ hasNext()           │
                  │ next()              │
                  └─────────────────────┘
```

------------------------------------------------------------------------

# 12. Remember this

The easiest sentence to remember is:

> **Iterable gives an Iterator, and Iterator gives the elements one by
> one.**

Or:

``` text
Iterable
   ↓
iterator()
   ↓
Iterator object
   ↓
hasNext() + next()
   ↓
elements one by one
```

## One important clarification

`Iterable` **does not contain an Iterator object inside it**.

It contains a **method named `iterator()` whose return type is
`Iterator`**.

That method is implemented by classes such as `ArrayList`.

Then `ArrayList`'s `iterator()` method returns an actual object (such as
an internal iterator implementation) that implements `Iterator`.

So:

``` text
Iterable
   ↓
has a method: iterator()
   ↓
ArrayList implements that method
   ↓
method returns an Iterator object
   ↓
Iterator object provides hasNext() and next()
```
