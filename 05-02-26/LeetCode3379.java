public class LeetCode3379 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,1};
        int[] res = constructTransformedArray(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
    public static int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int idx = ((i + nums[i]) % n + n) % n;
            res[i] = nums[idx];
        }
        return res;
    }
}
