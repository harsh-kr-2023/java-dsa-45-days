import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3};
        // int[] target = { 2, 1, 3};
        // int[] nums = { 7, 3, 7 };
        // int[] target = { 5, 5, 9 };
        int[] nums = { 13, 6, 6 };
        int[] target = { 13, 6, 8 };
        int result = minimumOperations(nums, target);
        System.out.println(result);
    }

    public static int minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int operations = 0;
        // Keep track of values x for which we have already performed an operation
        Set<Integer> valuesProcessed = new HashSet<>();
        
        // We only care about values that actually NEED an update at some index
        // To avoid O(N^2), we pre-identify which values are "broken"
        Set<Integer> valuesToUpdate = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != target[i]) {
                valuesToUpdate.add(nums[i]);
            }
        }
        
        // The answer is simply the count of unique values in 'nums' 
        // that exist at any position where nums[i] != target[i].
        return valuesToUpdate.size();
    }
}