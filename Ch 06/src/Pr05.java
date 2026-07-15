import java.util.Scanner;

public class Pr05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the %d element of array : ", i+1);
            arr[i] = sc.nextInt();
        }

        int n1 = Math.floorDiv(arr.length, 2);   // Math.floorDiv do the greatest integer function (GIF)
        /*  Math.floorDiv(a, b) performs division between two integers and returns the result
            rounded down (floored) toward negative infinity — unlike normal / division, which
            just truncates (cuts off) the decimal part toward zero.
            The difference only shows up with negative numbers:
            System.out.println(7 / 2);                 // 3
            System.out.println(Math.floorDiv(7, 2));   // 3   (same for positive numbers)

            System.out.println(-7 / 2);                // -3   (truncates toward zero)
            System.out.println(Math.floorDiv(-7, 2));  // -4   (floors toward negative infinity)  */
        int l = arr.length;
        for (int i = 0; i < n1; i++) {
            int temp = arr[i];
            arr[i] = arr[l - 1 - i];
            arr[l - i - 1] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // q6
        int max = arr[0];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                pos = i;
            }
        }
        System.out.println();
        System.out.println("Max is : " + max + " which is on position : " + pos);

        // q7 doing it with different method :-
        int min = Integer.MAX_VALUE;
        for(int element: arr) {
            if (element < min) {
                min = element;
            }
        }
        System.out.println("min is : " + min);
    }
}
