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
        Queue<Integer> queue = new LinkedList<>();
        for (int ticket : tickets) {
            queue.offer(ticket);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int currentTicket = queue.poll();
            System.out.println(currentTicket);
            time++;
            if (currentTicket > 1) {
                queue.offer(currentTicket - 1);
            }
            if (queue.isEmpty()) {
                break;
            }
        }
        return time - 1;
    }
}
