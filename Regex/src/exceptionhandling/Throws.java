package exceptionhandling;

// see comments related these import statements in TryWithResources.java class
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * ============================================================
 * TOPIC: throws keyword & CHECKED EXCEPTIONS
 * ============================================================
 * FileNotFoundException is a CHECKED exception.
 * Checked exceptions are checked by the COMPILER at compile
 * time -- Java forces you to either:
 *   (a) handle it with try-catch, OR
 *   (b) declare it with "throws" and pass the responsibility
 *       up to whoever called this method.
 *
 * If you do neither, the code won't even compile. This is
 * Java's way of making sure file-not-found situations (and
 * other checked exceptions) are never silently forgotten.
 * ============================================================
 */
public class Throws {

    // main() itself declares "throws FileNotFoundException"
    // -> main is passing responsibility UP to whoever calls main.
    // Who calls main? The JVM. So it becomes JVM's responsibility.
    // We generally DON'T do this (answer below)
    static void main() throws FileNotFoundException {

        // FileReader fr = new FileReader("holala");
        // ^ cannot write this line without try-catch (or throws)
        //   because Java ENSURES that IF the file doesn't exist,
        //   there MUST be a defined plan for what happens next.
        //   You can't just leave it unhandled -- compiler error.

        // ------------------------------------------------------
        // CASE 1: Handle it right here with try-catch
        // ------------------------------------------------------
        try {
            FileReader fr = new FileReader("file 1");
        }
        catch (FileNotFoundException e) {
            System.out.println("file 1 not found");
        }

        // ------------------------------------------------------
        // CASE 2: Call a method that handles it INTERNALLY
        // ------------------------------------------------------
        readFile2();

        // ------------------------------------------------------
        // CASE 3: Call a method that PASSES the exception up
        // ------------------------------------------------------
        // readFile3() declares "throws FileNotFoundException"
        // instead of handling it -> so NOW main is the one
        // responsible for catching it. That's why we wrap the
        // call in try-catch here.
        try {
            readFile3();
        }
        catch (FileNotFoundException e) {
            System.out.println("file 3 not found");
        }

        // ------------------------------------------------------
        // CASE 4: Call a method that throws, but we DON'T catch
        // ------------------------------------------------------
        // readFile4() also declares "throws FileNotFoundException".
        // But this time we did NOT wrap it in try-catch.
        // This is legal ONLY because main() itself also declares
        // "throws FileNotFoundException" at the top -- so main
        // is simply passing the responsibility further up, to
        // whoever calls main (the JVM).
        readFile4();
    }


    private static void readFile2() {
        try {
            FileReader ff = new FileReader("file 2");
        }
        catch (FileNotFoundException e) {
            System.out.println("file 2 not found");
        }
    }

    // ------------------------------------------------------
    // readFile3: what if we DON'T want to write try-catch here?
    // -> Use "throws" instead. This means: "I refuse to handle
    // this myself, whoever calls me must deal with it."
    // The responsibility is passed to the CALLER (main, in this
    // case), which is why main wraps readFile3() in try-catch.
    // ------------------------------------------------------
    private static void readFile3() throws FileNotFoundException {
        FileReader ff2 = new FileReader("file 3");
    }

    // ------------------------------------------------------
    // readFile4: same idea -- passes responsibility to caller
    // (main) via "throws". main does NOT catch it, so main
    // passes it further up too (main also declares throws).
    // ------------------------------------------------------
    private static void readFile4() throws FileNotFoundException {
        FileReader ff3 = new FileReader("file 4");
    }
}

/*
 * ============================================================
 * SUMMARY / KEY NOTES
 * ============================================================
 * - "throws" in a method signature = "I am NOT handling this
 *   exception myself. I am giving the responsibility to
 *   whoever calls me."
 *
 * - The JVM does NOT "handle" the exception in the try-catch
 *   sense. When an exception reaches the JVM unhandled, it
 *   simply PRINTS THE STACK TRACE and terminates the program
 *   (or that thread). That's the JVM's default exception
 *   handler.
 *
 * - We generally DON'T do this (i.e. let main throw and rely
 *   on the JVM) in real programs, because it just prints an
 *   ugly stack trace to the user and kills the program. In
 *   real code we handle exceptions ourselves (try-catch) so
 *   we can show a proper message / recover gracefully instead
 *   of crashing.
 *
 * - Moral: every checked exception must have an unbroken chain
 *   of either (catch it) or (throws it further), all the way
 *   up to main -> and then main -> JVM as the final fallback.
 * ============================================================
 */