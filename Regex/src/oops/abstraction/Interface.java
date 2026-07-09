package oops.abstraction;

interface Vehicle {
    // int a;      ❌ Error ->  Java treats it as: public static final int a;
    // A final variable cannot remain uninitialized.
    int a = 10;                 // implicitly: public static final

    void start();               // 1. ABSTRACT METHOD
    void stop();

    static void info() {       // 2. STATIC METHOD
        System.out.println("Vehicles need fuel or charge");
    }

    default void honk() {     // 3. DEFAULT METHOD — has a body, already implemented
        log();                // using the private method internally
        System.out.println("Beep beep!");
    }

    private void log() {     // 4. PRIVATE METHOD (Java 9)
        System.out.println("Logging honk action...");
    }
}


class Bike implements Vehicle {
    /* void start() {         // ❌ Error
        System.out.println("Bike Starting");
    }
    Interface methods are public by default because an interface is a contract meant
    to be usable by any code that references the interface type, and Java requires
    implementing classes to keep the same or wider access level (never narrower) when
    implementing an inherited method — so every implementing class's method must also
    be public.
    */

    @Override
    public void start() {
        System.out.println("Bike starting with a kick");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopping");
    }

    // honk() NOT overridden — Therefore Bike automatically inherits the default
    // implementation provided by the interface
}


class MotorCar implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car starting with a button");
    }

    @Override
    public void stop() {
        System.out.println("Car stopping");
    }

    @Override
    public void honk() {   // overriding the default — custom behavior
        System.out.println("HOOONK! (loud car horn)");
    }
}


abstract class Plane implements Vehicle {
    /* Plane is abstract. Therefore, it is NOT forced to implement start() and stop().
    The responsibility is passed to the first concrete subclass.
    */
    void fly() {
        System.out.println("Plane is flying");
    }
}


class Airbus extends Plane {
    public void start() {
        System.out.println("Plane is starting");
    }

    public void stop() {
        System.out.println("Plane is stopping");
    }

    void takeOff() {
        fly();   // calling inherited fly() directly from inside Airbus
        System.out.println("Airbus has taken off");
    }
}


public class Interface {
    static void main() {

        Vehicle v = new Bike();

        System.out.println(Vehicle.a);
        v.start();
        v.honk();

        Vehicle.info();       // Static methods belong to the interface.

        Vehicle v2 = new Airbus();
        ((Airbus)v2).fly();
        // ✔ Works after downcasting because the actual object is Airbus.
    }
}
/*
KEY RULES OF INTERFACES
- all methods are public abstract by default (unless default/static/private) — you
  don't need to write public abstract explicitly, Java assumes it.
- all variables are public static final by default -> must be
  initialized at declaration (that's why "int a;" alone errors out)
- a class can implement MULTIPLE interfaces (unlike extends, single only)
   ex -> class Amphibious implements Vehicle, Floatable { ... }
- an interface can extend multiple interfaces too.
- cannot create an object of an interface directly
- implementing class must implement ALL abstract methods, unless the
  class itself is declared abstract
*/

/*
WHY INTERFACE VARIABLES ARE public static final :-
An interface is meant to be a shared contract — visible to any class that implements it.
- public  -> every implementing class must be able to see/use it
- static  -> no objects exist for an interface, so it must live at
             interface level
- final   -> keeps it a true constant, no implementing class can
             accidentally change a shared value
*/

/*
4 TYPES OF METHODS IN AN INTERFACE
- Abstract -> just a declaration, no body, must be implemented by the class
- Static   —> (Java 8+), utility-type method, called via interface name
              (Vehicle.info()), can't be overridden by implementing classes
- Default  —> (Java 8+), has a body, optional to override
- Private  —> (Java 9+), internal use only within the interface, not accessible to
              implementing classes at all to avoid code duplication between multiple
              default/static methods;
*/

/*
Types of Methods in Java (overall)
Type            Key point

By whether they belong to object or class
Instance        needs object
Static          belongs to the class itself, called via class name (ClassName.method()), no object needed

By whether they have implementation
Abstract        no body just declaration; must be implemented by a subclass (only in abstract classes/interfaces)
Concrete        has a full body/implementation

By behavior related to inheritance
Final           can't be overridden by any subclass
Overridden      same signature, redefined in child
Overloaded      same name, different params

By special-purpose types (Java 8+ additions, mainly for interfaces)
Default         has a body inside an interface, optional to override
Private         has a body, used internally within a class/interface only, not accessible outside

Others
Native          declared with native keyword, implementation is written in another language (like C/C++), not Java
Synchronized    marked synchronized, used in multithreading to allow only one thread to access it at a time
 */

/*
WHY protected CAN'T BE USED FOR INTERFACE METHODS
- protected relies on a class hierarchy (parent-child via extends)
- interfaces use implements, which can connect completely unrelated
  classes across any package -> no guaranteed inheritance chain
- So protected, private (for abstract methods), and default-access don't fit the
  model — only public guarantees the contract works universally.
- interface's whole purpose is to be a universally accessible contract let any class,
  anywhere, implement it and be usable through that common type.
*/