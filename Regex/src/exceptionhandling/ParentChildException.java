package exceptionhandling;

public class ParentChildException {
    static void main() {
        try {
            System.out.println(5 / 0);
            String s = null;
            s.length();
        }
        /* --> Cannot place catch(Exception) here because Exception is the
         * parent of ArithmeticException, NullPointerException, and
         * RuntimeException.
         * --> Catch blocks must always be ordered from child -> parent
         * (most specific -> most general).
         * --> If the parent catch comes first, it will catch all of its
         * child exceptions, making the child catch blocks unreachable.
         * --> Therefore, the compiler reports an "Unreachable catch block"
         * error.
        catch (Exception e) {
            System.out.println("some generic Exception");
        }
         */
        catch (ArithmeticException e) {
            System.out.println("Divide by 0");
        }
        catch (NullPointerException e) {
            System.out.println("null not allowed");
        }
        /* Compilation Error:
         * RuntimeException is the parent of ArithmeticException and NullPointerException.
         * In a multi-catch block, we can combine sibling exceptions,
         * but we cannot combine a parent class with any of its child
         * classes because the parent already covers the child.
        catch (ArithmeticException | NullPointerException | RuntimeException e) {

        } */
        catch (RuntimeException e) {
            System.out.println("some runtime exception");
        }
        catch (Exception e) {
            System.out.println("some generic Exception");
        }
    }
}
/*
The JVM checks the catch blocks from top to bottom and executes the
first compatible catch block. That's why Java requires the catch blocks
to be ordered from child to parent. Otherwise, child catch blocks
become unreachable and the compiler rejects the code.
 */