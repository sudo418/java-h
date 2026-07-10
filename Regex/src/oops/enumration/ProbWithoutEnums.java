package oops.enumration;

class PaymentStatus {
    public static final int SUCCESS = 1;
    public static final int PENDING = 2;
    public static final int FAILED = 3;

    public static final String PENDINGS = "Pendings";
    /* or we can do
    public static final String SUCCESS = "Success";
    public static final String PENDING = "Pending";
    public static final String FAILED = "Failed";
    */
}

class Role {
    public static final int ADMIN = 1;
    public static final int USER = 2;
    public static final int MANAGER = 2;

    // One more drawback of using int or String constants is that
    // duplicate values are allowed.
    //
    // Here, both USER and MANAGER have the value 2, and the compiler
    // does not report any error because they are just ordinary integers.
    //
    // This can lead to confusion and unexpected bugs, since two different
    // constants represent the same value.
    //
    // The same problem exists when using String constants as well.
    // Enums prevent this kind of mistake because each enum constant
    // represents a unique predefined value.
}

public class ProbWithoutEnums {
    static void main() {

        int status = PaymentStatus.PENDING;
        System.out.println(status);

        if (status == Role.USER) {
            System.out.println("Status matched with Role.USER");
        }

        String status2 = PaymentStatus.PENDINGS;
        if(status2.equals("pendings")) {
            // Another drawback of using String constants is that they are
            // case-sensitive.
            //
            // Here, the value stored in status2 is:
            //
            //      "Pendings"
            //
            // but we are comparing it with:
            //
            //      "pendings"
            //
            // Since the first letter ('P' and 'p') has different cases,
            // both Strings are considered different.
            //
            // Therefore, the condition becomes false and this block will
            // not execute.
            //
            // Such typing mistakes are common when using String constants.
            // Enums eliminate this problem because we use enum constants
            // instead of manually typing String values.
        }
    }
}
/*
 * ============================================================================
 * 📖 Problems Before Enums
 * ============================================================================
 *
 * Before Java introduced enums, programmers usually represented a fixed
 * set of values (such as days of the week, traffic light colors,
 * payment status, etc.) using int or String constants.
 *
 * Example:
 *
 *      public static final int SUCCESS = 1;
 *      public static final int PENDING = 2;
 *      public static final int FAILED  = 3;
 *
 * Although this approach works, it has several disadvantages.
 *
 *
 * 1. Lack of Type Safety
 * ---------------------------------------------------------------------------
 *
 * Type safety means allowing only values that logically belong to a
 * particular category.
 *
 * For example, a payment status should only be SUCCESS, PENDING, or FAILED.
 *
 * However, when we use int or String constants, the variable is still
 * just an int or a String.
 *
 * Therefore, Java cannot prevent us from assigning invalid values.
 *
 * Example:
 *
 *      int status = 100;
 *
 * This compiles successfully even though 100 is not a valid payment status.
 *
 * Similarly:
 *
 *      String status = "Completed";
 *
 * also compiles, even if "Completed" was never defined as a valid status.
 *
 * Since the compiler treats these as normal int or String values,
 * it cannot detect such mistakes during compilation.
 *
 * Another problem is that Java cannot distinguish between different
 * categories that use the same data type.
 *
 * Example:
 *
 *      int status = PaymentStatus.PENDING;
 *
 *      if(status == Role.USER)
 *
 * Both PaymentStatus.PENDING and Role.USER have the value 2.
 *
 * So Java simply compares:
 *
 *      2 == 2
 *
 * and the condition becomes true, even though a Payment Status and
 * a User Role are two completely different concepts.
 *
 * Since both are just integers, the compiler cannot detect this mistake.
 *
 *
 * 2. Poor Readability
 * ---------------------------------------------------------------------------
 *
 * Integer constants do not clearly describe their meaning.
 *
 * Example:
 *
 *      int status = 3;
 *
 * Looking at this code, we cannot immediately understand what
 * the value 3 represents.
 *
 * Is it FAILED?
 * Is it SUCCESS?
 * Is it something else?
 *
 * We have to look somewhere else in the code to find its meaning.
 *
 * Although String constants improve readability,
 * they still have their own problems such as typing mistakes.
 *
 * Example:
 *
 *      "Succes"
 *
 * instead of
 *
 *      "Success"
 *
 * Since both are ordinary Strings, such mistakes are easy to make.
 *
 *
 * 3. No Grouping of Related Constants
 * ---------------------------------------------------------------------------
 *
 * All these constants are simply independent variables.
 *
 * Although we place them inside classes such as PaymentStatus or Role,
 * they are still just ordinary int or String constants.
 *
 * Java does not create a special data type that represents
 * "Payment Status" or "Role".
 *
 * Example:
 *
 *      PaymentStatus.SUCCESS
 *      PaymentStatus.PENDING
 *      PaymentStatus.FAILED
 *
 * These constants are related because they all represent the
 * payment status of a transaction.
 *
 * Similarly:
 *
 *      Role.ADMIN
 *      Role.USER
 *
 * represent different user roles.
 *
 * However, both groups are still just integer constants.
 * Java does not know that the first group represents Payment Status
 * and the second group represents User Roles.
 *
 * Enums solve this by creating a separate data type for each group,
 * ensuring that all related constants belong together under one type.
 */