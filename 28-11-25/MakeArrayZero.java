public class MakeArrayZero {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 3, 4, 5 };
        System.out.println(makeArrayZero(arr));
    }
    public static int makeArrayZero(int[] nums) {
        int operation  = 0;
        while (true) {
            boolean allZero = true;
            int smallest = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num != 0) {
                    allZero = false;
                    if (num < smallest) {
                        smallest = num;
                    }
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= smallest;
                }
            }
            operation++;
            if (allZero) {
                break;
            }
        }
        return operation;
    }
}
