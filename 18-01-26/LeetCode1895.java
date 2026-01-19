public class LeetCode1895 {
    public static void main(String[] args) {
        int[][] grid = { { 7, 1, 4, 5, 6 }, { 2, 5, 1, 6, 4 }, { 1, 5, 4, 3, 2 }, { 1, 2, 7, 3, 4 } };
        System.out.println(largestMagicSquare(grid));
    }

    // Brute Force Approach
    public static int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; k <= Math.min(m - i, n - j); k++) {
                    if (isMagicSquare(grid, i, j, k)) {
                        max = Math.max(max, k);
                    }
                }
            }
        }

        return max;
    }

    public static boolean isMagicSquare(int[][] grid, int i, int j, int k) {
        // print grid
        // for (int l = i; l < i + k; l++) {
        //     for (int p = j; p < j + k; p++) {
        //         System.out.print(grid[l][p] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        // Calculate sum of first row and compare
        for (int p = j; p < j + k; p++) {
            sum += grid[i][p];
        }
        // row
        for (int l = i + 1; l < i + k; l++) {
            int rowSum = 0;
            for (int p = j; p < j + k; p++) {
                rowSum += grid[l][p];
            }
            if (rowSum != sum) {
                return false;
            }
        }
        // column
        for (int p = j; p < j + k; p++) {
            int colSum = 0;
            for (int l = i; l < i + k; l++) {
                colSum += grid[l][p];
            }
            if (colSum != sum) {
                return false;
            }
        }
        // diagonal
        int diagSum = 0;
        for (int l = i, p = j; l < i + k; l++, p++) {
            diagSum += grid[l][p];
        }
        if (diagSum != sum) {
            return false;
        }
        diagSum = 0;
        for (int l = i, p = j + k - 1; l < i + k; l++, p--) {
            diagSum += grid[l][p];
        }
        if (diagSum != sum) {
            return false;
        }
        return true;
    }
}
