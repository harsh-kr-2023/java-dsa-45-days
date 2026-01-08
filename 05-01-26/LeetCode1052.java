public class LeetCode1052 {
    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;
        int result = maxSatisfied(customers, grumpy, minutes);
        System.out.println(result);
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // Sliding Window Approach
        int totalSatisfied = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        int additionalSatisfied = 0;
        int maxAdditionalSatisfied = 0;
        int low = 0;
        int high = minutes - 1;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
        }
        maxAdditionalSatisfied = additionalSatisfied;
        while (high < n - 1) {
            high++;
            if (grumpy[high] == 1) {
                additionalSatisfied += customers[high];
            }
            if (grumpy[low] == 1) {
                additionalSatisfied -= customers[low];
            }
            low++;
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }
        return totalSatisfied + maxAdditionalSatisfied;
    }
}
