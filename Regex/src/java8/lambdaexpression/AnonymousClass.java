package java8.lambdaexpression;

interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

interface Human {
    void sound();
}

abstract class Monkey {
    abstract void jump();
}

public class AnonymousClass {
    static void main() {
        // Normal way:
        // Create a separate class (Dog) and then create its object.
        Animal dog = new Dog();
        dog.sound();

        // Anonymous Class:
        // Creates an unnamed class and its object simultaneously.
        // Used when the implementation is required only at this place.
        Human h = new Human() {
            @Override
            public void sound() {
                System.out.println("Human Speaks");
            }
        };
        h.sound();
        h.sound();

        // Anonymous class can also extend an abstract class.
        Monkey m = new Monkey() {
            @Override
            void jump() {
                System.out.println("Monkey jumps");
            }
        };
        m.jump();
    }
}
