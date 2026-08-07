package oops.constructor;
// 2) this is used in constructor call which is also used in constructor chaining
class Students {
    String name;
    int age;
    int roll;
    String college;

    // in this all constructors are linked to the final constructor, forming a chain
    Students() {
        this("unknown", 0, 0, "unknown");   // constructor call
    }

    Students(String name) {
        // this.name = name;  --> not needed — this(...) call below already delegates
        // initialization to the final constructor, which sets all fields
        this(name, 0, 0, "unknown");
    }

    Students(String name, int age) {
        // this.name = name;
        // this.age = age;
        this(name, age, 0, "unknown");
    }

    Students(String name, int age, int roll) {
        // this.name = name;
        // this.age = age;
        // this.roll = roll;
        this(name, age, roll, "unknown");
    }

    // final/canonical constructor — the only one that actually initializes fields
    Students(String name, int age, int roll, String college) {
        this.name = name;
        this.age = age;
        this.roll = roll;
        this.college = college;
    }
}

public class This2ConstructorChaining {
    static void main() {
        Students s = new Students();
        Students s2 = new Students("hello");
        Students s3 = new Students("world", 22);
        Students s4 = new Students("demo", 23, 101);
        Students s5 = new Students("Test", 25, 102, "iit bombay");

        System.out.println(s2.college);

        Teachers t = new Teachers();
    }
}

class Teachers {
    String name;
    int age;
    int roll;

    // each constructor here is linked to the constructor below it, forming a chain
    Teachers() {
        this("unknow");
        System.out.println("i am in first constructor");
    }

    Teachers(String name) {
        this(name, 0);
        System.out.println("i am in second constructor");
    }

    Teachers(String name, int age) {
        this(name, age, 0);
        System.out.println("i am in third constructor");
    }

    // final/canonical constructor — the only one that actually initializes fields
    Teachers(String name, int age, int roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
        System.out.println("i am in forth constructor");
    }
}
