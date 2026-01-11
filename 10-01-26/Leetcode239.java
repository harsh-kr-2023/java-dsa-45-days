public class Leetcode239 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int left = 0, right = k - 1;

        while (right < n) {
            int[] window = new int[k];
            for (int i = 0; i < k; i++) {
                window[i] = nums[left + i];
            }
            res[left] = helper(window, k);
            left++;
            right++;
        }
        return res;
    }

    public static int helper(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    // optimized solution
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        // first window
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        res[0] = max;

        // Slide window
        for (int i = k; i < n; i++) {
            int left = i - k + 1;

            if (maxIndex < left) {
                max = nums[left];
                maxIndex = left;
                for (int j = left + 1; j <= i; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            } else if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            res[left] = max;
        }
        return res;
    }

}
