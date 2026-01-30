import java.util.Queue;
import java.util.LinkedList;

public class LeetCode1823 {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        int result = findTheWinner(n, k);
        System.out.println(result);
    }
    public static int findTheWinner(int n, int k) {
        // Using Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }
}
