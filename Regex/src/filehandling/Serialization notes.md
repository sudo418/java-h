# Serialization in Java

## Definition (interview-ready)

> **Serialization** is the process of converting an object's state into a byte stream, so that it can be saved to a file, sent over a network, or stored in a database. The reverse process — converting the byte stream back into an object — is called **Deserialization**.

A class must implement the `java.io.Serializable` interface (a **marker interface** — no methods to implement) to be eligible for serialization.

---



Key classes used:
- `ObjectOutputStream` → `writeObject()` for serialization
- `ObjectInputStream` → `readObject()` for deserialization

---

## Important points (often asked in interviews)

### 1. `Serializable` is a marker interface
It has no methods/fields. It just tells the JVM "this class is allowed to be serialized."

---

### 2. `serialVersionUID`

**What it means:** When you serialize an object, Java stamps the byte stream with a version number of the class. When you deserialize later, Java checks: "does this version number match the class currently in my code?" If it doesn't match → error.

**Why it matters:** Imagine you serialize a `Student` object today and save it to a file. Tomorrow, you **edit** the `Student` class (add/remove a field) and then try to read that old file back. Java gets confused — "the object was saved from an older version of this class, I'm not sure it's safe to rebuild it."

```java
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // you fix this manually
    int id;
    String name;
}
```

- If you **don't** write `serialVersionUID` yourself, Java auto-generates one based on class details (fields, methods, etc.) — and it **changes** if you modify the class even slightly.
- If the UID saved in the file ≠ UID of the class trying to read it → `InvalidClassException`.

**Practical rule:** Always declare it manually so minor changes don't accidentally break old saved files.

---

### 3. `transient` keyword

**What it means:** Some fields you don't want saved — e.g., a password, or a temporary calculation. Mark them `transient` and Java skips them during serialization.

```java
class User implements Serializable {
    String username;
    transient String password; // won't be saved
}
```

```java
User u = new User();
u.username = "aman123";
u.password = "secret@123";

// serialize u → save to file

// later, deserialize it back
System.out.println(u.username); // "aman123"
System.out.println(u.password); // null  (default value, not saved)
```

So `password` comes back as `null` (default for String) because it was never actually written to the byte stream.

---

### 4. Static fields are never serialized

**What it means:** `static` fields belong to the **class**, not to any one object. Serialization only saves **object state** (instance variables), so static fields are automatically skipped — you don't even need `transient` for them.

```java
class Counter implements Serializable {
    static int count = 5; // belongs to class, not object
    int id;
}
```

If you serialize a `Counter` object and later deserialize it, `count` will just have whatever value the **class** currently has in memory (not the value at the time of serialization) — because it was never part of the saved object.

---

### 5. Non-serializable superclass

**What it means:** If your class implements `Serializable` but its **parent class** does not, then:
- Fields inherited from the parent are **not saved**.
- When deserializing, Java needs to run the parent's constructor to set up those inherited fields — but it can only call a **no-argument constructor**. If the parent doesn't have one, you get an error.

```java
class Person {              // NOT Serializable
    String country = "India";
    Person() {
        System.out.println("Person constructor ran");
    }
}

class Student extends Person implements Serializable {
    int id;
    String name;
}
```

When you deserialize a `Student`:
- `id` and `name` → restored correctly (they belong to `Student`, which is Serializable).
- `country` → **not restored from the file**. Instead, `Person()` constructor runs fresh, so `country` gets reset to `"India"` (its default from the constructor), not whatever value it had before serialization.

---

### 6. `NotSerializableException`

**What it means:** If you try to serialize a class that does **not** implement `Serializable`, or if it has a field that refers to a non-serializable object (and that field isn't `transient`), Java throws this exception **at runtime** (not compile time).

```java
class Engine {  // does NOT implement Serializable
    String type = "Petrol";
}

class Car implements Serializable {
    String model;
    Engine engine = new Engine(); // problem: Engine isn't Serializable
}
```

```java
Car c = new Car();
oos.writeObject(c); // throws NotSerializableException: Engine
```

**Fix:** either make `Engine implements Serializable` too, or mark the field `transient Engine engine`.

---

### 7. Object graphs (nested objects get serialized too)

**What it means:** If your object has a reference to another object, and both classes are `Serializable`, then serializing the "outer" object automatically serializes the "inner" one too — you don't need to do it separately.

```java
class Engine implements Serializable {
    String type = "Petrol";
}

class Car implements Serializable {
    String model;
    Engine engine; // reference to another object

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }
}
```

```java
Car c = new Car("Swift", new Engine());
oos.writeObject(c); // saves Car AND its Engine object together
```

When you deserialize `c` back, you get the `Car` object **with its `Engine` object fully intact** — same `type` value and all. Java automatically follows the reference chain and serializes everything connected, as long as every class in that chain is `Serializable`.
