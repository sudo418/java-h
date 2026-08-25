package oops.enumration;

class PaymentStatus2 {
    public static final int SUCCESS = 1;
    public static final int PENDING = 2;
    public static final int FAILED = 3;
}

enum PaymentStatus3 {
    SUCCESS,
    PENDING,
    FAILED;

}

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY;
}

public class Enums {
    static void main() {
        // first we do like this
        int status = PaymentStatus2.PENDING;

        // now like this
        PaymentStatus3 ps = PaymentStatus3.FAILED;
        System.out.println(ps.name());
        System.out.println(ps);

        // ordinal() - returns the position (index) of the constant, starting at 0
        System.out.println(Day.WEDNESDAY.ordinal());    // 2

        // values() - returns an array of all constants, in declared order
        for (Day d : Day.values()) {
            System.out.println(d);
        }
        /*
         above code == down code
        Day[] day = Day.values();

        for(Day d : day) {
            System.out.println(d);
         */

        // valueOf() - converts a String into the matching enum constant  --> explanation below
        Day d = Day.valueOf("TUESDAY");
        System.out.println(d);
    }
}
/*
 * ============================================================================
 * 📖 Difference Between ps.name() and ps
 * ============================================================================
 *
 * Consider the following code:
 *
 *      PaymentStatus3 ps = PaymentStatus3.FAILED;
 *
 * Here, 'ps' is an enum object that refers to the enum constant FAILED.
 *
 *
 * 1. Printing the enum object
 * ---------------------------------------------------------------------------
 *
 *      System.out.println(ps);
 *
 * At first glance, it looks like we are printing the enum object directly.
 * However, println() does not print the object itself.
 *
 * Whenever an object is passed to println(), Java automatically calls
 * that object's toString() method.
 *
 * So the above statement is internally treated as:
 *
 *      System.out.println(ps.toString());
 *
 * By default, the Enum class implements toString() so that it returns
 * the name of the enum constant.
 *
 * Therefore, the output is:
 *
 *      FAILED
 *
 *
 * 2. Calling name()
 * ---------------------------------------------------------------------------
 *
 *      System.out.println(ps.name());
 *
 * Here, we are not printing the enum object directly.
 *
 * Instead, we are calling the name() method, which belongs to the
 * Enum class.
 *
 * The name() method returns the exact name of the enum constant
 * as a String.
 *
 * In this case:
 *
 *      ps.name()
 *
 * returns:
 *
 *      "FAILED"
 *
 * which is then printed.
 *
 *
 * WHY do both statements produce the same output?
 * ---------------------------------------------------------------------------
 *
 * Both statements print:
 *
 *      FAILED
 *
 * because the default implementation of toString() in the Enum class
 * simply returns the result of name().
 *
 * Therefore:
 *
 *      ps.toString()
 *
 * internally returns:
 *
 *      ps.name()
 *
 * which is why both statements appear to behave exactly the same.
 *
 *
 * The Actual Difference
 * ---------------------------------------------------------------------------
 *
 * The important difference is that name() always returns the original
 * name of the enum constant and cannot be changed.
 *
 * However, toString() can be overridden by the programmer to return
 * a custom String.
 *
 * Example:
 *
 *      @Override
 *      public String toString() {
 *          return "Payment Failed";
 *      }
 *
 * Now:
 *
 *      System.out.println(ps);
 *
 * prints:
 *
 *      Payment Failed
 *
 * whereas:
 *
 *      System.out.println(ps.name());
 *
 * still prints:
 *
 *      FAILED
 *
 * because name() always returns the actual enum constant name.
 *
 *
 * Quick Summary
 * ---------------------------------------------------------------------------
 *
 * name()
 *      -> Returns the original name of the enum constant.
 *      -> Cannot be overridden.
 *      -> Always returns the exact identifier used in the enum.
 *
 * toString() / System.out.println(enumObject)
 *      -> Returns the String representation of the enum object.
 *      -> By default, it returns name().
 *      -> Can be overridden to display a custom, user-friendly value.
 */

/*
 * ============================================================================
 * 📖 valueOf() Method
 * ============================================================================
 *
 * The valueOf() method is used to convert a String into its
 * corresponding enum constant.
 *
 * Syntax:
 *
 *      EnumName.valueOf("CONSTANT_NAME")
 *
 * The String must exactly match the name of an enum constant.
 *
 * Example:
 *
 *      Day d = Day.valueOf("TUESDAY");
 *
 * Java searches the Day enum for an enum constant named "TUESDAY".
 * If it finds one, it returns that enum constant.
 *
 * This is equivalent to:
 *
 *      Day d = Day.TUESDAY;
 *
 * Therefore, the output is:
 *
 *      TUESDAY
 *
 * IMPORTANT:
 *
 * valueOf() is case-sensitive.
 *
 *      Day.valueOf("TUESDAY");   // ✅ Works
 *      Day.valueOf("tuesday");   // ❌ Throws IllegalArgumentException
 *
 * If the specified name does not exist in the enum,
 * valueOf() throws an IllegalArgumentException.
 */