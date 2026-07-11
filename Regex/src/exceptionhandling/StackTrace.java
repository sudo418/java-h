package exceptionhandling;

public class StackTrace {
    static void main() {
        int a = 5;
        int b = 0;

        methodA(a, b);   // call 1: main -> methodA (pushed on call stack)
    }

    private static void methodA(int a, int b) {
        methodB(a, b);   // call 2: methodA -> methodB (pushed on call stack)
    }

    private static void methodB(int a, int b) {
        System.out.println(a/b);    // exception occurs HERE (ArithmeticException: / by zero)
        // JVM breaks the normal flow of control right at this point
        // instead of continuing execution, JVM starts UNWINDING the call stack
        // it goes from the TOP of the stack (methodB, where error happened)
        // downward through methodA, then main -> looking for a matching
        // catch block along the way (none exists here, so program terminates)
    }
}
/*
CALL STACK for this program (before the exception hits):

|  methodB(5, 0)   |  <- TOP of stack (currently executing, error happens here)
|  methodA(5, 0)   |
|  main()          |  <- BOTTOM of stack (program entry point)

when the exception occurs, since there's no try-catch anywhere here,
JVM has nothing to handle it -> it prints the STACK TRACE and
terminates the program

STACK TRACE explanation:
- stack trace is basically a "map" of exactly which methods were
  called, in what order, up to the point where the exception happened
- this helps in debugging -> tells us EXACTLY which line, in which
  method, called by which other method, caused the crash
*/

/*
READING THE FULL STACK TRACE, LINE BY LINE

Exception in thread "main" java.lang.ArithmeticException: / by zero
	at exceptionhandling.StackTrace.methodB(StackTrace.java:16)
	at exceptionhandling.StackTrace.methodA(StackTrace.java:11)
	at exceptionhandling.StackTrace.main(StackTrace.java:6)

line 1: Exception in thread "main" java.lang.ArithmeticException: / by zero
- "Exception in thread main" -> tells WHICH thread the exception
  happened in, every java program starts on a default thread called
  "main" (unless extra threads are created ourselves)
- "java.lang.ArithmeticException" -> fully qualified name of the
  exception class (java.lang = package, ArithmeticException = class)
- ": / by zero" -> the exception's MESSAGE, explaining specifically
  what went wrong

line 2: at exceptionhandling.StackTrace.methodB(StackTrace.java:16)
- this is the TOP of the call stack -> exact spot where the exception
  actually occurred
- exceptionhandling.StackTrace -> package + class
- .methodB -> the specific method
- (StackTrace.java:16) -> exact file and line number of the problem

line 3: at exceptionhandling.StackTrace.methodA(StackTrace.java:11)
- the method that CALLED methodB, one step down the call stack
- tells us methodA is who invoked the method where the crash happened

line 4: at exceptionhandling.StackTrace.main(StackTrace.java:6)
- the BOTTOM of the call stack -> the very first method that started
  the whole chain of calls
- shows main called methodA, which then called methodB, where the
  actual error occurred

READING ORDER (always top to bottom):
"the error happened here, which was called from here, which was
called from here, all the way back to where the program started"
-> first line = thread + exception type/message
-> every line after = walks the call stack backward from crash site
   to the program's entry point
*/