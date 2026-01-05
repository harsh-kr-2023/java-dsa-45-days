public class LeetCode1975 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { -1, -2, -3 }, { 1, 2, 3 } };
        int result = maxMatrixSum(matrix);
        System.out.println(result);
    }

    // Brute Force - if negative elements is even, sum of absolute values of all
    // elements
    // if negative elements is odd, sum of absolute values of all elements - 2 *
    // smallest absolute value
    public static long maxMatrixSum(int[][] matrix) {
        int negativeCount = 0;
        long sum = 0;
        int minAbsValue = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    negativeCount++;
                }
                int absValue = Math.abs(num);
                sum += absValue;
                minAbsValue = Math.min(minAbsValue, absValue);
            }
        }
        if (negativeCount % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * minAbsValue;
        }
    }
}
