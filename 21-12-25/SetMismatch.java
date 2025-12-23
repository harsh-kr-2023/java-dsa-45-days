public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] result = findErrorNums(nums);
        System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);
    }
    static int[] findErrorNums(int[] nums) {
        int duplicate = findDuplicate(nums);
        int difference = sumDifference(nums);
        int missing = duplicate + difference;
        return new int[]{duplicate, missing};
    }
    static int findDuplicate(int[] nums){
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        for (int num : nums) {
            if (seen[num]) {
                return num;
            }
            seen[num] = true;
        }
        return -1; // This line should never be reached if input is valid
    }

    static int sumDifference(int[] nums) {
        int n = nums.length;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
        }
        int originalSum = (n * (n + 1)) / 2;
        int difference = originalSum - currentSum;
        return difference;
    }
}