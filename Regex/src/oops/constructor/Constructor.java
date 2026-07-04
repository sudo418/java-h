package oops.constructor;

class Student {
    String name;
    int age;
    int roll;          // default value = 0 (automatically)
    String college;   // default value = null (automatically)
}

class Teacher {
    String name;
    int age;

    Teacher() {
        name = "hello";
        age = 50;
    }
}

public class Constructor {
    public static void main() {
        Student s1 = new Student();

        // assigning values manually via dot notation
        s1.name = "Hello";
        s1.age = 20;

        System.out.println("Student name is: " + s1.name + " and student age is: " + s1.age);
        System.out.println(s1.college + " " + s1.roll);
        // Instance/static reference variables → default null, 0, false, etc
        // Local variables → no default, must initialize before use or it's a compile-time error

        int x; // local variable no default value.

        // values assigned automatically via constructor (no dot notation needed)
        Teacher t = new Teacher();
        System.out.println("Teacher name: " + t.name + " age: " + t.age);
    }
}
/*
Q) Local variables have no default values but instance variables have. why?
Reason 1: Object state must always be predictable
An object can be accessed from anywhere — other methods, other classes,
other threads — as soon as it's created. If instance variables didn't have
default values, two objects of the same class could have random/garbage
leftover memory values, and any code touching that object could behave
unpredictably or crash. Java guarantees safety by giving every object a
known, consistent starting state the moment it exists.

Reason 2: Local variables are private to one method, so no need for that guarantee
A local variable is only visible inside the method where it's declared —
nobody else can ever touch it. Since its "danger zone" is small and
controlled, Java doesn't need to protect anyone from it. Instead, Java uses
this fact to catch a real programmer mistake at compile time: if you never
assigned it, you probably forgot to, so the compiler stops you before it
becomes a runtime bug.

Reason 3: Performance — don't pay for safety you don't need
Zeroing out heap memory happens once, during object creation — a one-time
cost. But local variables are created and destroyed constantly
(every single method call). Auto-initializing them every time would add
unnecessary overhead for something the compiler can already check for free
at compile-time.

One-line summary for exams:
"Java guarantees default values for instance variables to ensure
predictable, safe object state since objects are shared and accessed from
multiple places — but for local variables, which are confined to a single
method, Java instead enforces compile-time definite assignment, catching
programmer mistakes early without the runtime cost of auto-initialization."
 */