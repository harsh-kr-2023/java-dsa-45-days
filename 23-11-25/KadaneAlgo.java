public class KadaneAlgo {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int maxSum = nums[0];
        int currSum = nums[0];
        for(int i=1;i<nums.length;i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            if(maxSum < currSum) {
                maxSum = currSum;
            }
        }
        System.out.println("Maximum subarray sum: " + maxSum);
    }
}
