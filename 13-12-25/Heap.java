
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 6, 1, 2, 5, 10 };
        int k = 3;
        System.out.println(findKthLargest(arr, k));
        System.out.println(findKthSmallest(arr, k));
    }

    static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : arr) {
            minHeap.add(num);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    static int findKthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : arr) {
            maxHeap.add(num);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
