import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 1 };
        System.out.println(containsDuplicate(arr));

    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > 1) {
                return false;
            }
        }
        return true;
    }
}