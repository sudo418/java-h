# 📝 Anonymous Class Notes

## 📖 Definition

> **An Anonymous Class is a class without a name that is declared and
> instantiated at the same time. It is used to provide a one-time
> implementation of a class or interface without creating a separate
> named class.**

------------------------------------------------------------------------

# 🛠️ Syntax

### ✅ Implementing an Interface

``` java
InterfaceReference ref = new Interface() {

    @Override
    public void method() {
        // implementation
    }

};
```

### ✅ Extending an Abstract/Class

``` java
ParentReference ref = new ParentClass() {

    @Override
    void method() {
        // implementation
    }

};
```

------------------------------------------------------------------------

# 🤔 Why do we use Anonymous Classes?

Instead of creating a separate class for a one-time requirement, we can
directly write the implementation where it is needed.

### Example

❌ Traditional Way

``` java
class Dog implements Animal {
    public void sound() {
        System.out.println("Bark");
    }
}
```

✅ Anonymous Class

``` java
Animal a = new Animal() {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
};
```

------------------------------------------------------------------------

# ❓ Can Anonymous Classes implement Interfaces?

✅ Yes.

------------------------------------------------------------------------

# ❓ Can Anonymous Classes extend Abstract Classes?

✅ Yes.

------------------------------------------------------------------------

# 🔁 Can we call methods multiple times?

✅ Absolutely.

``` java
h.sound();
h.sound();
h.sound();
```

> **Remember:** Only the implementation is one-time, **NOT** the object.

------------------------------------------------------------------------

# 💡 Why is it called "One-Time Implementation"?

### ✅ Named Class

``` java
class Dog implements Animal { }
```

Can be reused anywhere.

``` java
Animal a1 = new Dog();
Animal a2 = new Dog();
```

### ❌ Anonymous Class

``` java
Animal a = new Animal() {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
};
```

Since it has **no name**, you cannot create another object like:

``` java
new AnonymousClass(); // Not Possible
```

If you need the same implementation somewhere else, you must write
another anonymous class.

------------------------------------------------------------------------

# ⚙️ Internal Working

Although we write:

``` java
Animal a = new Animal() {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
};
```

The compiler internally generates something similar to:

``` java
class Anonymous123 implements Animal {

    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

Animal a = new Anonymous123();
```

📝 The generated class name is hidden from the programmer.

------------------------------------------------------------------------

# ✅ Advantages

✔ No need to create a separate class.

✔ Reduces boilerplate code.

✔ Perfect for one-time implementations.

✔ Commonly used in Threads, Event Handling and GUI programming.

------------------------------------------------------------------------

# ❌ Disadvantages

❌ Cannot be reused because it has no name.

❌ Large anonymous classes reduce readability.

❌ Lambda Expressions are preferred for Functional Interfaces.

------------------------------------------------------------------------

# 🎯 Interview Answer

> **Anonymous Classes are used when a one-time implementation of a class
> or interface is required. They reduce unnecessary class creation,
> minimize boilerplate code, and are useful when the implementation is
> needed only at one place.**

------------------------------------------------------------------------

# 📌 Revision Summary

✅ Class without a name.

✅ Declared and instantiated together.

✅ Used for one-time implementation.

✅ Can implement interfaces.

✅ Can extend abstract classes.

✅ Object can be reused multiple times.

✅ Only the implementation is one-time.

✅ Compiler creates a hidden class internally.
