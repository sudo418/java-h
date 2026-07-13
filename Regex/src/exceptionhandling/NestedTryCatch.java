package exceptionhandling;
// nested try-catch is not used in real life much, as it makes code
// complicated and hard to read -> avoid where possible
public class NestedTryCatch {
    static void main() {
        try {
            System.out.println("Outer try start");
            try {
                System.out.println("Inner try start");
                System.out.println(5 / 0);
                System.out.println("Inner try ends");  // never printed -> skipped after exception
            }
            catch (ArithmeticException e) {
                // INNER catch matches ArithmeticException -> handled HERE itself
                System.out.println("Dividing by 0 is not allowed: Inner");
            }
            System.out.println("Outer try ends");
        }
        catch (ArithmeticException e) {
            System.out.println("Dividing by 0 is not allowed: outer");
        }
    }
}

class NestedTry {
    static void main() {
        try {
            System.out.println("Outer try");

            try {
                System.out.println("Inner try ");
                System.out.println(5 / 0);
                System.out.println("Inner try ends");
            }
            catch (NullPointerException e) {
                // INNER catch does NOT match -> ArithmeticException was
                // thrown, but this only catches NullPointerException
                // -> exception is NOT handled here, it PROPAGATES upward
                // to the outer try-catch instead
                System.out.println("Null pointer");
            }
            // this line is SKIPPED entirely, since the exception escaped
            // the inner try-catch unhandled and jumped straight to outer catch
            System.out.println("Outer try ends");
        }
        catch (ArithmeticException e) {
            // OUTER catch matches here -> exception finally handled at
            // this level, since inner catch couldn't handle it
            System.out.println("Dividing by 0 is not allowed: Outer");
        }
    }
}
/*
general rule: if an exception isn't caught by the matching type at
one level, it keeps propagating UP through enclosing try blocks until
either a matching catch is found, or the program crashes if none exists
*/