package exceptionhandling;

public class Vote {
    static final int REQUIRED_AGE = 18;

    void checkAge(int age) {
        if (age <= 0) {
            throw  new InvalidAgeException("Age cannot be negative");
        }
        else if (age < REQUIRED_AGE) {
            System.out.println("not eligible");
        }
        else {
            System.out.println("Can vote");
        }
    }

    static void main() {
        Vote v = new Vote();

        try {
            v.checkAge(-5);
        }
        catch (InvalidAgeException e) {
            System.out.println("Age is invalid");
        }
    }
}
/*
 * WHY REQUIRED_AGE is declared OUTSIDE the method (as a field)
 * and marked static final:
 * ------------------------------------------------------------
 * - Written OUTSIDE checkAge() instead of inside it, because:
 *     -> A local variable (inside method) is created fresh and
 *        destroyed every single time the method runs -- wasteful
 *        for a value that never changes.
 *     -> A field (outside method) is set once and can be reused
 *        by ANY method in this class (e.g. if I later add
 *        checkVoterID(), it can use the same REQUIRED_AGE too).
 *
 * - Marked "final" because:
 *     -> 18 is a constant, it should NEVER change once set.
 *     -> final locks the value so it can't be accidentally
 *        reassigned anywhere in the code.
 *
 * - Marked "static" because:
 *     -> This value belongs to the CLASS itself, not to any one
 *        object. Every Vote object should follow the SAME
 *        required age -- no need to store a separate copy of
 *        18 inside every single object.
 *     -> static = shared at class level, not duplicated per
 *        instance.
 *
 * - Naming in ALL_CAPS_WITH_UNDERSCORES is the standard Java
 *   convention for constants (static final fields).
 */