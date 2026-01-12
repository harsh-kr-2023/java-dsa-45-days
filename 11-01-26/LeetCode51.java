import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // index = column, value = row where queen is placed
        int[] queenRowAtColumn = new int[n];

        backtrack(0, n, queenRowAtColumn, result);
        return result;
    }

    // Try to place a queen in the given column
    private static void backtrack(int column,
            int n,
            int[] queenRowAtColumn,
            List<List<String>> result) {

        // All columns are filled → valid solution
        if (column == n) {
            result.add(buildBoard(queenRowAtColumn, n));
            return;
        }

        // Try every row in this column
        for (int row = 0; row < n; row++) {
            if (canPlace(row, column, queenRowAtColumn)) {
                queenRowAtColumn[column] = row; // place queen
                backtrack(column + 1, n, queenRowAtColumn, result);
                // no explicit removal needed (value will be overwritten)
            }
        }
    }

    // Check if placing a queen at (row, column) is safe
    private static boolean canPlace(int row,
            int column,
            int[] queenRowAtColumn) {

        // Check against all previously placed queens
        for (int prevColumn = 0; prevColumn < column; prevColumn++) {
            int prevRow = queenRowAtColumn[prevColumn];

            // Same row
            if (prevRow == row) {
                return false;
            }

            // Same diagonal
            if (Math.abs(prevRow - row) == Math.abs(prevColumn - column)) {
                return false;
            }
        }
        return true;
    }

    // Convert internal representation into board format
    private static List<String> buildBoard(int[] queenRowAtColumn, int n) {
        List<String> board = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            char[] line = new char[n];
            Arrays.fill(line, '.');

            for (int col = 0; col < n; col++) {
                if (queenRowAtColumn[col] == row) {
                    line[col] = 'Q';
                }
            }
            board.add(new String(line));
        }
        return board;
    }
}