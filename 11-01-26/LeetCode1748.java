import java.util.HashMap;

public class LeetCode1748 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        int result = sumOfUnique(nums);
        System.out.println(result);
    }
    public static int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 1) {
                sum += num;
            } else if (map.get(num) == 2) {
                sum -= num;
            }
        }
        return sum;
    }
}
