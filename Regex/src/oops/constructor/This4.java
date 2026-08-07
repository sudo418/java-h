package oops.constructor;
// 4) this is used in Returning the current object (used in method chaining, like builders)
class Student2 {
    String name;
    int age;

    Student2 setName(String name) {
        this.name = name;
        return this;   // returns the current object
    }

    Student2 setAge(int age) {
        this.age = age;
        return this;   // returns the current object
    }

    void show() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class This4 {
    public static void main(String[] args) {
        Student2 s1 = new Student2();

        // Method chaining — calling multiple methods in one line
        s1.setName("Rahul").setAge(21);

        s1.show();
    }
}
/*
A method can return this to return a reference to the current object,
allowing multiple method calls to be chained together in a single
statement — a pattern commonly used in builder-style designs, where each
method sets a field and returns the same object for the next call.

setName() returns 'this' (same object s1), so calling .setAge() right
after is like writing s1.setAge() again — that's what makes chaining possible
*/