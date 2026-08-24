package oops.polymorphism;

class Base {
    // fields are NOT polymorphic — access depends on reference type, not object type
    int a = 10;

    int getA() {
        return a;
    }


    // Private methods are NOT inherited and CANNOT be overridden.
    // They belong only to Base — Derived doesn't even know this method exists.
    private void show() {
        System.out.println("show in Base class");
    }

    // 'final' means this method CANNOT be overridden by any subclass.
    // If a subclass tries to redefine it, the compiler throws an error.
    final void display() {
        System.out.println("display in Base class");
    }
}

class Derived extends Base {
    // this doesn't override 'a', it just hides Base's a with a new one
    int a = 20;

    // Now it gets override, this getA override getA of Base's getA
    int getA() {
        return a;
    }

    // Not overriding — Base's show() is private and hidden from Derived,
    // so this is a new, unrelated method with the same name
    // This is why private methods are said to not participate in polymorphism.
    void show() {
        System.out.println("show in Derived class");
    }

    /* ERROR: display() is final in Base, can't be redefined here — compile error
     final void display() {
        System.out.println("display in Derived class");
    }
    */
}

public class Miscellaneous {
    static void main() {
        Base b = new Base();
        Derived d = new Derived();

        Base base = new Derived();
        System.out.println(base.a);

        // now if u want 20 when u do base.a then u have to convert it to methods
        System.out.println(base.getA());
    }
}
// final in front of class --> then u cant create child of that class