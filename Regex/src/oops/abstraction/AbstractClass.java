package oops.abstraction;

abstract class Car {
    void start() {                        // concrete method — has a body,
        System.out.println("Car is starting");   // allowed even in abstract class
    }

    abstract void accelerate();   // abstract method — no body, must be
    abstract void brake();         // implemented by a concrete subclass
}

class PetrolCar extends Car {
    @Override        // good practice in java to use annotation
    void accelerate() {
        System.out.println("Petrol car is accelerating at speed of 10 kmph");
    }

    @Override
    void brake() {
        // implemented (even if empty) — PetrolCar is a CONCRETE class,
        // so it MUST implement every abstract method it inherits
    }
}

abstract class DisealCar extends Car {
    // accelerate() and brake() NOT implemented here — allowed only
    // because DisealCar is itself declared abstract, so it passes the
    // implementation responsibility down to its own subclasses
}

class Scorpio extends DisealCar {
    @Override
    void accelerate() {
        System.out.println("Diseal Car Scorpio is accelerating at the speed of 5 kmph");
    }
    @Override
    void brake() {
        System.out.println("Diseal car Scorpio is stopping");
        // Scorpio is CONCRETE, so it must implement everything still
        // pending from Car (passed through DisealCar)
    }
}

public class AbstractClass {
    static void main() {
        // Car c = new Car();  error -> cannot instantiate an abstract class directly

        Car c = new PetrolCar();   // upcasting — Car reference, PetrolCar object
        c.start();
        c.accelerate();
        c.brake();

        Car c2 = new Scorpio();     // upcasting — Car reference, Scorpio object
        c2.start();
        c2.accelerate();
        c2.brake();
    }

}

/*
IMPORTANT POINTS - ABSTRACT CLASS

1. abstract class can have BOTH abstract methods (no body) and
   concrete methods (with body) -> e.g. start() is concrete,
   accelerate()/brake() are abstract

2. cannot create object of abstract class directly (new Car() -> error)
   must be accessed through a subclass object (upcasting, like c/c2 here)

3. rule: only an ABSTRACT class can leave inherited abstract methods
   unimplemented (like DisealCar does) -> passes the implementation
   responsibility further down the chain

4. rule: a CONCRETE (non-abstract) class MUST implement every abstract
   method it inherits, no exceptions -> PetrolCar and Scorpio both
   implement accelerate() and brake() since they are concrete classes

5. chain here: Car (abstract) -> DisealCar (abstract, still no
   implementation) -> Scorpio (concrete, finally implements everything)
*/

/*
HOW THIS CODE IMPLEMENTS ABSTRACTION

1. user only sees WHAT the car does, not HOW:
   c.accelerate(); c.brake();
   caller doesn't know/care how internally accelerate() works for
   PetrolCar vs Scorpio, that logic is hidden inside each subclass

2. abstract class defines WHAT must exist, without saying HOW:
   abstract void accelerate();
   abstract void brake();
   Car is a contract/blueprint -> every car must be able to do these,
   but Car itself doesn't define how, that's left to subclasses

3. each subclass hides its own internal implementation details:
   PetrolCar accelerates at 10 kmph, Scorpio at 5 kmph -> completely
   different internal logic, but both are called the exact same way
   from outside (c.accelerate(), c2.accelerate())
   caller never needs to know which implementation is actually running

4. multi-level hiding through DisealCar:
   DisealCar extends Car but still doesn't implement accelerate()/brake()
   -> shows abstraction can be layered/staged, responsibility passed
   further down until Scorpio finally provides real implementation

in short: Car defines WHAT (abstract methods) without HOW, each
concrete subclass hides its own implementation while exposing the
same simple method names -> essential functionality shown, internal
complexity hidden
*/