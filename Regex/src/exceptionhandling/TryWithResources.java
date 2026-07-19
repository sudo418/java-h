package exceptionhandling;

// see below of import statement comment
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    /*
     * WHY try-with-resources was introduced:
     * ------------------------------------------------------------
     * - Before Java 7, if you opened a resource (file, DB
     *   connection, scanner, stream, etc.), you had to manually
     *   close it in a "finally" block to make sure it gets closed
     *   no matter what -- even if an exception occurs.
     *
     * - Problem: this WORKS, but people constantly FORGET to close
     *   it in finally, or close it incorrectly, or forget to
     *   null-check before closing (closing a resource that failed
     *   to open throws its own NullPointerException). This causes
     *   RESOURCE LEAKS -- files/connections stay open, eating up
     *   system memory/handles, even though the program "works".
     *
     * - try-with-resources fixes this by AUTOMATICALLY closing the
     *   resource for you once the try block ends -- whether it
     *   ends normally or via an exception. You don't need to
     *   write a finally block yourself at all.
     *
     * - It works with any class that implements AutoCloseable
     *   (FileReader, BufferedReader, Scanner, Connection, etc.
     *   all implement this interface).
     *
     * - Resource is declared INSIDE the try(...) parentheses --
     *   Java guarantees close() is called on it automatically,
     *   removing the human-error factor of "forgetting" to close.
     */

    static void main() {

        // OLD WAY: manual finally (works, but easy to forget/mess up)
        FileReader fr = null;
        try {
            fr = new FileReader("data.txt");
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        finally {
            try {
                fr.close();   // close() can ALSO throw IOException
            }
            catch (IOException e) {
                System.out.println("Error closing file");
            }
        }

        // NEW WAY: try-with-resources (auto-closes, no finally needed)
        try (FileReader fr2 = new FileReader("data.txt");
             BufferedReader br = new BufferedReader(fr2)) {

            String line = br.readLine();
            System.out.println(line);
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        // no finally block needed -- fr2 and br are AUTOMATICALLY
        // closed here, in reverse order of creation, even if an
        // exception happens above.
    }
}
/*
 * WHAT BufferedReader + readLine() DO HERE:
 * ------------------------------------------------------------
 * - FileReader (fr2) reads the file, but only character-by-
 *   character / in small raw chunks -- slow if used directly
 *   for reading meaningful text.
 *
 * - BufferedReader (br) wraps fr2 and adds a memory buffer.
 *   Instead of hitting the disk for every tiny read, it reads
 *   a big chunk into memory at once, then serves requests from
 *   that memory -- much faster. It also adds useful methods
 *   FileReader doesn't have, like readLine().
 *
 * - br.readLine() reads ONE full line of text from the file
 *   (everything up to the newline character) and returns it as
 *   a String. Returns null when there's nothing left to read
 *   (end of file).
 *
 * - System.out.println(line) just prints that one line.
 *
 * ANALOGY: FileReader is like scooping water from a tap one
 * drop at a time. BufferedReader is like filling a bucket
 * first, then pouring from the bucket -- fewer trips to the
 * tap, much more efficient. readLine() is a convenience tool
 * only BufferedReader gives -- FileReader alone can't hand
 * you a whole line at once.
 *
 * NOTE: this only reads the FIRST line, since readLine() is
 * called just once. To read the WHOLE file, loop instead:
 *     String line;
 *     while ((line = br.readLine()) != null) {
 *         System.out.println(line);
 *     }
 */

/*
import java.io.FileNotFoundException;
// checked exception thrown when trying to open a file (e.g. via
// FileReader) that doesn't exist at the given path

import java.io.BufferedReader;
// wrapper class that adds a memory buffer around a reader (like
// FileReader), letting you read text efficiently -- gives you
// readLine() to read a whole line at once, which raw FileReader
// can't do

import java.io.FileReader;
// class used to read the CONTENTS of a text file, character by
// character (or in small chunks) -- this is what actually opens
// and reads from the file

import java.io.IOException;
// broader checked exception -- the PARENT class of many I/O
// related exceptions (including FileNotFoundException, since
// FileNotFoundException extends IOException). used when
// something goes wrong during reading/writing (disk error,
// stream already closed, etc.), not just "file missing"

 * RELATIONSHIP TO REMEMBER:
 * FileNotFoundException IS-A IOException -- it's a more SPECIFIC
 * subtype. So catch (IOException e) {...} catches BOTH
 * FileNotFoundException AND other IOExceptions, since
 * FileNotFoundException inherits from IOException.
 *
 * That's why in exams, people often catch IOException broadly to
 * cover all file-reading issues in one block, or catch
 * FileNotFoundException specifically first if they want a more
 * precise message for that one case.
 */
