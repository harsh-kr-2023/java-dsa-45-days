public class Q1 {
    public static void main(String[] args) {
        // int[] nums = {4, 1, 2};
        // int[] nums = {5, 4, 3};
        // int[] nums = {64, 75, 78};
        int[] nums = {37, 96, 96};
        // int[] nums = {58, 89};
        // int[] nums = {89};
        System.out.println(dominantIndices(nums));
    }
    public static int dominantIndices(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n - 1; i++){
            int[] right = new int[n - i - 1];
            for(int j = 0; j < n - i - 1; j++){
                right[j] = nums[j + i + 1];
            }
            if(isDominant(nums[i], right)){
                System.out.println(nums[i] + "is dominant");
                count++;
            }
        }
        return count;
    }
    public static boolean isDominant(int num, int[] nums){
        int n = nums.length;
        double average = 0;
        for(int i = 0; i < n; i++){
            average += nums[i];
        }
        average /= n;
        if(num > average){
            return true;
        }
        return false;
    }
}
