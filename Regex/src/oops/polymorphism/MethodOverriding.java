package oops.polymorphism;

class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child");
    }
}

public class MethodOverriding {
    static void main() {
        Parent p = new Child();

        p.show();      // Child
    }
}

/*
*  Method Overriding Rules:
1. Method name must be the same.
2. Parameter list must be the same.
3. Return type must be the same or covariant (subclass type).
4. Changing only the parameter list results in Method Overloading, not Overriding.
5. Changing only the return type is not allowed.
6. Inheritance is mandatory for Method Overriding.

 Ex of covariant :-

class Animal { }

class Dog extends Animal { }

class Parent {
    Animal getAnimal() {
        return new Animal();
    }
}

class Child extends Parent {
    @Override
    Dog getAnimal() {    // ✅ Allowed
        return new Dog();
    }
}

This is called a covariant return type.
 */