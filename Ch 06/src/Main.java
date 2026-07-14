public class Main {
    public static void main(String[] args) {

        // Declaration of array :-
        int a[];
        int[] a1;
        /* these two things above they only declares a reference variable a.
        Right now, it doesn’t point to any array. */

        // Allocation of memory in array :-
        a = new int[5];
        /*  This creates a new int array object in the heap with 5 elements.
        All elements are initialized to 0 (default value for int).
        'a' now points (references) this array. */

        /*  now if we initialize 'a' after memory allocation like this
        a = {1,2,34,5}  --> this is invalid cuz the Array initializer only works at the
        time of declaration.
        However, the whole array can still be reassigned at once using new int[]{...}
        (e.g., a = new int[]{1,2,3,4,5};), which creates a brand-new array object in the
        heap and makes a point to it. */

        // memory allocation + initialization + assignment.
        a1 = new int[]{1,2,3,4}; // creates a new array with values [1, 2, 3, 4]

        // declaration + memory allocation + initialization + assignment.
        int[] c = new int[]{1,2,3,4};  // line 6 + line 23


        // both are correct but with different syntax
        int[] marks = new int[5];   // mostly java developer use this. Preferred in modern Java
        int marks1[] = new int[5];  // This style comes from C/C++.


        // Example with multiple variables:
        int[] marks2, age; /* Here both marks2 and age are
        declared as arrays */

        int marks3[], age1; /* Here only marks3 is an array age1
        is just an int */


        // Declaration , initialization all at the same time :-
        int b[] = {1,2,3,4};
        /*  int b[4] = {1,2,3,4}; --> invalid in java.
        In Java, you cannot specify the array size inside the brackets
        when initializing with {...}. The compiler automatically figures
        out the size from the number of elements you provide.
        This syntax is valid in C or C++, but not in java */


        /*  Difference between
        int[] b = {1, 2, 3, 4};
        → Bare initializer shortcut — compiler internally treats it as new int[]{1,2,3,4}
        → This bare {} form is ONLY allowed at declaration time
        → Invalid later: b = {5, 6, 7, 8};
        → But valid later: b = new int[]{5, 6, 7, 8};   ✅ (b CAN be reassigned, just not with bare {})

        int[] c = new int[]{1, 2, 3, 4};
        → Full form (works at declaration or later).
        → Same array creation, but explicitly written with 'new'
        → Valid later: c = new int[]{5, 6, 7, 8};
        */
    }
}