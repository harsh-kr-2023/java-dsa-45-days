import java.util.Arrays;
import java.util.Comparator;

public class LeetCode57 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int newInterval[] = { 9, 11 };
        int[][] merged = insert(intervals, newInterval);
        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] merged = new int[n + 1][2];

        int i = 0; // input pointer
        int index = 0; // output pointer

        // 1. intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged[index++] = intervals[i++];
        }

        // 2. merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged[index++] = newInterval;

        // 3. remaining intervals
        while (i < n) {
            merged[index++] = intervals[i++];
        }

        return Arrays.copyOf(merged, index);
    }
}