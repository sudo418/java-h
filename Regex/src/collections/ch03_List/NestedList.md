# Nested Lists

## 1. What is a Nested List?

A nested list is a list whose elements are themselves lists.

```java
ArrayList<ArrayList<Integer>> al = new ArrayList<>();
```

The outer `ArrayList` stores `ArrayList<Integer>` objects.

```text
al
│
├── [1, 2, 3]   ← ArrayList<Integer>
└── [4, 5, 6]   ← ArrayList<Integer>
```

So:

```java
ArrayList<ArrayList<Integer>>
```

can be read from outside to inside:

```text
ArrayList
    ↓
contains ArrayList<Integer>
              ↓
          contains Integer
```

In simple words:

> An `ArrayList` containing other `ArrayList`s.

---

# 2. What Does `new ArrayList<>()` Mean Here?

Consider:

```java
ArrayList<ArrayList<Integer>> al = new ArrayList<>();
```

The left side tells Java the type of the variable:

```text
ArrayList<ArrayList<Integer>>
```

This means:

> `al` is an `ArrayList` whose elements must be `ArrayList<Integer>` objects.

The right side:

```java
new ArrayList<>()
```

creates the actual outer `ArrayList`.

The `<>` is called the **diamond operator**.

Java can infer the generic type from the left side, so this:

```java
ArrayList<ArrayList<Integer>> al = new ArrayList<>();
```

is equivalent to:

```java
ArrayList<ArrayList<Integer>> al =
        new ArrayList<ArrayList<Integer>>();
```

The shorter version is normally preferred.

---

# 3. Does This Automatically Create the Inner ArrayLists?

No.

This:

```java
ArrayList<ArrayList<Integer>> al = new ArrayList<>();
```

creates only the **outer list**.

Initially:

```text
al
↓
[]
```

There are no inner lists yet.

We must create them separately:

```java
ArrayList<Integer> row1 = new ArrayList<>();

row1.add(1);
row1.add(2);
row1.add(3);

al.add(row1);
```

Now:

```text
al
│
└── [1, 2, 3]
```

Then another row:

```java
ArrayList<Integer> row2 = new ArrayList<>();

row2.add(4);
row2.add(5);
row2.add(6);

al.add(row2);
```

Now:

```text
al
│
├── [1, 2, 3]
└── [4, 5, 6]
```

So the declaration tells us **what the outer list is allowed to store**. It does not automatically create those inner lists.

---

# 4. Why Can't We Do `al.add(1)`?

Suppose:

```java
ArrayList<ArrayList<Integer>> al = new ArrayList<>();
```

The outer list's element type is:

```java
ArrayList<Integer>
```

Therefore Java expects an `ArrayList<Integer>` when we call `al.add()`.

So this is invalid:

```java
al.add(1); // ❌
```

because:

```text
1
↓
Integer
```

but Java expects:

```text
ArrayList<Integer>
```

The correct operation is:

```java
ArrayList<Integer> row = new ArrayList<>();

row.add(1);
row.add(2);
row.add(3);

al.add(row); // ✅
```

The important idea is:

```text
al.add(...)
   ↓
must receive one element of al's element type

ArrayList<ArrayList<Integer>>
          ↑
       element type
```

Therefore:

```java
al.add(1);       // ❌ Integer
al.add(row);     // ✅ ArrayList<Integer>
```

---

# 5. Accessing an Inner List

Suppose:

```text
Index:    0          1
          ↓          ↓
al      [ [1,2,3] , [4,5,6] ]
```

When we write:

```java
al.get(1)
```

we get the entire inner list at outer index `1`:

```text
[4, 5, 6]
```

Therefore:

```java
System.out.println(al.get(1));
```

prints:

```text
[4, 5, 6]
```

---

# 6. Accessing an Element Inside an Inner List

Now suppose we want `5`.

We first get the inner list:

```java
al.get(1)
```

which gives:

```text
[4, 5, 6]
```

Then we call `get(1)` on that inner list:

```java
al.get(1).get(1)
```

The process is:

