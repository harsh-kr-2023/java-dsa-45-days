import java.util.Arrays;
import java.util.Comparator;

public class LeetCode56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);
        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] merged = new int[intervals.length][2];
        int index = 0;
        for (int[] interval : intervals) {
            if (index == 0 || merged[index - 1][1] < interval[0]) {
                merged[index++] = interval;
            } else {
                merged[index - 1][1] = Math.max(merged[index - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(merged, index);
    }
}