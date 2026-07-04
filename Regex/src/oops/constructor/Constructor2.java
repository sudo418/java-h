package oops.constructor;
// constructor overloading = constructor name must be same but parameter must be different
public class Constructor2 {
    String name;
    int age;

    /* Default Constructor (no-argument, provided by Java if you write none)
    Constructor2() {

    }   */

    //  No-Argument Constructor/ non parameterized constructor (you write it yourself, empty parameters)
    Constructor2() {
        name = "hello";
        age = 50;
    }

    // Parameterized Constructor
    Constructor2(String n, int a) {
        name = n;
        age = a;
        System.out.println("parameterized constructor");
    }

    // Copy Constructor
    Constructor2(Constructor2 c) {
        this.name = c.name;
        this.age = c.age;
    }

    public static void main() {
        Constructor2 c = new Constructor2();
        System.out.println(c.name + " " + c.age);

        Constructor2 c2 = new Constructor2("world", 55);
        System.out.println(c2.name + " " + c2.age);

        Constructor2 c3 = new Constructor2(c2);
        System.out.println(c3.name);

        // without copy constructor
        Constructor2 c4 = new Constructor2(c2.name, c2.age);
    }
}
/*
Default Constructor vs No-Argument Constructor
Default Constructor:-
    🔹Strictly means the compiler-generated constructor — the one javac inserts
      only if you write no constructor at all.
    🔹Always empty body, no arguments.
    🔹The moment you write any constructor yourself (even a no-arg one),
      the compiler stops providing the default one.

No-Argument Constructor
    🔹Simply means any constructor with zero parameters — whether it was
      auto-generated OR written by you.
    🔹Every default constructor is a no-argument constructor, but not
      every no-argument constructor is a default constructor
 */
/*
Creating object inside the same class :-
main() is just a method that happens to live inside the same class as the object
it creates. Java allows any class to instantiate itself from within its own main()
this is actually the most common pattern for testing a class (write the class +
a main in it to quickly run/test it), rather than creating a separate Test class.
*/