```text
al
 ↓
get(1)
 ↓
[4, 5, 6]
 ↓
get(1)
 ↓
5
```

Therefore:

```java
System.out.println(al.get(1).get(1));
```

prints:

```text
5
```

This is why nested list access is often written as:

```java
outerList.get(rowIndex).get(columnIndex)
```

---

# 7. Modifying an Inner Element Using `set()`

We can modify an element inside an inner list:

```java
al.get(0).set(1, 20);
```

Break it down:

```text
al.get(0)
    ↓
[1, 2, 3]

set(1, 20)
    ↓
[1, 20, 3]
```

So the complete nested list changes from:

```text
[[1, 2, 3], [4, 5, 6]]
```

to:

```text
[[1, 20, 3], [4, 5, 6]]
```

---

# 8. What Does `set()` Return?

`set()` also **returns the element that was replaced**.

For example:

```java
ArrayList<Integer> row = new ArrayList<>();
row.add(10);
row.add(20);
row.add(30);

int oldValue = row.set(1, 50);

System.out.println(oldValue);
```

Output:

```text
20
```

The list becomes:

```text
[10, 50, 30]
```

So:

```java
row.set(1, 50)
```

means:

```text
index 1:
old value → 20
new value → 50

return → 20
```

Therefore:

```java
System.out.println(al.get(0).set(1, 20));
```

prints the value that was replaced, not the whole modified list.

---

# 9. Adding to an Inner List

We can add an element directly to an inner list:

```java
al.get(1).add(70);
```

First:

```text
al.get(1)
    ↓
[4, 5, 6]
```

Then:

```text
.add(70)
```

gives:

```text
[4, 5, 6, 70]
```

---

# 10. Removing from an Inner List

Similarly:

```java
al.get(1).remove(2);
```

means:

1. Get the inner list at outer index `1`.
2. Remove the element at index `2` from that inner list.

Before:

```text
[4, 5, 6, 70]
 0  1  2   3
```

After:

```text
[4, 5, 70]
```

The `remove()` is happening on the **inner list**, not the outer list.

---

# 11. Nested Iteration Using Enhanced `for`

A nested list normally requires two levels of iteration:

```java
for (ArrayList<Integer> row : al) {
    for (Integer value : row) {
        System.out.println(value);
    }
}
```

The outer loop gets each inner list:

```text
Outer loop
    ↓
[1, 2, 3]

Outer loop
    ↓
[4, 5, 6]
```

The inner loop processes each element.

Output:

```text
1
2
3
4
5
6
```

---

# 12. Nested Iteration Using `Iterator`

You can also iterate through a nested list using `Iterator`.

Create an iterator for the outer list:

```java
Iterator<ArrayList<Integer>> outer = al.iterator();
```

For each inner list, create another iterator:

```java
Iterator<Integer> inner = row.iterator();
```

Complete code:

```java
Iterator<ArrayList<Integer>> outer = al.iterator();

while (outer.hasNext()) {
    ArrayList<Integer> row = outer.next();
    Iterator<Integer> inner = row.iterator();

    while (inner.hasNext()) {
        System.out.println(inner.next());
    }
}
```

Conceptually:

```text
Outer Iterator
      ↓
[1, 2, 3]
      ↓
Inner Iterator
      ↓
1 → 2 → 3

Outer Iterator
      ↓
[4, 5, 6]
      ↓
Inner Iterator
      ↓
4 → 5 → 6
```

A nested list does not change how `Iterator` works. You simply need an iterator for each level.

---

# 13. `List<List<Integer>>`

We can also use the `List` interface:

```java
List<List<Integer>> list = new ArrayList<>();
```

This means:

> The outer collection is a `List`, and each element inside it is also a `List<Integer>`.

For example:

```java
List<Integer> l = new ArrayList<>();
l.add(1);
l.add(2);

list.add(l);
```

Now:

```text
list
 ↓
[[1, 2]]
```

---

# 14. Why Is `List<List<Integer>> list = new ArrayList<>();` Valid?

Because `ArrayList` implements `List`.

```text
List
 ↑
ArrayList
```

