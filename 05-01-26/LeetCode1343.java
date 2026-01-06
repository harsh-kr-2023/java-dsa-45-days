public class LeetCode1343 {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
        int k = 3;
        int threshold = 4;
        int result = numOfSubarrays(arr, k, threshold);
        System.out.println(result);
    }
    static int numOfSubarrays(int[] arr, int k, int threshold) {
        // sliding window approach
        int n = arr.length;
        int count = 0;
        int windowSum = 0;
        int low = 0;
        int high = k - 1;
        // calculate the average of the first window and check if it meets the threshold then increment count
        for (int i = low; i <= high; i++) {
            windowSum += arr[i];
        }
        if (windowSum / k >= threshold) {
            count++;
        }
        // slide the window from start to end of the array
        while (high < n - 1) {
            windowSum -= arr[low];
            windowSum += arr[high + 1];
            if (windowSum / k >= threshold) {
                count++;
            }
            low++;
            high++;
        }
        return count;
    }
}
