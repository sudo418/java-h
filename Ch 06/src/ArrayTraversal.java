public class ArrayTraversal {
    public static void main(String[] args) {

        int[] marks = {3,4,5,6,7};
        float[] marks1 = {4,5,6,7};
        String[] students = {"hello", "world"};

        System.out.println(marks.length);
        System.out.println(marks[1]);
        System.out.println(marks1[1]);
        System.out.println(students[1]);

        System.out.println("Printing array using for loop");
        for(int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
        }

        // Enhanced for loop or for-each loop :-
        for (int mark : marks) {
            System.out.println(mark);
        }
        /* for (type variable : arrayOrCollection)
        type → data type of elements in the array/collection.
        variable → a temporary variable that stores the current element during iteration.
        arrayOrCollection → the array or collection you want to loop through.  */

        System.out.println("Printing array using for loop in reverse order");
        for(int i = marks.length - 1; i >= 0; i--) {
            System.out.println(marks[i]);
        }
    }
}
