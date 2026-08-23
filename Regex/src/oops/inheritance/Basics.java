package oops.inheritance;

class A {
    int age = 5;
}

class B extends A {
    // age = 10;   // ❌ NOT allowed — bare statement directly in class body

    int age = 10;   // ⚠️ this is a NEW field, shadows A's age — not the same variable

    /* --> Inside a method or constructor — yes, totally fine:
    void update() {
        age = 20;        // ✅ Changes B.age because B has its own 'age' field
        this.age = 30;   // ✅ Changes B.age — 'this' refers to the current B object
        super.age = 40;  // ✅ Changes A.age — 'super' refers to the parent part of the object
    }
    --> Or inside a constructor:
     B() {
        age = 10;   // ✅ also works
    }   */

    /*
    If B did NOT have its own 'age':

    class B extends A {
        void update() {
            age = 20;        // ✅ Changes inherited A.age
            this.age = 30;   // ✅ Also changes inherited A.age
            super.age = 40;  // ✅ Explicitly changes A.age
        }
    }   */
}

public class Basics {
    static void main() {

    }
}
/*
What's allowed :-
RULE: A class body can only contain DECLARATIONS (fields, methods,
 * constructors, blocks, nested types) — NOT executable statements
 * running on their own. Executable statements must live INSIDE
 * a method, constructor, or block.

class AllowedExample {
    // ✅ ALLOWED — field declaration (with or without initial value)
    int age;
    String name = "Unknown";

    // ✅ ALLOWED — static initializer block (runs once, when class loads)
    static {
        System.out.println("Class loaded");
    }

    // ✅ ALLOWED — instance initializer block (runs every time an object is created)
    {
        System.out.println("Object created");
    }

    // ✅ ALLOWED — constructor declaration (executable code goes INSIDE it)
    AllowedExample() {
        age = 5;
        System.out.println("Constructor ran");
    }

    // ✅ ALLOWED — method declaration (executable code goes INSIDE it)
    void show() {
        System.out.println(age);
        if (age > 3) {
            System.out.println("Age is more than 3");
        }
    }

    // ✅ ALLOWED — nested class declared inside a class
    class Address {
        String city;
    }

What's NOT allowed (bare/standalone statements)
"Bare statement" = any line of code that just does something immediately,
written directly in the class body, not wrapped inside a method,
constructor, or block.
class Student {
    int age = 5;

    System.out.println(age);   // ❌ NOT allowed — bare statement
    age = 10;                   // ❌ NOT allowed — bare statement
    if (age > 3) { }            // ❌ NOT allowed — bare statement
    for (int i = 0; i < 5; i++) { }  // ❌ NOT allowed — bare statement
}
Why? A class is just a blueprint/template — it's not "running" anything.
It only describes what fields and methods exist. Actual code that does
something only makes sense when it's tied to a specific moment of
execution — like "when an object is created" (constructor), "when this
method is called" (method), or "when the class loads" (static block).
A statement floating directly in the class body has no clear moment to
run, so Java doesn't allow it.
 */