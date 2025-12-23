import java.util.List;

public class Leetcode54 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5, 6 },
                { 20, 21, 22, 23, 24, 7 },
                { 19, 32, 33, 34, 25, 8 },
                { 18, 31, 36, 35, 26, 9 },
                { 17, 30, 29, 28, 27, 10 },
                { 16, 15, 14, 13, 12, 11 }
        };
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

    static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new java.util.ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = m - 1;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // Traverse from right to left along the bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Traverse from bottom to top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
