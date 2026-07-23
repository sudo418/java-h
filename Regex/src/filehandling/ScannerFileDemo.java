package filehandling;

import java.io.*;
import java.util.Scanner;

public class ScannerFileDemo {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(new File("D:\\code\\java\\Regex\\src\\filehandling\\Buffered\\hello.txt"))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
/*
 * ============================================================================
 * 📖 Why do we write: new Scanner(new File("notes.txt")) ?
 * ============================================================================
 *
 * Unlike BufferedReader, Scanner is capable of opening a file directly.
 * It provides a constructor that accepts a File object:
 *
 *      Scanner(File source)
 *
 * This means Scanner expects a File object, not just the file name.
 * Therefore, we first create a File object that represents the path
 * of the file and then pass that object to the Scanner constructor.
 *
 * Example:
 *
 *      new File("notes.txt")
 *
 * This DOES NOT open the file or read its contents.
 * It simply creates a File object in memory that represents the path
 * "notes.txt".
 *
 * Scanner then uses this File object to locate, open, and read
 * the contents of the file.
 *
 * Therefore, we write:
 *
 *      new Scanner(new File("notes.txt"))
 *
 * Step-by-step:
 *
 * Step 1:
 *      new File("notes.txt")
 *
 *      Creates a File object that represents the file path.
 *
 * Step 2:
 *      new Scanner(file)
 *
 *      Scanner receives the File object, opens the file,
 *      and becomes ready to read data from it.
 *
 *
 * WHY don't we write:
 *
 *      new Scanner("notes.txt")
 *
 * Because Scanner also has another constructor:
 *
 *      Scanner(String source)
 *
 * In this constructor, the String is NOT treated as a file name.
 * Instead, Scanner considers the String itself as the input data.
 *
 * Example:
 *
 *      Scanner sc = new Scanner("Hello World");
 *
 * Here, Scanner reads:
 *
 *      Hello
 *      World
 *
 * from the String itself, NOT from a file named "Hello World".
 *
 *
 * WHY don't we use FileReader here?
 *
 * BufferedReader cannot open a file by itself.
 * Its constructor is:
 *
 *      BufferedReader(Reader in)
 *
 * which means it requires a Reader object (such as FileReader).
 *
 * Therefore, we write:
 *
 *      new BufferedReader(new FileReader("notes.txt"))
 *
 * Scanner is different.
 * It already knows how to open a File because it has a constructor
 * that accepts a File object directly.
 *
 * So there is no need to create a FileReader separately.
 *
 *
 * Comparison:
 *
 * BufferedReader:
 *
 *      File
 *        │
 *        ▼
 *   FileReader
 *        │
 *        ▼
 * BufferedReader
 *
 * Scanner:
 *
 *      File
 *        │
 *        ▼
 *     Scanner
 */