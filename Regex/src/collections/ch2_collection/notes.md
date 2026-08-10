# Object, Generics and Wildcards in Collection Methods

## 1. `Object o`

```java
remove(Object o)
```

`Object` is the parameter type and `o` is the parameter name.

It means the method accepts an object. We do not have to pass something whose declared type is literally `Object`.

For example:

```java
Integer x = 10;
remove(x);
```

This works because:

```text
Integer
   ↓
Object
```

An Integer is an Object.

---

## 2. Why `contains()` and `remove()` use `Object`

```java
contains(Object o)
remove(Object o)
```

These methods compare the supplied object with elements already in the collection.

Conceptually, the collection can do:

```java
element.equals(o)
```

Every Java object has `equals()` because it comes from `Object`. Classes such as `String` and `Integer` can override `equals()`.

So `Object` lets the method work with an arbitrary object.

---

## 3. Why not use `T`?

Suppose:

```java
List<String> list = new ArrayList<>();
```

If the method were:

```java
contains(T o)
```

it would effectively require a `String`.

But `contains()` only needs to compare the supplied object. It does not need to add it to the collection.

Therefore:

```java
list.contains("Java");
list.contains(10);
```

are both allowed. The second simply returns `false` if 10 is not equal to an element.

Remember:

```text
T       → collection's element type
Object  → any object
```

---
# 4. What is `?`

`?` is called a **wildcard**.

```java
Collection<?> c
```

means:

> A collection of some unknown type.

It could be:

```java
Collection<String>
Collection<Integer>
Collection<Student>
```

The exact type is not important to the method.

---

# 5. Why `Collection<?>`?

For example:

```java
containsAll(Collection<?> c)
removeAll(Collection<?> c)
retainAll(Collection<?> c)
```

These methods do not need to know the exact generic type of the supplied collection.

They simply work with its elements.

So:

```text
Collection<?> 
      ↓
Collection of some unknown type
```

---

# 6. What does `? extends E` mean?

Consider:

```java
addAll(Collection<? extends E> c)
```

`E` means the element type of the current collection.

For example:

```java
Collection<Number> numbers = new ArrayList<>();
```

Here:

```text
E = Number
```

Then:

```java
Collection<? extends Number>
```

means:

> A collection of Number or any subclass of Number.

For example:

```java
Collection<Integer>
Collection<Double>
Collection<Float>
```

are allowed because:

```text
Integer ──┐
Double  ──┼──→ Number
Float   ──┘
```

---

# 7. Why does `addAll()` use `? extends E`?

This is valid:

```java
Collection<Number> numbers = new ArrayList<>();

List<Integer> ints = List.of(1, 2, 3);

numbers.addAll(ints);
```

Every Integer is a Number, so the Integer elements can safely be added to the Number collection.

If the method were only:

```java
addAll(Collection<E> c)
```

then a `Collection<Integer>` would not match `Collection<Number>`.

`? extends E` allows E and its subclasses.

---

# 8. `Collection<?>` vs `Collection<? extends E>`

### `Collection<?>`

```java
Collection<?> c
```

Means:

> Some collection of an unknown type.

Used when the exact type does not matter.

Examples:

```java
containsAll(Collection<?> c)
removeAll(Collection<?> c)
retainAll(Collection<?> c)
```

### `Collection<? extends E>`

```java
Collection<? extends E> c
```

Means:

> A collection of E or a subclass of E.

Example:

```java
addAll(Collection<? extends E> c)
```

---

# 9. Why not use `Object` everywhere?

They have different meanings.

```text
Object
   ↓
Any object
```

```text
?
   ↓
Some unknown generic type
```

```text
? extends E
   ↓
Some type that is E or a subclass of E
```

For your Collection methods:

```text
contains(Object o)
remove(Object o)
        ↓
One arbitrary object
```

```text
containsAll(Collection<?> c)
removeAll(Collection<?> c)
retainAll(Collection<?> c)
        ↓
A collection of unknown type
```

```text
addAll(Collection<? extends E> c)
        ↓
A collection containing E or a subtype of E
```