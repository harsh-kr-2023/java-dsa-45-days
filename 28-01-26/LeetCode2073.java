import java.util.LinkedList;
import java.util.Queue;

public class LeetCode2073 {
    public static void main(String[] args) {
        int[] tickes = { 2, 3, 2 };
        int k = 2;
        System.out.println(timeRequiredToBuy(tickes, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        // Using Queue
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            queue.offer(new int[] { i, tickets[i] });
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int idx = curr[0];
            int remaining = curr[1];

            time++;
            remaining--;

            if (idx == k && remaining == 0) {
                return time;
            }

            if (remaining > 0) {
                queue.offer(new int[] { idx, remaining });
            }
        }
        return time;
    }
}
