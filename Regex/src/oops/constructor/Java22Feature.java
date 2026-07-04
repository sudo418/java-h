package oops.constructor;

/*
 * JEP 447 — Statements before this()/super() (Java 22+)
 *
 * OLD RULE (before Java 22):
 *   this(...) or super(...) HAD to be the very first line in a constructor.
 *   No code of any kind was allowed before it.
 *
 * NEW RULE (Java 22 onwards):
 *   You CAN now write some statements before this()/super() —
 *   BUT ONLY IF those statements do not touch the object being built.
 *   That means: no 'this', no instance fields, no instance methods —
 *   because the object isn't fully constructed yet at that point.
 *
 * Simple way to remember:
 *   Anything that works WITHOUT needing an object (plain code, math,
 *   static methods) → allowed before this()/super()
 *   Anything that NEEDS the object (fields, instance methods, 'this')
 *   → still NOT allowed before this()/super()
 */

class Teacherss {
    String name;
    int age;

    // ================= ALLOWED CASE =================
    Teacherss() {
        // ✅ ALLOWED — just prints plain text, doesn't touch the object at all
        System.out.println("Creating a teacher...");

        // ✅ ALLOWED — simple local variable + math, no connection to 'this'
        int x = 5 + 5;

        // ✅ ALLOWED — static method belongs to the CLASS, not the object,
        // so it can run even before the object exists
        String msg = generateMessage();

        // constructor chaining call — must still happen before any
        // instance-related code runs
        this("unknown");
    }

    Teacherss(String name) {
        this.name = name;
    }

    // static method — no object needed to run this, belongs to the class itself
    static String generateMessage() {
        return "Hello";
    }

    // instance method — needs an actual object to run (uses 'name' field)
    void show() {
        System.out.println(name);
    }

    // ================= NOT ALLOWED CASE (for reference only) =================
    /*
    Teacherss() {
        // ❌ NOT ALLOWED — 'age' is an instance field; object isn't ready yet
        System.out.println(age);

        // ❌ NOT ALLOWED — 'this' directly used before object is fully built
        System.out.println(this);

        // ❌ NOT ALLOWED — show() is an instance method, internally needs 'this'
        show();

        this("unknown");
    }
    */
}

public class Java22Feature {
    public static void main(String[] args) {
        Teacherss t = new Teacherss();
        t.show();
    }
}