# Java Stream API Notes

## Why does Stream use Wrapper Classes?

`Stream` is declared as:

``` java
public interface Stream<T>
```

`T` represents an **object type**. Java generics do not support
primitive data types (`int`, `long`, `double`, etc.).

Therefore:

``` java
Stream<int> s;      // ❌ Error
```

is invalid, while

``` java
Stream<Integer> s;  // ✅ Correct
```

works because `Integer` is the wrapper class of `int`.


------------------------------------------------------------------------

# Understanding max(), Optional and get()

``` java
Integer integer = Stream.iterate(0, x -> x + 1)
        .limit(51)
        .filter(x -> x % 2 == 0)
        .map(x -> x / 10)
        .distinct()
        .max((a, b) -> b - a)
        .get();
```

## Step 1

`Stream.iterate()` creates a

``` text
Stream<Integer>
```

After `filter()`, `map()` and `distinct()`, it is **still** a
`Stream<Integer>`.

------------------------------------------------------------------------

## Step 2

`max()` does **not** return an `Integer`.

It returns:

``` java
Optional<Integer>
```

because the stream may be empty.

Example:

``` java
Stream<Integer> s = Stream.empty();

s.max(...);
```

There is no maximum element.

Instead of returning `null`, Java returns an empty `Optional`.

------------------------------------------------------------------------

## What is Optional?

An `Optional` is a container that may contain a value or may be empty.

    Optional
    ┌───────────┐
    │ Integer 5 │
    └───────────┘

or

    Optional
    ┌───────────┐
    │   Empty   │
    └───────────┘

------------------------------------------------------------------------

## What does get() do?

`get()` extracts the actual value from the Optional.

Conceptually:

``` java
Optional<Integer> result = stream.max(...);

Integer value = result.get();
```

Without `get()`:

``` java
Integer value = stream.max(...);   // ❌ Error
```

because `max()` returns `Optional<Integer>`, not `Integer`.

------------------------------------------------------------------------

## Dry Run

Suppose after all stream operations we have:

    0
    2
    4
    5

`max()` returns:

    Optional
    ┌───────────┐
    │     5     │
    └───────────┘

`get()` extracts:

    5

Finally:

``` java
Integer integer = 5;
```

------------------------------------------------------------------------

## What if Optional is empty?

``` java
Optional<Integer> op = Optional.empty();

op.get();
```

throws:

    NoSuchElementException

because there is no value to return.

------------------------------------------------------------------------

## Safer Alternative

``` java
Integer max = stream.max(Integer::compareTo)
                    .orElse(0);
```

If a value exists, it is returned.

Otherwise, `0` is returned.

------------------------------------------------------------------------

# Interview Questions

### Why does Stream use wrapper classes?

Because `Stream` is a generic interface and Java generics accept only
object types. Primitive types cannot be used with generics.

### Why does max() return Optional?

Because the stream may be empty, so Java cannot guarantee a maximum
element exists.

### What does get() do?

`get()` returns the value stored inside an `Optional`. If the `Optional`
is empty, it throws `NoSuchElementException`.
