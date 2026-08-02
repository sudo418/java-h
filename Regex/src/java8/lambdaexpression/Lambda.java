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
/*
1. Why don't we write the data type?

Example:
Square sq = x -> x * x;
Why not?
Square sq = (int x) -> x * x;
-----------------------------------
Both are VALID.

Java already knows the parameter type from the
Functional Interface.

interface Square {
    int square(int x);
}

Since the method already says that x is an int,
the compiler automatically infers (detects) its type.

Therefore, writing the data type is optional.

Both are equivalent:

(int x) -> x * x

x -> x * x

This feature is called: Type Inference
===========================================================

2. Short Version (Implicit Return)

If the lambda body contains only ONE expression,
you can remove both {} and return.

Instead of:

(a, b) -> { return a + b;}

You can simply write:

(a, b) -> a + b;

Java automatically returns the result of the
expression.

This is called: Implicit Return
---------------------------------
Interview Tip ⭐

The compiler automatically returns the value when
the lambda body consists of a single expression
without curly braces.

===========================================================

3. Why are {} and return used together?

When a lambda has NO curly braces {}, Java assumes the body
contains only ONE expression.

Example:

(a, b) -> a + b;

Here, Java automatically returns the value of the expression.

It is treated as if you had written:

(a, b) -> {
    return a + b;
};

This automatic behavior is called "Implicit Return".

----------------------------------

But once you write curly braces {}, Java no longer treats
the body as a single expression.

Instead, it treats it exactly like a NORMAL METHOD BODY.

Example:

(a, b) -> {
    int sum = a + b;
    System.out.println(sum);
    return sum;
}

Since this now behaves like a normal method body,
Java CANNOT guess which value should be returned.

Therefore, YOU must explicitly write the return statement.

Think of it this way:

Without {}
----------------
Java says:
"I see only one expression.
I'll automatically return it."

With {}
-------------
Java says:
"Now you've written a complete method body.
You decide what to return."

So the rule is:

✔ Without {}  → Java returns the single expression automatically.
✔ With {}     → You must write return yourself (for non-void methods).

===========================================================
 */