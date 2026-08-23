package oops.nestedclass;

class Outer {
    int a = 10;

    class Inner {
        int b = 20;
    }
}

public class NestedClass {
    static void main() {
        Outer out = new Outer();    // Outer instance #1
        System.out.println(out.a);

        Outer.Inner oi2 = out.new Inner();      // uses SAME Outer instance as 'out' (instance #1)
        System.out.println(oi2.b);

        Outer.Inner oi = new Outer().new Inner();   // Outer instance #2 (a DIFFERENT, new one)
        System.out.println(oi.b);
    }
}
/*
 * TWO WAYS TO CREATE AN INNER CLASS OBJECT (shown 3 times in code above):
 *
 * 1) new Outer().new Inner()   -> used for 'oi'
 *    - Outer object is created inline (anonymously, no variable name).
 *    - This is a brand-new, separate Outer instance (instance #2),
 *      unrelated to 'out'.
 *    - You cannot access this particular Outer object again directly,
 *      since it has no variable name pointing to it.
 *
 * 2) out.new Inner()   -> used for 'oi2'
 *    - Reuses an ALREADY EXISTING outer instance ('out', instance #1).
 *    - 'oi2' shares the same outer object as 'out', so any change to
 *      out's fields would be reflected when accessed through oi2.
 *
 * KEY TAKEAWAY:
 * Every 'new Outer()' call creates a completely new, independent Outer
 * object. Only 'out.new Inner()' connects the inner object to an outer
 * instance you already have — 'new Outer().new Inner()' always makes
 * its own fresh Outer object first.
 */