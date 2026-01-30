import java.util.*;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode950 {
    public static void main(String[] args) {
        int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
        int[] result = deckRevealedIncreasing(deck);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        for(int i = deck.length - 1; i >= 0; i--) {
            // rotate + add num in deque
            if(!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(deck[i]);
        }
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}