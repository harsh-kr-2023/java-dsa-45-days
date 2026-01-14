import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] mazeGrid = { 
            { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 1, 1, 0, 0 },
            { 0, 1, 1, 1 } 
        };
        
        ArrayList<String> allPaths = findAllPaths(mazeGrid);
        System.out.println("All possible paths: " + allPaths);
    }

    static ArrayList<String> findAllPaths(int[][] mazeGrid) {
        int mazeSize = mazeGrid.length;
        ArrayList<String> allPaths = new ArrayList<>();
        
        if (mazeGrid == null || mazeSize <= 0 || mazeGrid[0][0] == 0 || mazeGrid[mazeSize-1][mazeSize-1] == 0) {
            return allPaths;
        }
        
        boolean[][] visitedCells = new boolean[mazeSize][mazeSize];
        explorePaths(mazeGrid, 0, 0, visitedCells, "", allPaths);
        return allPaths;
    }

    private static boolean isValidMove(int[][] mazeGrid, int row, int column) {
        int totalRows = mazeGrid.length;
        int totalColumns = mazeGrid[0].length;
        
        if (row < 0 || row >= totalRows || column < 0 || column >= totalColumns) {
            return false;
        }
        
        return mazeGrid[row][column] == 1;
    }

    private static void explorePaths(int[][] mazeGrid, int currentRow, int currentColumn, 
                                     boolean[][] visitedCells, String currentPath, 
                                     ArrayList<String> allPaths) {
        
        int totalRows = mazeGrid.length;
        int totalColumns = mazeGrid[0].length;
        
        // Check if we reached the destination (bottom-right corner)
        if (currentRow == totalRows - 1 && currentColumn == totalColumns - 1) {
            allPaths.add(currentPath);
            return;
        }
        
        // Mark current cell as visited
        visitedCells[currentRow][currentColumn] = true;
        
        // Try moving in all four directions in specific order (for lexicographical order)
        
        // Move Down
        int nextRowDown = currentRow + 1;
        int nextColumnDown = currentColumn;
        if (isValidMove(mazeGrid, nextRowDown, nextColumnDown) && !visitedCells[nextRowDown][nextColumnDown]) {
            explorePaths(mazeGrid, nextRowDown, nextColumnDown, visitedCells, currentPath + "D", allPaths);
        }
        
        // Move Right
        int nextRowRight = currentRow;
        int nextColumnRight = currentColumn + 1;
        if (isValidMove(mazeGrid, nextRowRight, nextColumnRight) && !visitedCells[nextRowRight][nextColumnRight]) {
            explorePaths(mazeGrid, nextRowRight, nextColumnRight, visitedCells, currentPath + "R", allPaths);
        }
        
        // Move Up
        int nextRowUp = currentRow - 1;
        int nextColumnUp = currentColumn;
        if (isValidMove(mazeGrid, nextRowUp, nextColumnUp) && !visitedCells[nextRowUp][nextColumnUp]) {
            explorePaths(mazeGrid, nextRowUp, nextColumnUp, visitedCells, currentPath + "U", allPaths);
        }
        
        // Move Left
        int nextRowLeft = currentRow;
        int nextColumnLeft = currentColumn - 1;
        if (isValidMove(mazeGrid, nextRowLeft, nextColumnLeft) && !visitedCells[nextRowLeft][nextColumnLeft]) {
            explorePaths(mazeGrid, nextRowLeft, nextColumnLeft, visitedCells, currentPath + "L", allPaths);
        }
        
        // Backtrack: mark current cell as unvisited for other paths
        visitedCells[currentRow][currentColumn] = false;
    }
}