import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class LeetCode387 {
    public static void main(String[] args) {
        String s = "leetcode";
        int result = firstUniqChar(s);
        System.out.println(result);
    }
    public static int firstUniqChar(String s) {
        // Using Queue
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            queue.offer(c);
            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
                queue.poll();
            }
        }
        return queue.isEmpty() ? -1 : s.indexOf(queue.peek());
    }
}
