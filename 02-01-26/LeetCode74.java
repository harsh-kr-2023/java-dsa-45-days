public class LeetCode74 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 16;
        System.out.println(searchMatrix(matrix, target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        // first find the row then binary search for element
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = row * column - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = matrix[mid / column][mid % column];
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
