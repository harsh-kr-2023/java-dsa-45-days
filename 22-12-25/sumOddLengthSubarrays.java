public class sumOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 5, 3 };
        int result = sumOddLengthSubarray(arr);
        System.out.println("Sum of all odd-length subarrays: " + result);
    }

    static int sumOddLengthSubarray(int[] arr) {
        int sum = 0;
        int n = arr.length;
        // brute force approach
        int length = 1;
        while (length <= n) {
            for (int start = 0; start <= n - length; start++) {
                for (int k = start; k < start + length; k++) {
                    sum += arr[k];
                }
            }
            length += 2;
        }
        return sum;
    }
}