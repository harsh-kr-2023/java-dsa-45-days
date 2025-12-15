import java.util.Collections;
import java.util.PriorityQueue;

public class Problem1 {

    static int findKLargestSum(int[] arr, int k) {
        if (k > arr.length) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int sum = 0;
        for (int x : minHeap) sum += x;
        return sum;
    }

    static int findKSmallestSum(int[] arr, int k) {
        if (k > arr.length) return 0;

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int sum = 0;
        for (int x : maxHeap) sum += x;
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 1, 2, 5, 10};
        int k = 3;

        int result = Math.abs(
            findKLargestSum(arr, k) - findKSmallestSum(arr, k)
        );

        System.out.println(result);
    }
}
