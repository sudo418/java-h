package exceptionhandling;

public class ExceptionHierarchy {
    static void main() {

        try {
            System.out.println(5 / 0);
        }
        catch (RuntimeException e) {           // see below
            System.out.println(e.getMessage());
            System.out.println("Caught by RuntimeException");
        }

        // Also valid because Exception is the parent of RuntimeException.
        // It can catch all checked and unchecked exceptions.
        // This is the highest exception class we generally catch.
        catch (Exception e) {     // maximum we can write this
            System.out.println(e);
            System.out.println("Caught by Exception");
        }

        // Technically valid because Throwable is the root class of both - Exception and Error.
        // Not recommended because it catches Errors (e.g., OutOfMemoryError, StackOverflowError)
        // along with Exceptions. Errors represent serious JVM/system-level problems that
        // applications are generally not expected to handle or recover from.
        // In normal programs, we catch Exceptions, not Errors.
        catch (Throwable e) {
            System.out.println("Caught by Throwable");
        }
    }
}
/*
 * How this works internally: (Line 9 - 11)
 *
 * The statement:
 *      System.out.println(5 / 0);
 *
 * causes the JVM to create an ArithmeticException object.
 * Internally, it is similar to:
 *
 *      ArithmeticException obj =
 *          new ArithmeticException("/ by zero");
 *
 * Since ArithmeticException is a child of RuntimeException,
 * the catch block performs upcasting:
 *
 *      RuntimeException e =
 *          new ArithmeticException("/ by zero");
 *
 * This is a classic example of:
 *      Parent Reference -> RuntimeException
 *      Child Object     -> ArithmeticException
 *
 * The exception message ("/ by zero") is NOT stored directly
 * inside ArithmeticException. The constructor chain is:
 *
 *      ArithmeticException(...)
 *              ↓
 *      RuntimeException(...)
 *              ↓
 *      Exception(...)
 *              ↓
 *      Throwable(...)
 *
 * The Throwable constructor stores the message in its
 * 'detailMessage' field.
 *
 * So, although the actual object is ArithmeticException,
 * the message is inherited from Throwable.
 *
 * RuntimeException also inherits the getMessage() method
 * from Throwable. Therefore, the parent reference 'e' can
 * call:
 *
 *      e.getMessage();
 *
 * which returns the value stored in the Throwable part of
 * the ArithmeticException object ("/ by zero").
 *
 * Key Point:
 * Since getMessage() is available in
 * RuntimeException (inherited from Throwable), it can be
 * called using a RuntimeException reference, even though
 * the actual object is ArithmeticException.
 */