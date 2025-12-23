import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode229 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // Brute Force
        int n = nums.length;
        int threshold = n / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > threshold) {
                res.add(key);
            }
        }
        return res;
    }
}