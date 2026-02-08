// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM:
// - 
//
// INPUT:
// - 
//
// OUTPUT:
// - 
//
// ASSUMPTIONS:
// - 
//
// -------------------------------------
// BRUTE FORCE:
// - Idea:
// - Time:
// - Space:
// - Why not optimal?
//
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique:
// - Idea:
// - Why it works:
// - Invariant: After processing the first i elements, <state> correctly represents <meaning for processed portion>.
//
// -------------------------------------
// EDGE CASES:
// - Boundary condition where input size or value is at its minimum or maximum
// - Case where assumptions are barely satisfied (e.g., smallest valid input)
// - Case that could break logic if not handled explicitly
//
// -------------------------------------
// FINAL COMPLEXITY:
// - Time:
// - Space:
//
// -------------------------------------
// FAILURE MODES:
// - This approach assumes <key assumption>.
// - It fails or becomes invalid if <assumption is violated>.
// =====================================
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {'5','3','.','.','7','.','.','.','.'
        ,'6','.','.','1','9','5','.','.'
        ,'.','9','8','.','.','.','.','6','.'
        ,'8','.','.','.','6','.','.','.','3'
        ,'4','.','.','8','.','3','.','.','1'
        ,'7','.','.','.','2','.','.','.','6'
        ,'.','6','.','.','.','.','2','8','.'
        ,'.','.','.','4','1','9','.','.','5'
        ,'.','.','.','.','8','.','.','7','9'};
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        char val = board[row][col];
        // check row
        for (int i = 0; i < n; i++) {
            if (i != col && board[row][i] == val) {
                return false;
            }
        }
        // check column
        for (int i = 0; i < n; i++) {
            if (i != row && board[i][col] == val) {
                return false;
            }
        }
        // check 3x3 box
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (i != row && j != col && board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }   
}
