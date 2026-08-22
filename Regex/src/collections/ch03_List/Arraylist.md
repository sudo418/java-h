# ArrayList — Methods, Concepts, and `removeRange()` Deep Dive

## 1. What is `ArrayList`?

`ArrayList` is a resizable array implementation of the `List` interface.

```text
List interface
      ↑
      │ implements
      │
  ArrayList
```

Because `ArrayList` implements `List`, most of the methods you learned while studying `List` are also available in `ArrayList`.

Examples:

```java
add()
add(index, element)
addAll()
get()
set()
remove()
removeAll()
retainAll()
clear()
contains()
indexOf()
lastIndexOf()
subList()
iterator()
listIterator()
```

So after learning the `List` methods, the main things left to study in `ArrayList` are its methods/concepts that are specifically associated with the `ArrayList` implementation.

The important ones are:

```text
ArrayList-specific methods
│
├── clone()
├── ensureCapacity()
├── trimToSize()
└── removeRange()
```

---

# 2. `clone()`

## What does `clone()` do?

`clone()` creates a shallow copy of the `ArrayList`.

For example:

```java
ArrayList<Integer> al = new ArrayList<>();
al.add(10);
al.add(20);
al.add(30);

ArrayList<Integer> copy = (ArrayList<Integer>) al.clone();

System.out.println("Original list: " + al);
System.out.println("Cloned list: " + copy);
```

Output:

```text
Original list: [10, 20, 30]
Cloned list: [10, 20, 30]
```

The cloned list is a separate `ArrayList` object.

```text
Original list
      │
      ↓
 [10, 20, 30]

      clone()

      ↓

Cloned list
      │
      ↓
 [10, 20, 30]
```

If we modify the clone:

```java
copy.add(40);
```

we get:

```text
Original list: [10, 20, 30]
Cloned list:   [10, 20, 30, 40]
```

The original list is not changed.

---

## Why do we write `(ArrayList<Integer>)`?

This was one of the important things to understand.

When we call:

```java
al.clone()
```

the return type is `Object`.

Conceptually:

```java
Object clone()
```

Therefore this does not work:

```java
ArrayList<Integer> copy = al.clone(); // ❌
```

because Java sees:

```text
Required: ArrayList<Integer>
Found:    Object
```

So we cast the returned `Object` to `ArrayList<Integer>`:

```java
ArrayList<Integer> copy = (ArrayList<Integer>) al.clone();
```

Think of it as:

```text
al.clone()
    ↓
  Object
    ↓
(ArrayList<Integer>)
    ↓
ArrayList<Integer>
```

This is called type casting.

---

## Important point about `clone()`

`ArrayList.clone()` creates a **shallow copy**.

For simple immutable wrapper objects such as `Integer`, this is usually easy to understand because the integer references themselves do not cause a visible problem.

The important point for now is:

> `clone()` creates another `ArrayList` object containing the same element references.

---

# 3. `ensureCapacity()`

## What is capacity?

This is an important distinction:

```text
size     = number of actual elements
capacity = amount of internal space currently available
```

For example:

```java
ArrayList<Integer> list = new ArrayList<>();

list.ensureCapacity(20);

list.add(1);
list.add(2);
list.add(3);
```

Now:

```text
size     = 3
capacity = at least 20
```

The important thing is that:

```java
list.size()
```

returns the number of actual elements.

It does **not** return the capacity.

```java
System.out.println(list.size()); // 3
```

---

## Does ArrayList have a `capacity()` method?

No.

There is no:

```java
list.capacity(); // ❌
```

`ArrayList` does not provide a public method that directly tells you its current internal capacity.

You can use:

```java
list.size();
```

to get the number of elements, but not the capacity.

---

## Why would we use `ensureCapacity()`?

`ArrayList` internally uses an array.

When the internal array becomes full, the `ArrayList` may need to create a larger array and copy the existing elements into it.

If you already know that you are going to add many elements, you can request enough capacity in advance.

For example:

```java
ArrayList<Integer> list = new ArrayList<>();

list.ensureCapacity(1000);
```

This can reduce unnecessary resizing operations.

You generally do not need to use this in normal small programs, but it is useful to understand how `ArrayList` manages its internal storage.

---

# 4. `trimToSize()`

`trimToSize()` is related to capacity.

It reduces the internal capacity to match the current size as closely as the implementation allows.

Example:

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
list.add(40);

list.trimToSize();
```

Conceptually:

```text
Before:

size     = 4
capacity = larger than 4

        ↓
 trimToSize()

After:

size     = 4
capacity ≈ 4
```

The important point is:

> `trimToSize()` does not remove elements.

This:

```java
list.trimToSize();
```

does NOT change:

```text
[10, 20, 30, 40]
```

into a smaller list.

The elements remain exactly the same.

It only deals with the internal capacity.

---

# 5. `removeRange()`

`removeRange()` is another method associated with `ArrayList`.

Its signature is:

```java
protected void removeRange(int fromIndex, int toIndex)
```

The most important thing to notice is:

```text
protected
```

and also that `toIndex` is **exclusive**.

---

## How does `removeRange()` work?

Suppose we have:

```text
Index:    0    1    2    3    4    5
          ↓    ↓    ↓    ↓    ↓    ↓
List:    [10] [20] [30] [40] [50] [60]
```

If we call:

```java
removeRange(1, 4);
```

the elements at indexes:

```text
1, 2, 3
```

are removed.

Index `4` is not removed.

```text
         ┌───────────────┐
         ↓               ↓
[10] [20] [30] [40] [50] [60]
      └───────────────┘
          removed
