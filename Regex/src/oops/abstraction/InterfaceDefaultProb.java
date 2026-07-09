package oops.abstraction;

interface A {
    default void greet() { System.out.println("Hello from A"); }
}

interface B {
    default void greet() { System.out.println("Hello from B"); }
}

class C implements A, B {
    // must override greet(), otherwise compile error — ambiguous which default to use
    public void greet() {
        System.out.println("Hello from C");
    }
}

public class InterfaceDefaultProb {
}
/*
A default method is a method inside an interface that has an actual
implementation (body), introduced in Java 8, marked with the default
keyword. Implementing classes automatically get this method's behavior
without being forced to override it, but they can override it if
they want different behavior
*/

/*
Key rules :-
- marked with default keyword and must have a body
- implementing classes can use it as-is, or override it — both are optional
- called through an object (v1.honk()), unlike static interface methods
- if a class implements two interfaces with the same default method
  signature, the class must override it explicitly to resolve the
  conflict (the "diamond problem")
 */