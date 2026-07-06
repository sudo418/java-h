package oops.inheritance;

class Students {
    int a = 10;
    String name;
    int age = 5;

    void markAttendances() {
        System.out.println("Attendance is marked");
    }
}

class EngineeringStudents extends Students{
    int b = 20;
    void show() {
        System.out.println(age);
    }
    void attendLabs() {
        System.out.println("Labs Attendance is marked");
    }
}

class CseEngineeringStudent extends EngineeringStudents {
    int c = 30;
    void cseLabs() {
        System.out.println("Cse labs attended");
    }
}

public class MultiLevel {
    static void main() {
        CseEngineeringStudent cse = new CseEngineeringStudent();

        cse.markAttendances();
        cse.attendLabs();
        cse.cseLabs();

        cse.show();

        System.out.println(cse.a + cse.b + cse.c);
    }
}
/*
System.out.println(age); directly inside the class body —
not allowed.
You can only write declarations (fields, methods, constructors)
directly inside a class body — not executable statements like println.
A statement like this must be inside a method, constructor, or a
block (like a static/instance initializer block)
 */
