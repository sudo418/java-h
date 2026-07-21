package filehandling;

import java.io.*;

public class CharStream {
    static void main()throws IOException{

        File folder6 = new File("D:\\code\\java\\Regex\\src\\filehandling\\Char");
        if (!folder6.exists()) {
            folder6.mkdir();
        }
        else System.out.println("folder 6 already exists");

        try (FileWriter fw = new FileWriter("D:\\code\\java\\Regex\\src\\filehandling\\Char\\hello.txt")) {
            fw.write("Hello World, this is in char folder");
            fw.write("\n");
            fw.write("hello again");
            //fw.flush; fw.close;       --> don't need to write see comment below
        }

        try (FileReader fr = new FileReader("D:\\code\\java\\Regex\\src\\filehandling\\Char\\hello.txt")) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            /*  ANOTHER WAY OF WRITING THIS BLOCK
            int ch = fr.read();
            while(ch != -1){
                System.out.print((char)ch);
                ch = fr.read();
            }    */

            /*  ONE MORE WAY
            int ch;
            while(ch != -1) {
                ch = fr.read();
                System.out.print((char)ch);
            }   */
        }

        System.out.println();

        try (FileWriter fw2 = new FileWriter("D:\\code\\java\\Regex\\src\\filehandling\\Char\\cafe.txt")) {
            fw2.write("café");
        }

        try (FileReader fr2 = new FileReader("D:\\code\\java\\Regex\\src\\filehandling\\Char\\cafe.txt")) {
            int ch2;
            while((ch2 = fr2.read()) != -1) {
                System.out.print((char) ch2 + " ");
            }
        }

        System.out.println();

        // append
        try (FileWriter fw3 = new FileWriter("D:\\code\\java\\Regex\\src\\filehandling\\Char\\hello.txt", true)) {
            fw3.write(" --> And i wrote this message by appending the file");
            System.out.println("data is appended");
        }

        try (FileReader fr3 = new FileReader("D:\\code\\java\\Regex\\src\\filehandling\\Char\\hello.txt")) {
            int ch2;
            while ((ch2 = fr3.read()) != -1) {
                System.out.print((char) ch2);
            }
        }
    }
}
/*
 * try-with-resources:
 * - The object is created inside the parentheses of the try statement.
 * - It is automatically closed when the try block finishes, even if an
 *   exception occurs.
 * - Since close() is called automatically, we do not need to call it manually.
 *
 * flush():
 * - flush() writes any buffered data to the file but keeps the stream open.
 * - It is used when you want the data to be saved immediately and continue
 *   writing to the same stream.
 * - close() automatically calls flush() before releasing the resource.
 * - Therefore, when using try-with-resources, there is usually no need to
 *   call flush() explicitly unless you need the data written before the
 *   stream is closed.
 */

/*
 * We use an int instead of a char because FileReader.read()
 * is declared as:
 *
 *     public int read() throws IOException
 *
 * It returns two types of values:
 * • The Unicode value of a valid character.
 * • -1 when the end of the file is reached.
 *
 * If Java returned a char, it could return the character,
 * but it could not return -1 because a char cannot store -1.
 *
 * That's why read() returns an int. It can store both the
 * Unicode value of the character and the special value -1.
 *
 * After reading, we cast the int to char while printing
 * so that the actual character is displayed instead of
 * its Unicode value.
 */