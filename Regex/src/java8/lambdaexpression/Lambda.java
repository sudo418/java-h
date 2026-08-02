package java8.lambdaexpression;

// Functional Interface (No Parameters)
interface I {
    void display();
}

// Functional Interface (No Parameters)
interface Greeting {
    void sayHello();
}

// Functional Interface (One Parameter)
interface Square {
    int square(int x);
}

// Functional Interface (Two Parameters)
interface Add {
    int add(int a, int b);
}

interface StringLength {
    int stringLength(String name);
}

abstract class Abs {
    abstract void show();
}


public class Lambda {
    static void main() {
        // ============ Anonymous Class ==================
        I i = new I() {
            @Override
            public void display() {
                System.out.println("display method");
            }
        };

        // ========= Lambda Expression ==========
        I i2 = () -> { System.out.println("display method through lambda expression");};
        i2.display();

        // If the method has no parameters, empty parentheses () are mandatory.
        Greeting g1 = () -> System.out.println("Hello World!");   // Single statement -> Curly braces {} are optional.
        g1.sayHello();

        // ============ One Parameter  ==============
        Square sq = x -> {return x*x;};     // One parameter -> Parentheses () are optional.
        System.out.println(sq.square(5));

        /* same code with anonymous class
        Square s = new Square() {
            @Override
            public int square(int x) {
                return x * x;
            }
        };  */

        // ============= Two Parameters ==============
        Add obj = (a, b) -> {return a + b;};   // ⭐ in this {} is compulsory why? ans in 3rd comment
        System.out.println(obj.add(5,6));

        // Shorter Version
        Add obj2 = (a, b) -> a + b;
        System.out.println(obj2.add(10, 20));

        StringLength s = (name) -> {return name.length();};
        System.out.println("The length of string avi is: " + s.stringLength("avi"));

        // Abs abs = () -> {System.out.println("Hello");};   ⭐ Lambda is only used for functional interface, cannot for abstract class
    }
}