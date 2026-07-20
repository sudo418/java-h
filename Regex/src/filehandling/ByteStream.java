package filehandling;

import java.io.*;

public class ByteStream {
    static void main() {
        try (FileOutputStream fos = new FileOutputStream("D:\\code\\java\\Regex\\src\\filehandling\\Byte\\a.txt")) {
            String text = "Hello World";
            // String text = "Welcome";    it will overwrite the Hello World
            fos.write(text.getBytes());  // convert string to bytes
            System.out.println("File created and data written successfully.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("D:\\code\\java\\Regex\\src\\filehandling\\Byte\\a.txt")) {
            int i;
            while((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        // without try-with-resources
        FileInputStream fiss = null;
        try {
            fiss = new FileInputStream("D:\\code\\java\\Regex\\src\\filehandling\\Byte\\a.txt");

            int i;
            while ((i = fiss.read()) != -1) {
                System.out.print((char) i);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {               // explanation in below notes
            try {
                if (fiss != null) {
                    fiss.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
═══════════════════════════════════════════════════════════════════════════════
📖 1. Reading a File - while ((i = fis.read()) != -1)
═══════════════════════════════════════════════════════════════════════════════

* fis.read() reads one byte (one character for normal text) from the file
* and returns it as an int. The returned value is stored in the variable 'i'.
* We store it in an int because read() returns values from 0-255 for valid bytes
* and returns -1 when the end of the file is reached.
*
* The condition checks whether the returned value is -1.
* If it is not -1, there is still data left in the file, so the loop continues.
* If read() returns -1, it means there are no more bytes to read,
* so the loop terminates.
*/


/*
═══════════════════════════════════════════════════════════════════════════════
📁 2. FileOutputStream
═══════════════════════════════════════════════════════════════════════════════

* FileOutputStream is used to write data into a file.
*
* If the specified file does not exist, Java automatically creates it.
*
* If a file with the same name already exists, Java DOES NOT create
* another file. Instead, it opens the existing file and overwrites
* its contents from the beginning.
*
* Example:
*
* First execution:
*     data.txt --> "Hello Java"
*
* Second execution (same code):
*     data.txt --> Still the same file.
*                  The previous content is replaced with the new content.
*
* If we want to keep the existing data and write new data at the end,
* we must open the stream in append mode:
*
*     FileOutputStream fos = new FileOutputStream("data.txt", true);
*/


/*
═══════════════════════════════════════════════════════════════════════════════
🔒 3. Why do we write finally, try-catch, and if (fis != null)?
═══════════════════════════════════════════════════════════════════════════════

finally {

    * finally always executes whether an exception occurs or not,
    * so it is the best place to close the file and release the resource.

    try {

        * We first check whether 'fis' is null because the FileInputStream
        * object may never have been created.
        *
        * Example:
        *
        *     fis = new FileInputStream("abc.txt");
        *
        * If "abc.txt" does not exist, the constructor throws a
        * FileNotFoundException before assigning the object to 'fis'.
        *
        * So 'fis' remains null.
        *
        * If we directly write:
        *
        *     fis.close();
        *
        * it is actually trying to execute:
        *
        *     null.close();
        *
        * which throws a NullPointerException.
        *
        * Therefore, we close the stream only if the object was
        * successfully created.

        if (fis != null) {

            * close() releases the file resource.
            *
            * We write it inside this try block because close() itself
            * can throw an IOException.
            *
            * Closing a stream is also an I/O operation, and while closing,
            * the operating system may fail to release the file resource,
            * the storage device may have an I/O error, or any other
            * file-system-related problem may occur.
            *
            * Since the method is declared as:
            *
            *     public void close() throws IOException
            *
            * Java forces us to either handle the exception using
            * try-catch or declare 'throws IOException'.

            fis.close();
        }
    }
}
*/