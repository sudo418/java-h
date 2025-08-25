public class Main {
    public static void main(String[] args) {

        System.out.println(66 < 5); // ans in true or false
        System.out.println(6 == 6);

        // arithmetic operator cannot work with booleans

        /* In Java, the modulo operator (%) can be used with float and double data types.

        C and C++:
        The % operator only works with integers.
        For floating-point numbers, you have to use fmod from the <cmath> library
        */

        /*
        associativity of = is right to left :-
        a = b = 6;
        so 6 will assign to b first and then to a
        */

        /*
        Increment and decrement operators will not work on booleans
        */

        char ch = 'a';
        System.out.println(++ch);
    }
}