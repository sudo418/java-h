package oops.inheritance;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void markAttendence() {
        System.out.println("Attendance is marked");
    }
}

class EngineeringStudent extends Student {
    public EngineeringStudent(String name, int age) {
        super(name, age);
    }

    void attendLab() {
        System.out.println("Lab attendance is marked");
    }
}

public class Simple {
    static void main() {
        EngineeringStudent es = new EngineeringStudent("hello", 20);

        es.markAttendence();
        es.attendLab();
    }
}
/*
============================================================
WHY DOES THE CHILD CLASS NEED A CONSTRUCTOR HERE?
============================================================

Student has only a parameterized constructor:

    Student(String name, int age)

It does not have a no-argument constructor like:

    Student()

When a child class does not explicitly define a constructor,
Java tries to create a default no-argument constructor for it:

    EngineeringStudent() {
        super();
    }

The problem is that super() means:

    "Call the no-argument constructor of the parent."

But Student does not have Student(), so this causes an error.

FLOW:

    EngineeringStudent()
            |
            | Java automatically tries
            v
        super()
            |
            v
        Student()
            |
            X
    Student() does not exist
            |
            v
        COMPILE ERROR


============================================================
APPROACH 1 — CALL THE PARENT'S PARAMETERIZED CONSTRUCTOR
============================================================

Since Student has:

    Student(String name, int age)

we can explicitly call it from EngineeringStudent:

    EngineeringStudent(String name, int age) {
        super(name, age);
    }

Now the flow becomes:

    new EngineeringStudent("Chirayu", 20)
                    |
                    v
        EngineeringStudent(String, int)
                    |
                    | super(name, age)
                    v
             Student(String, int)
                    |
                    v
             this.name = name
             this.age = age
                    |
                    v
          Student construction complete
                    |
                    v
       EngineeringStudent construction complete


This is the approach used in this code.


============================================================
APPROACH 2 — ADD A NO-ARGUMENT CONSTRUCTOR TO STUDENT
============================================================

We can also give Student a no-argument constructor:

    Student() {
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

Now EngineeringStudent can have:

    EngineeringStudent() {
        super();
    }

or Java can automatically use super() if we don't write
a constructor in EngineeringStudent.

FLOW:

    new EngineeringStudent()
            |
            v
    EngineeringStudent()
            |
            | super()
            v
        Student()
            |
            v
       construction complete


============================================================
IMPORTANT RULE
============================================================

When a child constructor is created, the parent constructor
must always be called first.

If you don't explicitly write a constructor call, Java
automatically tries:

    super();

Therefore:

    Parent has Parent()
            |
            v
    super() works
            |
            v
          VALID


But:

    Parent has ONLY Parent(String, int)
            |
            v
    Java tries super()
            |
            v
    Parent() does not exist
            |
            v
          ERROR


So if the parent has only a parameterized constructor,
the child must explicitly call it:

    EngineeringStudent(String name, int age) {
        super(name, age);
    }
*/