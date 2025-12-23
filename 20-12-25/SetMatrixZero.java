public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 }
        };
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Brute force approach using additional space
    // static void setZeroes(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == 0) {
    //                 markRow(matrix, i);
    //                 markColumn(matrix, j);
    //             }
    //         }
    //     }
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == -1) {
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }

    // static void markRow(int[][] matrix, int row) {
    //     for (int j = 0; j < matrix[0].length; j++) {
    //         if (matrix[row][j] != 0) {
    //             matrix[row][j] = -1; // Marking with -1 to avoid confusion with original zeros
    //         }
    //     }
    // }

    // static void markColumn(int[][] matrix, int col) {
    //     for (int[] matrix1 : matrix) {
    //         if (matrix1[col] != 0) {
    //             matrix1[col] = -1; // Marking with -1 to avoid confusion with original zeros
    //         }
    //     }
    // }

    // Better approach using additional space
    // static void setZeroes(int[][] matrix) {
    //     int[] row = new int[matrix.length];
    //     int[] col = new int[matrix[0].length];
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             if (matrix[i][j] == 0) {
    //                 row[i] = 1;
    //                 col[j] = 1;
    //             }
    //         }
    //     }
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             if (row[i] == 1 || col[j] == 1) {
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }

    // Optimal approach using constant space
    static void setZeroes(int[][] matrix) {
        
    }

}