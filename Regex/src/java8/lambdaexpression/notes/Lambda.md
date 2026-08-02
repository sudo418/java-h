# 🚀 Lambda Expression Rules & Concepts

## 🧠 1. Why don't we write the data type?

### Example

``` java
Square sq = x -> x * x;
```

Why not write:

``` java
Square sq = (int x) -> x * x;
```

------------------------------------------------------------------------

### ✅ Both are VALID.

Java already knows the parameter type from the **Functional Interface**.

``` java
interface Square {
    int square(int x);
}
```

Since the abstract method already declares that `x` is an `int`, the
compiler automatically **infers** (detects) its type.

Therefore, writing the data type is optional.

Both are equivalent:

``` java
(int x) -> x * x;
```

``` java
x -> x * x;
```

⭐ This feature is called **Type Inference**.

------------------------------------------------------------------------

# ⚡ 2. Short Version (Implicit Return)

If the lambda body contains **only one expression**, you can remove both
**`{}`** and **`return`**.

Instead of:

``` java
(a, b) -> {
    return a + b;
}
```

You can simply write:

``` java
(a, b) -> a + b;
```

Java automatically returns the result of the expression.

⭐ This is called **Implicit Return**.

### 🎯 Interview Tip

> When the lambda body consists of a **single expression without curly
> braces**, the compiler automatically returns the value of that
> expression.

------------------------------------------------------------------------

# 📦 3. Why are `{}` and `return` used together?

When a lambda has **no curly braces `{}`**, Java assumes the body
contains **only one expression**.

Example:

``` java
(a, b) -> a + b;
```

Java automatically returns the value of that expression.

It is treated as if you had written:

``` java
(a, b) -> {
    return a + b;
}
```

This automatic behavior is called **Implicit Return**.

------------------------------------------------------------------------

## 🤔 What changes when we use `{}`?

Once you add curly braces:

``` java
(a, b) -> {

}
```

Java **no longer treats it as a single expression**.

Instead, it treats it exactly like a **normal method body**.

Example:

``` java
(a, b) -> {

    int sum = a + b;

    System.out.println(sum);

    return sum;
}
```

Since this is now a **block of statements**, Java **cannot automatically
determine** what should be returned.

Therefore, **you must explicitly write the `return` statement** (for
methods with a non-`void` return type).

------------------------------------------------------------------------

## 💡 Easy Way to Remember

### ✅ Without `{}`

Java says:

> "I see only one expression, so I'll return it automatically."

------------------------------------------------------------------------

### ✅ With `{}`

Java says:

> "Now you've written a complete method body. You decide what to
> return."

------------------------------------------------------------------------

## 📌 Rules

✅ **Without `{}`** - Implicit Return - `return` is **not required**

✅ **With `{}`** - Explicit Return - `return` is **required** (for
non-`void` methods)

------------------------------------------------------------------------

# ⭐ Quick Revision

-   ✅ Parameter type can be omitted because of **Type Inference**.
-   ✅ Single expression → **Implicit Return**.
-   ✅ No `{}` → `return` is automatic.
-   ✅ With `{}` → You must write `return` yourself.
