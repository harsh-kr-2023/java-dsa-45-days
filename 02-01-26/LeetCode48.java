public class LeetCode48 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // transpose the matrix and reverse each row
        for (int i = 0; i < row; i++) {
            for (int j = i; j < column; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // print the matrix
        System.out.println();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        // reverse each row
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][column - 1 - j];
                matrix[i][column - 1 - j] = temp;
            }
        }
    }
}