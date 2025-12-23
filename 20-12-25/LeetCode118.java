
import java.util.List;

public class LeetCode118 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(generate(n));
    }
    static List<List<Integer>> generate(int n) {
        List<List<Integer>> triangle = new java.util.ArrayList<>();
        for (int row = 0; row < n; row++) {
            List<Integer> currentRow = new java.util.ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    int leftParent = triangle.get(row - 1).get(col - 1);
                    int rightParent = triangle.get(row - 1).get(col);
                    currentRow.add(leftParent + rightParent);
                }
            }
            triangle.add(currentRow);
        }
        return triangle;
    }
}
