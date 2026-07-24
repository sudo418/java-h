package filehandling;

import java.io.File;
import java.io.IOException;

public class FolderCreation {
    static void main() {

        // ------------------------------------------------------
        // Basic mkdir() -- creates a single folder named "folder 1"
        // in the current working directory.
        // ------------------------------------------------------
        File folder = new File("folder 1");
        folder.mkdir();

        // ------------------------------------------------------
        // mkdir() using a FULL ABSOLUTE PATH instead of just a
        // name. Works fine as long as the immediate parent folder
        // (filehandling) already exists on disk.
        // Return value IS captured this time, so we know for sure
        // whether it succeeded.
        // ------------------------------------------------------
        File folder2 = new File("D:\\code\\java\\Regex\\src\\filehandling\\Byte");
        boolean created = folder2.mkdir();

        if (created) {
            System.out.println("folder is created");
        }
        else {
            System.out.println("folder is not created");
        }

        // ------------------------------------------------------
        // mkdir() with a NESTED path ("Parent/child") where the
        // parent folder "Parent" does NOT exist yet.
        // mkdir() only creates ONE folder at a time and requires
        // the immediate parent to already exist -- since "Parent"
        // is missing, this call FAILS SILENTLY (returns false,
        // no exception, nothing gets created).
        // ------------------------------------------------------
        File folder3 = new File("Parent/child");
        folder3.mkdir();    // nothing happened

        // ------------------------------------------------------
        // mkdirs() (note the extra "s") on the SAME nested path.
        // Unlike mkdir(), this creates the ENTIRE missing chain
        // of folders -- so it builds "Parent" AND "child" inside
        // it, both in one call, regardless of what's missing.
        // ------------------------------------------------------
        File folder4 = new File("Parent/child");
        folder4.mkdirs();

        // ------------------------------------------------------
        // Safer pattern: check exists() BEFORE calling mkdir().
        // "folder 1" already exists from the very first line
        // above, so this will skip creation entirely and print
        // a clear, specific message instead of silently doing
        // nothing (like plain mkdir() would).
        // ------------------------------------------------------
        File folder5 = new File("folder 1");
        if (!folder5.exists()) {
            folder5.mkdir();    // return value ignored -- see [UNCHECKED-RESULT] note below
        }
        else System.out.println("folder already exists");

        // file
        File file = new File("myfile.txt");
        try {
            boolean fileStatus = file.createNewFile();     // throws IOException
            System.out.println(fileStatus);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
/*
 * ============================================================================
 * 📁 File Class - Creating Files & Folders
 * ============================================================================
 *
 * IMPORTANT CONCEPT:
 * The File class can represent and create BOTH files AND folders/directories.
 * It is NOT limited to just folders.
 *
 * • To create a FILE
 *      -> file.createNewFile()
 *
 * • To create a FOLDER
 *      -> file.mkdir()   (single folder)
 *      -> file.mkdirs()  (nested folders, e.g. a/b/c)
 *
 * The File class itself doesn't "know" in advance whether the path
 * you give it will become a file or a folder - that depends on
 * WHICH method you call on it (createNewFile() vs mkdir()).
 *
 *
 * Step 1: Create a File OBJECT
 * ---------------------------------
 *
 *     File file = new File("myfile.txt");
 *
 * This is NOT the actual file on disk yet.
 * This just creates a Java object in memory that REPRESENTS a path.
 * Think of it like writing down an address on paper - the address
 * exists, but no house has been built there yet.
 *
 *
 * Step 2: Create the Actual File
 * ---------------------------------
 *
 *     boolean fileStatus = file.createNewFile();
 *
 * This actually creates the physical file on disk.
 * This is the line that talks to the Operating System.
 *
 * createNewFile() returns a boolean:
 *
 * • true
 *      -> file did NOT exist before, and was successfully created now
 *
 * • false
 *      -> file ALREADY existed, so nothing new was created
 *
 *
 * WHY does createNewFile() throw IOException?
 * -------------------------------------------
 *
 * Because file creation can fail due to reasons outside our control:
 *
 * • Permission denied
 * • Disk error / Disk full
 * • Invalid path
 */

/*
 * DIFFERENCE: mkdir()+return-value check(Line 26) vs  exists()+if-else(Line 61)
 * ------------------------------------------------------------
 * Approach 1 (folder2): check the RETURN VALUE
 * of mkdir() AFTER trying.
 *     boolean created = folder.mkdir();
 *     if (created) { ... } else { ... }
 *
 *   - Logic: "Just try to create it. Then look at what happened."
 *   - mkdir() is called UNCONDITIONALLY every time, whether or
 *     not the folder already exists.
 *   - The else/failure message is AMBIGUOUS -- "not created"
 *     could mean it already existed, OR something else went
 *     wrong (missing parent, permission denied, etc.). Can't
 *     tell which just from false.
 *
 * Approach 2 (folder5): check exists() BEFORE trying.
 *     if (!folder5.exists()) { folder5.mkdir(); }
 *     else System.out.println("folder already exists");
 *
 *   - Logic: "Check first. Only try to create it if needed."
 *   - mkdir() is only called WHEN NEEDED -- skipped entirely if
 *     the folder is already there.
 *   - The else message is PRECISE -- tells you exactly WHY
 *     nothing was created ("already exists"), instead of a
 *     vague failure.
 *   - Costs one extra exists() check every time.
 *   - [UNCHECKED-RESULT] mkdir() is called but its result is NOT checked here,
 *     so you're just ASSUMING it worked. It might still fail
 *     (e.g. permission issue), and you'd never know -- the code
 *     just moves on like nothing went wrong.
 *
 * SIMPLE RULE: Approach 1 tells you IF it worked, not why it
 * didn't. Approach 2 tells you WHY you're skipping, but takes
 * one extra step.
 */