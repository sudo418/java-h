// method is a function inside a class. Java is an object-oriented programming so all functions are methods.
// you can call static method using static method directly.

public class Main {

    static int add(int x, int y)    // --> these are parameters
    {
        int z = x + y;
        return z;
    }

    int sub(int x, int y)
    {
        int z = x - y;
        return z;
    }

    // In Java, parameters are optional for methods. For example :-
    static void hello()
    {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {

        int a = 5;
        int b = 6;
        int c = add(a, b);
        // these are arguments. Trick to remember :- arguments are actual

        // Method invocation using object creation
        Main obj = new Main();
        int d = obj.sub(a, b);

        System.out.println(c);
        System.out.println(d);
        hello();
    }
}