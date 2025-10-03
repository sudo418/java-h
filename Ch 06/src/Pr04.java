import java.util.Scanner;

public class Pr04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matA, matB, matC;
        matA = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter matA [" + i + "][" + j + "] :");
                matA[i][j] = sc.nextInt();
            }
        }
        matB = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter matB [" + i + "][" + j + "] :");
                matB[i][j] = sc.nextInt();
            }
        }
        matC = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matC[i][j] = matA[i][j] + matB[i][j];
            }
        }

        System.out.println("Resultant Matrix (A + B): ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matC[i][j] + " ");
            }
            System.out.println();
        }
    }
}
