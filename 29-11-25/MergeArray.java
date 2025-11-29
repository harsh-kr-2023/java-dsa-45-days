public class MergeArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6}; 
        int n = 3;
        merge(nums1,m,nums2,n);
        printArray(nums1);
    }
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Three pointers approach
        int i = m - 1;      // Last element of nums1's initial data
        int j = n - 1;      // Last element of nums2
        int k = m + n - 1;  // Last position of nums1
        
        // Merge from the end to avoid overwriting
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}