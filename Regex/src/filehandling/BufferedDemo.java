package filehandling;

import java.io.*;

public class BufferedDemo {
    static void main() throws IOException {
        
        File folder7 = new File("D:\\code\\java\\Regex\\src\\filehandling\\Buffered");
        if (!folder7.exists()) {
            folder7.mkdir();
        }
        else {
            System.out.println("Folder already exits");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\code\\java\\Regex\\src\\filehandling\\Buffered\\hello.txt"))) {
            bw.write("Line 1");
            bw.newLine();
            bw.write("Line 2");
        }

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\code\\java\\Regex\\src\\filehandling\\Buffered\\hello.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
/*
 * ============================================================================
 * 📖 BufferedReader & BufferedWriter
 * ============================================================================
 *
 * WHY do we use BufferedReader and BufferedWriter?
 *
 * FileReader and FileWriter directly read from and write to the file.
 * Every read() or write() operation may access the file on disk, which
 * is comparatively slow.
 *
 * BufferedReader and BufferedWriter maintain an internal buffer (memory).
 * They first read a large block of data into memory (or store data in memory
 * while writing) and then perform operations from the buffer instead of
 * accessing the file repeatedly.
 *
 * This reduces the number of disk accesses and makes reading and writing
 * much faster, especially for large files.
 *
 *
 * WHY do we write:
 *
 *     new BufferedReader(new FileReader("hello.txt"))
 *
 * instead of:
 *
 *     new BufferedReader("hello.txt")
 *
 * BufferedReader cannot open a file by itself.
 * It only adds buffering to another Reader.
 *
 * Its constructor is:
 *
 *     BufferedReader(Reader in)
 *
 * which means it expects a Reader object, not a file name.
 *
 * Therefore, we first create a FileReader, which is responsible for
 * opening the file and reading characters from it, and then pass that
 * FileReader object to BufferedReader so that it can read those
 * characters efficiently using a buffer.
 *
 *
 * WHAT does readLine() return?
 *
 * readLine() reads one complete line from the file and returns it
 * as a String.
 *
 * Example:
 *
 * File:
 *     Line 1
 *     Line 2
 *     Line 3
 *
 * Calls:
 *     readLine() -> "Line 1"
 *     readLine() -> "Line 2"
 *     readLine() -> "Line 3"
 *     readLine() -> null
 *
 * When there are no more lines left in the file,
 * readLine() returns null instead of throwing an exception.
 *
 * That's why we write:
 *
 *     while ((line = br.readLine()) != null)
 *
 * The loop continues as long as readLine() returns a valid line.
 * When it returns null (End Of File), the loop terminates.
 */

/*
 * FileReader  -> Reads characters from a file.
 * BufferedReader -> Reads characters using a buffer (faster) and also
 *                   provides readLine() to read an entire line.
 */