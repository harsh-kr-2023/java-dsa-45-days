import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 9, 7, 8, 5};
        int k = 3;
        nearlySortedArray(arr, k);
        System.out.println(Arrays.toString(arr));
    }
    // Using Min Heap
    public static void nearlySortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k && i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
}
