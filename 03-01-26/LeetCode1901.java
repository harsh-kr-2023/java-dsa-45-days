public class LeetCode1901 {
    public static void main(String[] args) {
        int[][] mat = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };
        int[] res = findPeakElement(mat);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
    static int[] findPeakElement(int[][] mat) {
        // brute  force - find element then check all four directions and if true then return else continue
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPeak(mat, i, j, rows, cols)) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
    static boolean isPeak(int[][] mat, int i, int j, int rows, int cols) {
        int val = mat[i][j];
        // up
        if (i - 1 >= 0 && mat[i - 1][j] >= val) {
            return false;
        }
        // down
        if (i + 1 < rows && mat[i + 1][j] >= val) {
            return false;
        }
        // left
        if (j - 1 >= 0 && mat[i][j - 1] >= val) {
            return false;
        }
        // right
        if (j + 1 < cols && mat[i][j + 1] >= val) {
            return false;
        }
        return true;
    }
}
