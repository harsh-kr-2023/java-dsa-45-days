public class LeetCode1539 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    static int findKthPositive(int[] arr, int k) {
        int current = 1;
        int i = 0;
        int missingCount = 0;

        while (missingCount < k) {
            if (i < arr.length && arr[i] == current) {
                i++;
            } else {
                missingCount++;
                if (missingCount == k) {
                    return current;
                }
            }
            current++;
        }
        return -1;
    }
}
