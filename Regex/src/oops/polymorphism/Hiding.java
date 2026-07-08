package oops.polymorphism;

class Super {
    static void show() {
        System.out.println("Static in Super");
    }
}

class Sub extends Super {
    static void show() {           // void show --> error explained below
        System.out.println("Static in Sub");
    }
}

public class Hiding {
    static void main() {
        Super s1 = new Sub();

        Super.show();
        Sub.show();

        s1.show();
    }
}
/*
static-ness must match exactly when hiding/overriding:
- parent static + child static       -> allowed, this is METHOD HIDING
- parent non-static + child non-static -> allowed, this is METHOD OVERRIDING
- parent static + child non-static   -> compile-time ERROR
- parent non-static + child static   -> compile-time ERROR

error example if static-ness doesn't match:
error: show() in Sub cannot override show() in Super
  overridden method is static

reason java forbids mismatched static-ness:
- static methods belong to the CLASS itself, resolved at compile-time,
  no object needed
- instance methods belong to OBJECTS, resolved at runtime, need an
  actual object
- switching between the two across parent-child would create a
  contradiction about how the method should be called, so java blocks
  it entirely
*/

/*
why is it called "hiding" if s1.show() still prints Super's version?

- s1.show() prints Super's version because static calls through a
  reference use the REFERENCE'S DECLARED TYPE (Super), not the object
  -> this is a separate rule, not related to hiding itself

- "hiding" actually refers to NAME RESOLUTION INSIDE Sub's own code:
  if we just wrote show() inside Sub, it would always call Sub's own
  version -> Super's show() is no longer directly reachable by that
  name from inside/through Sub, unless we explicitly write Super.show()

- so Super's show() still exists, it's just "hidden" behind Sub's
  version when accessed via Sub
*/