import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int[][] towers = { {1, 2, 5}, {2, 1, 7}, {3, 1, 9} };
        int[] center = { 1, 1 };
        int radius = 2;
        int[] result = bestReachableTower(towers, center, radius);
        System.out.println(Arrays.toString(result));
    }

    public static int[] bestReachableTower(int[][] towers, int[] center, int radius) {
        int maxQuality = -1;
        int[] result = new int[] { -1, -1 };

        int cx = center[0];
        int cy = center[1];

        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            int q = tower[2];

            // Calculate Manhattan Distance
            int distance = Math.abs(x - cx) + Math.abs(y - cy);

            if (distance <= radius) {
                // Check if this tower is better than our current best
                if (q > maxQuality) {
                    maxQuality = q;
                    result[0] = x;
                    result[1] = y;
                } else if (q == maxQuality) {
                    // Lexicographical tie-break
                    if (x < result[0] || (x == result[0] && y < result[1])) {
                        result[0] = x;
                        result[1] = y;
                    }
                }
            }
        }

        return result;
    }
}