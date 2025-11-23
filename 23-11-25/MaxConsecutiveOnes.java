public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 0, 1, 1, 1 };
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        System.out.println("Max consecutive ones: " + maxCount);
    }
}
