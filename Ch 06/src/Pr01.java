import java.util.Scanner;

public class Pr01 {
    public static void main(String[] args) {

        // q1
        float[] arr = new float[]{2.3f, 4.5f, 6.7f};
        float sum = 0.0f;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }
        System.out.println();
        System.out.printf("sum = %.2f\n", sum);

        // q2
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the int: ");
        int a = sc.nextInt();
        int[] arr1 = {1, 2, 3, 4, 5};
        boolean t = false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == a) {
                t = true;
            }
        }
        if (t == true) System.out.println("found");
        else System.out.println("not found");

        // q3
        int[] b = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the marks of student " + (i + 1));
            b[i] = sc.nextInt();
        }

        int sum1 = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print(b[i] + " ");
            sum1 += b[i];
        }
        System.out.println();
        System.out.println(sum1);
        float avg = sum1/3.0f;
        System.out.println(avg);
    }
}

