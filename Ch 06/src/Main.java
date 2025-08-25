public class Main {
    public static void main(String[] args) {

        // Declaration of array :-
        int a[];

        // Allocation of memory in array :-
        a = new int[5];
        // a = new int[5]{1,2,3,4};  --> This is wrong
        a = new int[]{1,2,3,4}; // creates a new array with values [1, 2, 3, 4]

        /* a = {1,2,34,5}  --> this is invalid Once the array is created
        (with new), you must assign values one by one.
        {...} initializer works only at declaration. */

        // both are correct but with different syntax
        int[] marks = new int[5]; // mostly java developer use this. Preferred in modern Java
        int marks1[] = new int[5];


        // Example with multiple variables:
        int[] marks2, age; /* Here both marks2 and age are
        declared as arrays */

        int marks3[], age1; /* Here only marks3 is an array
        age1 is just an int */


        // Declaration , memory allocation, initialization all at same time :-
        int b[] = {1,2,3,4};
        // int b[4] = {1,2,3,4}; --> invalid in java
        /* In Java, you cannot specify the array size inside the brackets
        when initializing with {...}. The compiler automatically figures
        out the size from the number of elements you provide.
        This syntax is valid in C or C++, but not i */


        // With new and initializer -->
        int[] c = new int[]{1,2,3,4};
        /* int[] c = new int[5]{1,2,3,4};  --> not valid. If you want to
        use initializer with new u cannot specify the array size. */

        /* Summary :-
        * In short when we use new int[5] then we have to assign values
        one by one
        * If we use new int[] without specifying the size then we can use
        initializer.
        * If we declare an array and later use int[] and then
        initializer{...} then it creates new array with new values
        */
    }
}