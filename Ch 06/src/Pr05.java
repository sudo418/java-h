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
        for (int i = 0; i < n; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        System.out.println();
        System.out.println("Max is : " + max);

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
