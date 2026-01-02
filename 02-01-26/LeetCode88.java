public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        // now copy back in nums1
        while (i < m) {
            temp[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            temp[k] = nums2[j];
            j++;
            k++;
        }
        for (int l = 0; l < m + n; l++) {
            nums1[l] = temp[l];
        }
    }
}