Therefore:

```java
List<List<Integer>> list = new ArrayList<>();
```

is valid.

The left side describes the type through which we access the object, while the right side creates an actual `ArrayList`.

---

# 15. Why Is This Invalid?

Consider:

```java
ArrayList<LinkedList<Integer>> arrayLinked = new LinkedList<>();
```

Look at the outer types:

```text
LEFT:
ArrayList<...>

RIGHT:
new LinkedList<>()
```

The variable says it is an `ArrayList`, but the object being created is a `LinkedList`.

`LinkedList` is not a subclass of `ArrayList`.

The relationship is:

```text
             List
            /               /          ArrayList   LinkedList
```

They are separate implementations of `List`.

Therefore:

```java
ArrayList<LinkedList<Integer>> x = new LinkedList<>();
```

is invalid.

---

# 16. Correct: ArrayList Containing LinkedLists

This is valid:

```java
ArrayList<LinkedList<Integer>> arrayLinked = new ArrayList<>();
```

It means:

```text
ArrayList
    ↓
contains LinkedList<Integer>
```

---

# 17. Other Valid Nested Combinations

These are all valid:

```java
ArrayList<ArrayList<Integer>> a = new ArrayList<>();

LinkedList<LinkedList<Integer>> b = new LinkedList<>();

ArrayList<LinkedList<Integer>> c = new ArrayList<>();

LinkedList<ArrayList<Integer>> d = new LinkedList<>();

List<ArrayList<Integer>> e = new ArrayList<>();

List<LinkedList<Integer>> f = new LinkedList<>();
```

The important rule is:

> The actual object created on the right must be compatible with the outer type on the left.

---

# 18. Understanding `List<ArrayList<Integer>>`

Consider:

```java
List<ArrayList<Integer>> listArray = new ArrayList<>();
```

There are two separate things to understand.

### Outer type

```text
List
```

The actual object is:

```text
ArrayList
```

This is valid because:

```text
List
 ↑
ArrayList
```

### Inner type

```text
ArrayList<Integer>
```

This tells us what the outer list can contain.

Therefore:

```java
ArrayList<Integer> row = new ArrayList<>();
listArray.add(row); // ✅
```

but:

```java
LinkedList<Integer> row = new LinkedList<>();
listArray.add(row); // ❌
```

because the inner type specifically requires `ArrayList<Integer>`.

---

# 19. More Flexible Version: `List<List<Integer>>`

If we want both the outer and inner collections to be flexible:

```java
List<List<Integer>> list = new ArrayList<>();
```

we can add different `List` implementations:

```java
ArrayList<Integer> a = new ArrayList<>();
LinkedList<Integer> b = new LinkedList<>();

list.add(a);
list.add(b);
```

Conceptually:

```text
list
 ↓
List
 │
 ├── ArrayList<Integer>
 │
 └── LinkedList<Integer>
```

This is one reason `List<List<Integer>>` is more flexible than:

```java
ArrayList<ArrayList<Integer>>
```

---

# 20. ArrayList-Specific Methods Are Not LinkedList Methods

For example:

```java
ArrayList<Integer> list = new ArrayList<>();

list.ensureCapacity(20); // ✅
list.trimToSize();       // ✅
```

But:

```java
LinkedList<Integer> list = new LinkedList<>();

list.ensureCapacity(20); // ❌
list.trimToSize();       // ❌
```

because those are `ArrayList`-specific methods.

So remember:

```text
List methods
    ↓
Common List behavior

ArrayList-specific methods
    ↓
Only ArrayList
```

---

# 21. Reading Nested Generic Types

When you see:

```java
ArrayList<LinkedList<Integer>>
```

read it from outside to inside:

```text
ArrayList
    ↓
contains LinkedList
              ↓
          contains Integer
```

Similarly:

```java
LinkedList<ArrayList<Integer>>
```

means:

```text
LinkedList
    ↓
contains ArrayList
              ↓
          contains Integer
```

And:

```java
List<List<Integer>>
```

means:

```text
List
 ↓
contains List
       ↓
   contains Integer
```
