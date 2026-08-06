# Java Stream API - Operations Notes

## Intermediate Operations

Intermediate operations return another Stream and are **lazy**. They
don't execute until a terminal operation is called.

**Intermediate Methods** - `filter()` - Keeps only matching elements. -
`map()` - Transforms each element. - `distinct()` - Removes
duplicates. - `sorted()` - Sorts the elements. - `limit()` - Keeps only
the first `n` elements. - `skip()` - Skips the first `n` elements. -
`peek()` - Observes elements for debugging.

------------------------------------------------------------------------

## Terminal Operations

Terminal operations trigger execution and produce the final result.

Examples: - `forEach()` - `collect()` - `toList()` - `count()` -
`max()` - `min()` - `reduce()`

------------------------------------------------------------------------

# filter()

Keeps only the elements that satisfy the given condition.

``` java
.filter(x -> x % 2 == 0)
```

Input: `2 5 6 7 8`

Output: `2 6 8`

------------------------------------------------------------------------

# map()

Transforms every element into another value.

``` java
.map(x -> x / 2)
```

Input: `2 6 8`

Output: `1 3 4`

Remember:

-   `filter()` changes the **number of elements**.
-   `map()` changes the **value of each element**.

------------------------------------------------------------------------

# distinct()

Removes duplicate elements.

Input: `1 2 2 3 3 4`

Output: `1 2 3 4`

------------------------------------------------------------------------

# sorted()

``` java
.sorted()
```

Sorts in ascending order.

``` java
.sorted((a,b) -> b-a)
```

Sorts in descending order.

------------------------------------------------------------------------

# limit()

Keeps only the first `n` elements.

Useful with `generate()` and `iterate()` because they create infinite
streams.

------------------------------------------------------------------------

# skip()

Skips the first `n` elements.

Example:

`0 1 2 3 4`

After `.skip(2)`:

`2 3 4`

------------------------------------------------------------------------

# peek()

Mainly used for debugging.

Unlike `forEach()`, it is an **intermediate operation**.

It lets you see the elements flowing through the stream without
modifying them.

------------------------------------------------------------------------

# collect(Collectors.toList())

## What does `collect()` do?

`collect()` is a **terminal operation** of the `Stream` interface.

It collects the elements of the stream according to the instructions it
receives.

By itself, it doesn't know whether to create a List, Set or Map.

------------------------------------------------------------------------

## What does `Collectors.toList()` do?

`Collectors` is a utility class.

`Collectors.toList()` creates a **Collector** object.

That Collector tells `collect()`:

> "Store the elements inside a List."

Flow:

Collectors.toList()

↓

Collector

↓

collect()

↓

List

------------------------------------------------------------------------

# toList()

Available from Java 16.

Instead of

``` java
.collect(Collectors.toList())
```

you can write

``` java
.toList()
```

------------------------------------------------------------------------

# max()

Returns the maximum element.

Needs a Comparator.

Returns an `Optional`, so `.get()` extracts the value.

------------------------------------------------------------------------

# count()

Counts the remaining elements after all previous operations.

Returns `long`.

------------------------------------------------------------------------

# Pipeline in Your Code

iterate()

↓

limit()

↓

skip()

↓

peek()

↓

filter()

↓

map()

↓

distinct()

↓

toList()

Only `toList()` starts execution because it is the terminal operation.

------------------------------------------------------------------------

# Important Doubts

### Why can a Stream be used only once?

Because after a terminal operation the stream is consumed.

### Why use peek() instead of forEach()?

Use `peek()` for debugging.

Use `forEach()` for the final action (printing, saving, etc.).
