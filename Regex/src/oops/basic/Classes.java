package oops.basic;

public class Classes {
    int id = 101;
    String name = "hello";
    String position;
    static int roll = 23;

    void printDetails() {
        System.out.println(id);
        System.out.println(name);
    }

    public static void main(String[] args) {
        System.out.println(new Classes().id);
        new Classes().printDetails();
        /*  Anonymous Object:
            An object created using 'new' without storing its reference in a variable.
            System.out.println(new Classes().id);
            -> Creates a new Classes object, directly accesses its 'id' field, and prints it.
            new Classes().printDetails();
            -> Creates ANOTHER new, separate Classes object, and calls printDetails() on it.
            Since no variable stores the reference, each 'new Classes()' call creates
            a different, independent object. The reference is temporary - it exists only
            long enough to access the field/method, then disappears right after that
            statement finishes executing, making the object eligible for garbage collection. */

        Classes e1 = new Classes();
        System.out.println(e1.id + " " + e1.name);

        /*  Static members are accessible directly in a static area (like main());
            non-static members always need an object to be accessed.  */

        // ways to access static variable :-
        // 1) Direct access :-
        System.out.println(roll);

        // 2) Using class name :-
        System.out.println(Classes.roll);

        // 3) Using the object :-
        Classes e2 = new Classes();
        System.out.println(e2.roll);

        e2.roll = 101;
        e2.position = "Boss";

        System.out.println(e2.roll + " " + e2.position);
    }
}
