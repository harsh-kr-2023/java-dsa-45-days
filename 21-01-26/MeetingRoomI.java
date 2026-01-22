import java.util.Arrays;

public class MeetingRoomI {
    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        // int[] start = { 10, 12, 20 };
        // int[] end = { 20, 25, 30 };
        System.out.println(maxMeetings(start, end));
    }

    public static int maxMeetings(int[] start, int[] end) {
        // Greedy Approach
        int n = start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end_time = meetings[0][1];
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > end_time) {
                count++;
                end_time = meetings[i][1];
            }
        }
        return count;
    }
}