```

Result:

```text
[10, 50, 60]
```

So:

```text
fromIndex → inclusive
toIndex   → exclusive
```

This is similar to the exclusive-end behavior you saw with other Java APIs such as `subList()` and iterator positions.

---

# 6. Why can't we simply call `removeRange()`?

This is where the `protected` keyword becomes important.

Suppose we write:

```java
ArrayList<Integer> list = new ArrayList<>();

list.removeRange(1, 4); // ❌
```

This is not allowed because `removeRange()` is `protected`.

The method is not a normal public `ArrayList` method.

Its declaration is:

```java
protected void removeRange(int fromIndex, int toIndex)
```

So Java's access rules matter here.

---

# 7. Why did we create `MyArrayList`?

We created:

```java
static class MyArrayList<E> extends ArrayList<E>
```

because a subclass of `ArrayList` can access the protected method.

The relationship is:

```text
             ArrayList
                 │
                 │ extends
                 ↓
            MyArrayList
                 │
                 └── can access protected removeRange()
```

Our class:

```java
static class MyArrayList<E> extends ArrayList<E> {
    public void removeRangeElements(int frontIndex, int toIndex) {
        removeRange(frontIndex, toIndex);
    }
}
```

has a public method:

```java
removeRangeElements()
```

and inside that method it calls the protected:

```java
removeRange()
```

So the flow is:

```text
main()
  │
  ↓
removeRangeElements(1, 4)
  │
  ↓
MyArrayList
  │
  ↓
removeRange(1, 4)
  │
  ↓
ArrayList's protected method
```

---

# 8. Why did we make `MyArrayList` a nested class?

This was another important doubt.

We wrote:

```java
public class ArrayListDemo {

    static class MyArrayList<E> extends ArrayList<E> {
        ...
    }

    static void main() {
        ...
    }
}
```

You might ask:

> Why does `MyArrayList` have to be inside `ArrayListDemo`?

It does **not**.

We could have created `MyArrayList` as a completely separate top-level class.

For example:

```text
collections.ch03_List
│
├── ArrayListDemo.java
└── MyArrayList.java
```

That is perfectly valid.

The reason we originally made it nested was simply convenience: the helper class was small and was only being used for this demonstration.

There is no special relationship between:

```java
static class MyArrayList<E>
```

and `removeRange()`.

---

# 9. Separate `MyArrayList` class

Instead of a nested class, we can create a separate file.

### `MyArrayList.java`

```java
package collections.ch03_List;

import java.util.ArrayList;

public class MyArrayList<E> extends ArrayList<E> {

    public void removeRangeElements(int fromIndex, int toIndex) {
        removeRange(fromIndex, toIndex);
    }
}
```

Then `ArrayListDemo.java` can use it:

```java
package collections.ch03_List;

public class ArrayListDemo {

    static void main() {

        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);

        System.out.println("Original list: " + list);

        list.removeRangeElements(1, 4);

        System.out.println("After removing range: " + list);
    }
}
```

Output:

```text
Original list: [10, 20, 30, 40, 50, 60]
After removing range: [10, 50, 60]
```

This is exactly the same idea as the nested version.

The only difference is where the subclass is declared.

---

# 10. Why was the nested class declared `static`?

If we write:

```java
public class ArrayListDemo {

    static class MyArrayList<E> extends ArrayList<E> {
        ...
    }
}
```

`MyArrayList` is a static nested class.

This allows us to create it directly from the static `main()` method:

```java
MyArrayList<Integer> list = new MyArrayList<>();
```

If we removed `static`:

```java
class MyArrayList<E> extends ArrayList<E> {
}
```

then it would be a non-static inner class.

We would need an instance of the outer class to create it:

```java
ArrayListDemo obj = new ArrayListDemo();

ArrayListDemo.MyArrayList<Integer> list =
        obj.new MyArrayList<>();
```

That is unnecessary for this example.

---

# 11. What if `ArrayListDemo` itself extends `ArrayList`?

This was another important doubt.

Yes, we can do this:

```java
public class ArrayListDemo extends ArrayList<Integer> {

    public void removeMyRange(int fromIndex, int toIndex) {
        removeRange(fromIndex, toIndex);
    }

    static void main() {

        ArrayListDemo list = new ArrayListDemo();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        list.removeMyRange(1, 4);

        System.out.println(list);
    }
}
```

Here:

```text
ArrayListDemo
      │
      │ extends
      ↓
ArrayList<Integer>
```

Therefore `ArrayListDemo` itself is a subclass of `ArrayList`.

Inside the subclass method:

```java
public void removeMyRange(int fromIndex, int toIndex) {
    removeRange(fromIndex, toIndex);
}
```

we can access the protected method.

So there is no need for `MyArrayList` in this version.

---

# 12. Why not just make `removeRange()` public?

We cannot change Java's `ArrayList` class.

The JDK provides:

```java
protected void removeRange(int fromIndex, int toIndex)
```

We cannot simply modify it to:

```java
public void removeRange(int fromIndex, int toIndex)
```

Instead, a subclass can expose its own public method that calls the inherited protected method.

For example:

```java
public void removeMyRange(int fromIndex, int toIndex) {
    removeRange(fromIndex, toIndex);
}
```

---

# 13. Final ArrayList-specific checklist

After covering the normal `List` methods, these are the important `ArrayList`-specific methods/concepts you should know:

| Method | Purpose |
|---|---|
| `clone()` | Creates a shallow copy of the `ArrayList` |
| `ensureCapacity()` | Ensures a minimum internal capacity |
| `trimToSize()` | Reduces internal capacity toward the current size |
| `removeRange()` | Removes elements from a range; `toIndex` is exclusive and the method is protected |

### Important capacity distinction

```text
size
 ↓
Number of actual elements

capacity
 ↓
Internal storage available for elements
```

And there is no normal public:

```java
list.capacity();
```

method.
