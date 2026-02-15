public class Q4 {
    public static void main(String[] args) {
        // int[] nums = { 3, 2, 1, 2, 3, 2, 1 };
        int[] nums = { 100,100 };
        System.out.println(longestAlternating(nums));
    }

    public static int longestAlternating(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (i == 1 || (nums[i] - nums[i - 1]) * (nums[i - 1] - nums[i - 2]) < 0) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 2;
            }
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i == n - 2 || (nums[i + 1] - nums[i]) * (nums[i + 2] - nums[i + 1]) < 0) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 2;
            }
        }

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, left[i]);
        }

        // Try removing each element
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxLen = Math.max(maxLen, right[1]);
            } else if (i == n - 1) {
                maxLen = Math.max(maxLen, left[n - 2]);
            } else {
                if (nums[i - 1] != nums[i + 1]) {
                    if (i == 1 || i == n - 2) {
                        maxLen = Math.max(maxLen, 2);
                    } else {
                        int leftVal = nums[i - 1];
                        int rightVal = nums[i + 1];
                        if ((nums[i - 1] - nums[i - 2]) * (rightVal - leftVal) < 0) {
                            maxLen = Math.max(maxLen, left[i - 1] + 1);
                        }
                        if ((rightVal - leftVal) * (nums[i + 2] - rightVal) < 0) {
                            maxLen = Math.max(maxLen, right[i + 1] + 1);
                        }
                        if ((nums[i - 1] - nums[i - 2]) * (rightVal - leftVal) < 0 &&
                                (rightVal - leftVal) * (nums[i + 2] - rightVal) < 0) {
                            maxLen = Math.max(maxLen, left[i - 1] + right[i + 1]);
                        }
                    }
                }
            }
        }

        return maxLen;
    }
}