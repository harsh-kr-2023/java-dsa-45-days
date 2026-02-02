public class Q2 {
    public static void main(String[] args) {
        int[] numbers = { 1, 5, 2 };
        System.out.println(finalElement(numbers));
    }

    public static int finalElement(int[] nums) {
        int n = nums.length;
        // If only one element, that's the answer
        if (n == 1) return nums[0];
        return return Math.max(nums[0], nums[n-1]);
    }
}