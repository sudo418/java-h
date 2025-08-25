public class ArrayTraversal {
    public static void main(String[] args) {

        int[] marks ={3,4,5,6,7};

        System.out.println(marks.length);
        System.out.println(marks[1]);

        System.out.println("Printing array using for loop");
        for(int i = 0; i < marks.length; i++)
        {
            System.out.println(marks[i]);
        }

        // Enhanced for loop or for-each loop :-
        for (int mark : marks) {
            System.out.println(mark);
        }

        System.out.println("Printing array using for loop in reverse order");
        for(int i = marks.length - 1; i >= 0; i--)
        {
            System.out.println(marks[i]);
        }
    }
}
