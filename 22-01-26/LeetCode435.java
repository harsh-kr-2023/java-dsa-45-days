import java.util.Arrays;

public class LeetCode435 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 4 }, { 3, 5 }, { 6, 7 }, { 8, 9 }, { 9, 10 } };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
