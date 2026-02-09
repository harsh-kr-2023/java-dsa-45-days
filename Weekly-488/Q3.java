import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2 };
        int k = 4;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, long k) {
        // int n = nums.length;
        // long count = 0;

        // for (int l = 0; l < n; l++) {
        //     int min = nums[l];
        //     int max = nums[l];

        //     for (int r = l; r < n; r++) {
        //         min = Math.min(min, nums[r]);
        //         max = Math.max(max, nums[r]);
        //         long cost = (long) (max - min) * (r - l + 1);

        //         if (cost <= k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int l = 0;
        long ans = 0;

        for (int r = 0; r < nums.length; r++) {

            while (!maxD.isEmpty() && maxD.peekLast() < nums[r]) {
                maxD.pollLast();
            }
            maxD.addLast(nums[r]);

            while (!minD.isEmpty() && minD.peekLast() > nums[r]) {
                minD.pollLast();
            }
            minD.addLast(nums[r]);

            while ((long)(maxD.peekFirst() - minD.peekFirst()) * (r - l + 1) > k) {
                if (nums[l] == maxD.peekFirst()) maxD.pollFirst();
                if (nums[l] == minD.peekFirst()) minD.pollFirst();
                l++;
            }

            ans += (r - l + 1);
        }

        return ans;
    }
}