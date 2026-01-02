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
        int start = 0;
        int end = row;
        while (start < end) {
            int mid = start + (end - start) / 2;
 
    }
}
