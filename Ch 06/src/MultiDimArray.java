public class MultiDimArray {
    public static void main(String[] args) {

        int[][] marks = new int[][]{
                {11,22,33},
                {44,55,66}
        };

        for(int i = 0; i < marks.length; i++) {         // outer loop → rows
            for(int j = 0; j < marks[i].length; j++) {  // inner loop → columns
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] a = new int[2][3][5];  // meaning - 2 matrix of 3 X 5

        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    a[i][j][k] = i + j + k;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(a[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}