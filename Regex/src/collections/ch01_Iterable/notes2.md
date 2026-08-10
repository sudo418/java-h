# Why `Iterable` and `Iterator` Are Separate

There are two important reasons for separating `Iterable` and `Iterator`:

1. **Separation of Concern**
2. **Multiple Independent Traversals**

---

## 1. Separation of Concern

`Iterable` and `Iterator` have different responsibilities.

### `Iterable`

`Iterable` is responsible for **providing an Iterator**.

```java
interface Iterable<T> {
    Iterator<T> iterator();
}
```

Its job is:

> "Give me an object that can traverse my elements."

### `Iterator`

`Iterator` is responsible for **actually traversing the elements**.

```java
interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

Its job is:

> "Tell me whether another element exists and give me the next element."

### Diagram

```text
┌─────────────────────┐
│      Iterable       │
│                     │
│ Responsibility:     │
│ PROVIDE Iterator    │
│                     │
│ iterator()          │
└──────────┬──────────┘
           │
           │ returns
           ▼
┌─────────────────────┐
│      Iterator       │
│                     │
│ Responsibility:     │
│ TRAVERSE elements   │
│                     │
│ hasNext()           │
│ next()              │
└─────────────────────┘
```

This is **Separation of Concerns**:

> Each component should have a clear and separate responsibility.

---

# 2. Multiple Independent Traversals

This is another important reason.

Suppose we create a container and put `hasNext()` and `next()` directly inside it:

```java
class NameContainer {

    private String[] names = {"A", "B", "C", "D"};
    private int cursor = 0;

    public boolean hasNext() {
        return cursor < names.length;
    }

    public String next() {
        return names[cursor++];
    }
}
```

Here the **container itself owns the cursor**.

The cursor represents the current traversal position:

```text
names = [A, B, C, D]

cursor
   ↓
   A    B    C    D
```

We can traverse it once:

```java
while (container.hasNext()) {
    System.out.println(container.next());
}
```

After reaching the end:

```text
cursor = 4
```

If we try to traverse the same container again, the cursor is already at the end.

```text
A    B    C    D
             ↑
          cursor = 4
```

So the container's **data and traversal state are mixed together**.

---

# 3. `Iterable` + `Iterator` Solves This

Instead of storing the cursor in the container, we put the cursor inside the **Iterator**.

The container stores the data:

```text
NameContainer
    |
    └── names = [A, B, C, D]
```

The Iterator stores the traversal state:

```text
Iterator
    |
    └── cursor = 0
```

When we write:

```java
Iterator<String> it = container.iterator();
```

we get a separate object responsible for traversal.

---

# 4. We Can Create Multiple Iterators

Suppose:

```java
Iterator<String> it1 = container.iterator();
Iterator<String> it2 = container.iterator();
```

Now:

```text
                 NameContainer
                [A, B, C, D]
                  /       \
                 /         \
                ▼           ▼
             Iterator     Iterator
                it1          it2
                |             |
           cursor = 0    cursor = 0
```

Both iterators have their **own cursor**.

For example:

```java
it1.next();   // A
it1.next();   // B
```

Now:

```text
it1 cursor = 2
```

But `it2` is still:

```text
it2 cursor = 0
```

So:

```java
it2.next();   // A
```

`it2` can start from the beginning independently.

---

# 5. Why This Is Better

The container contains the **data**:

```text
Container
    ↓
[A, B, C, D]
```

Each Iterator contains its own **traversal state**:

```text
Iterator 1 → cursor = 2
Iterator 2 → cursor = 0
Iterator 3 → cursor = 3
```

Therefore, multiple independent traversals are possible.

```text
                    Container
                  [A B C D]
                  /   |   \
                 /    |    \
                ▼     ▼     ▼
              it1   it2    it3
               |     |      |
            cursor  cursor  cursor
               2     0       3
```

---

# 6. Our `NameContainer` Example

Instead of putting traversal directly inside the container:

```java
class NameContainer {

    private String[] names;
    private int cursor;

    public boolean hasNext() {
        return cursor < names.length;
    }

    public String next() {
        return names[cursor++];
    }
}
```

we separate the responsibilities:

```java
class NameContainer implements Iterable<String> {

    private String[] names;

    public Iterator<String> iterator() {
        return new NameContainerIterator();
    }

    private class NameContainerIterator
            implements Iterator<String> {

        private int cursor = 0;

        public boolean hasNext() {
            return cursor < names.length;
        }

        public String next() {
            return names[cursor++];
        }
    }
}
```

Now:

```text
NameContainer
     |
     | iterator()
     |
     ├──────────────► Iterator 1
     |                 cursor = 0
     |
     ├──────────────► Iterator 2
     |                 cursor = 0
     |
     └──────────────► Iterator 3
                       cursor = 0
```

Each iterator has its own traversal position.

---

# 7. Simple Comparison

## Without `Iterator`

```text
Container
    |
    ├── data
    └── cursor
```

The container is responsible for:

- storing data
- tracking traversal
- providing `next()`
- providing `hasNext()`

The responsibilities are mixed.

Because there is one cursor, independent traversals are not naturally supported.

---

## With `Iterable` + `Iterator`

```text
Container
    |
    └── data

Iterator 1
    └── cursor

Iterator 2
    └── cursor

Iterator 3
    └── cursor
```

Now:

- `Iterable` → provides an Iterator
- `Iterator` → handles traversal
- Container → manages the data
- Each Iterator → has its own traversal state

This gives us **Separation of Concerns** and **independent traversals**.

---

# 8. Main Idea to Remember

### `Iterable`

> **"I can provide an Iterator."**

```java
Iterator<T> iterator();
```

### `Iterator`

> **"I can traverse the elements."**

```java
boolean hasNext();
T next();
```

### Why separate them?

> **1. Separation of concerns:** The container provides the iterator, while the iterator handles traversal.

> **2. Multiple independent traversals:** Each call to `iterator()` can provide a separate Iterator with its own traversal state, allowing the same container to be traversed independently multiple times.

---

# Final Diagram

```text
                         Iterable
                            |
                            | iterator()
                            v
                     +-------------+
                     |  Container  |
                     |             |
                     |    data     |
                     +------+------+
                            |
               +------------+------------+
               |            |            |
               v            v            v
           Iterator 1   Iterator 2   Iterator 3
           cursor = 0   cursor = 0   cursor = 0
               |            |            |
               v            v            v
           traversal    traversal    traversal
           state 1      state 2      state 3
```

## One-line summary

> **`Iterable` separates the responsibility of providing an iterator from `Iterator`, which handles traversal; because each iterator has its own traversal state, the same container can be traversed independently multiple times.**
