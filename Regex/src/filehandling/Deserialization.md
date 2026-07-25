# Deserialization in Java

## Definition (interview-ready)

> **Deserialization** is the process of reconstructing a Java object from a byte stream — reversing serialization. Java reads the byte stream (from a file, network, etc.) and rebuilds an object with the same state it had when it was serialized.

---




Notes:
- `readObject()` returns type `Object`, so you must **typecast** it back to the original class (`Student` here).
- No constructor of `Student` runs during this process — the object is rebuilt directly from the saved byte data (this is a special JVM mechanism, not a normal `new Student(...)` call). That's why the `serialVersionUID` check matters so much — there's no constructor call to catch mismatches, Java just trusts the byte stream matches the class shape.

---

## Important points (interview-focused)

### 1. Constructor of the serializable class does NOT run
Unlike normal object creation (`new Student(...)`), deserialization skips the constructor entirely and directly restores field values from the byte stream. (Exception: if the superclass isn't serializable — then its no-arg constructor does run, as covered earlier.)

### 2. `ClassNotFoundException`
Thrown if the JVM deserializing the object can't find the class definition on its classpath. Makes sense — you can't rebuild a `Student` object if the JVM doesn't know what a `Student` even looks like.

### 3. `InvalidClassException`
Thrown when `serialVersionUID` of the saved object doesn't match the current class version — i.e., the class has changed since the object was serialized.

### 4. Deserialization restores object graphs too
If `Car` had a nested `Engine` object, deserializing `Car` automatically reconstructs `Engine` as well — no separate step needed.

### 5. Security concern (commonly asked)
Deserialization is considered risky if you deserialize data from an **untrusted source** — a malicious byte stream can be crafted to exploit `readObject()` and execute harmful code (this is a known class of vulnerability called **deserialization attacks**). Best practice: never deserialize data you don't trust, or use safer alternatives like JSON (Gson/Jackson) for external data exchange.

---

## Which exception comes from where, and why

| Exception | Thrown during | Why |
|---|---|---|
| `IOException` | **Both** serialization (`writeObject`) and deserialization (`readObject`) | Both operations involve reading/writing to an underlying stream (file, network, etc.). Any low-level I/O failure — disk full, file not found, stream closed, connection broken — can happen on **either** side. It's a general I/O problem, not specific to converting objects. |
| `ClassNotFoundException` | **Only** deserialization (`readObject`) | This one is specific to rebuilding the object. When deserializing, the JVM reads the class **name** from the byte stream and needs the actual `.class` file to know the field layout and rebuild the object. If that class isn't available on the classpath, it can't proceed. During serialization, you already **have** the object and its class in hand — there's nothing to "look up," so this exception is impossible on the writing side. |

**In short:**
- `IOException` → belongs to the **stream mechanics** (reading/writing bytes) → applies to both directions.
- `ClassNotFoundException` → belongs to **object reconstruction** (needs the class blueprint) → applies only to deserialization, because that's the only direction where Java has to go "find and load a class" to rebuild something.

---

## Why `FileInputStream` and not `FileReader` for reading the file

- **`FileInputStream`** reads the file as raw **bytes** (binary data).
- **`FileReader`** reads the file as **characters** (text) — it assumes the file contains readable text and decodes bytes into characters using some encoding (like UTF-8).

When you serialize an object, `ObjectOutputStream` doesn't write plain readable text into the file. It writes a special **binary format** — a mix of metadata (class name, `serialVersionUID`, field types) and raw field values, all encoded as bytes. If you open `student.txt` in a text editor after serializing, you won't see clean readable text — you'll see garbled symbols, because it's binary data, not character data.

`FileReader` is built to interpret bytes **as text characters** — it would try to decode this binary data as if it were a string of letters, and that would corrupt it or throw errors. It simply isn't designed to handle non-text data.

`FileInputStream` doesn't try to "interpret" anything — it just hands over the raw bytes exactly as they are, which is exactly what `ObjectInputStream` needs to reconstruct the object correctly.

### Simple analogy
- `FileReader` = a person who can only read **English sentences** — give them a text file, they read it fine.
- `FileInputStream` = a scanner that reads **raw ink patterns** on a page without trying to interpret them as words — it just captures exactly what's there, byte for byte.

Serialized data is not "sentences" — it's structured binary data — so you need the byte-level tool (`FileInputStream`), not the character-level tool (`FileReader`).

### Rule of thumb (useful for exams too)

| Use case | Stream type to use |
|---|---|
| Reading/writing plain text files (.txt, .csv) | `FileReader` / `FileWriter` (character streams) |
| Reading/writing binary data (images, serialized objects, audio, video) | `FileInputStream` / `FileOutputStream` (byte streams) |

That's also why `ObjectOutputStream` and `ObjectInputStream` are built **on top of** `FileOutputStream`/`FileInputStream` — never on `FileWriter`/`FileReader`. Object serialization is fundamentally a byte-based format, not a text-based one.