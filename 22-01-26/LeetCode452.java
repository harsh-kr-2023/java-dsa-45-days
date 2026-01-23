public class LeetCode452 {
    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // Sort the points based on the end coordinate of each balloon and count intervals
        java.util.Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
