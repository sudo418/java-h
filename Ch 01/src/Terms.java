public class Terms {

    public static void main(String[] args) {
        /* 1) Declaration – Telling the compiler that a variable exists,
        along with its type and name, but no memory/value given yet  */
        int a;

        /* 2) Assignment – Giving (or changing) the value of an already declared
        variable using =. Can happen any number of times, not just the first time. */
        a = 20;

        /* 3) Initialization – Giving a variable its first value, usually done
        at the time of declaration.  */
        int a1 = 10;

        /* 4) Allocation – Reserving memory space for a variable/object so
        it has a location to store its value. Happens automatically for
        simple variables, and explicitly (using new) for arrays/objects. */
        int[] arr = new int[5];   // 'new' allocates memory for 5 int
    }
    /* 5)  Definition – Providing the actual implementation/body of a method —
    what the method does. (Used for methods, not variables.)  */
    void greet() {
        System.out.println("Hello");
    }
}
