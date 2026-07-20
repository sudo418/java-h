package filehandling;

import java.io.*;

public class ByteStreamLimitation {
    static void main() throws IOException {

        // WRITING: 'é' is a single character to us, but in UTF-8 encoding
        // it is actually stored as 2 bytes: 0xC3 and 0xA9.
        // getBytes("UTF-8") explicitly converts the String to bytes using UTF-8 rules.
        // We specify "UTF-8" explicitly instead of just getBytes() because
        // getBytes() with no argument uses the platform's DEFAULT charset,
        // which can differ across machines and cause inconsistent bytes.
        try (FileOutputStream fos = new FileOutputStream("D:\\code\\java\\Regex\\src\\filehandling\\Byte\\cafe.txt")) {
            fos.write("café".getBytes("UTF-8"));
        }

        // READING: FileInputStream is a BYTE stream - it reads one raw byte
        // at a time and has ZERO understanding of character encoding.
        // It doesn't know that 0xC3 and 0xA9 together are supposed to
        // form ONE character (é). It just treats each byte as its own char.
        try (FileInputStream fis = new FileInputStream("D:\\code\\java\\Regex\\src\\filehandling\\Byte\\cafe.txt")) {
            int b;
            while((b = fis.read()) != -1) {
                // Casting each byte to (char) one at a time blindly splits
                // the 2-byte 'é' into two garbled characters instead of
                // combining them back into one.
                // Expected output: c a f é
                // Actual output:   c a f Ã ©   <-- WRONG, encoding got corrupted
                System.out.print((char) b + " ");
            }
        }

        /* FIX: Using FileReader/BufferedReader (character streams) instead
        of FileInputStream would solve this, because character streams
        understand encoding rules and correctly recombine multi-byte
        sequences into the right character.  */
    }
}