import java.util.ArrayList;
import java.util.List;

class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        // int[] nums = { 0, 0, 0 };
        // int[] nums = { 0, 1, 1 };
        List<List<Integer>> answer = threeSum(nums);
        System.out.println(answer);
    }

    // static List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> answer = new ArrayList<>();
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // for (int k = j + 1; k < n; k++) {
    // if (nums[i] + nums[j] + nums[k] == 0) {
    // List<Integer> triplet = new ArrayList<>();
    // triplet.add(nums[i]);
    // triplet.add(nums[j]);
    // triplet.add(nums[k]);
    // answer.add(triplet);
    // }
    // }
    // }
    // }
    // return removeDuplicates(answer);
    // }

    // static List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> answer = new ArrayList<>();
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // HashSet<Integer> set = new HashSet<>();
    // for (int j = i + 1; j < n; j++) {
    // int third = -(nums[i] + nums[j]);
    // if (set.contains(third)) {
    // List<Integer> triplet = new ArrayList<>();
    // triplet.add(nums[i]);
    // triplet.add(nums[j]);
    // triplet.add(third);
    // answer.add(triplet);
    // }
    // set.add(nums[j]);
    // }
    // }
    // return removeDuplicates(answer);
    // }

    static List<List<Integer>> threeSum(int[] nums) {
        // sort nums
        java.util.Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    answer.add(triplet);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }

        }
        return removeDuplicates(answer);
    }

    static List<List<Integer>> removeDuplicates(List<List<Integer>> list) {
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> triplet : list) {
            // Sort current triplet
            List<Integer> sortedTriplet = new ArrayList<>(triplet);
            sortedTriplet.sort(null);

            boolean isDuplicate = false;

            // Check against all triplets in result
            for (List<Integer> existing : result) {
                List<Integer> sortedExisting = new ArrayList<>(existing);
                sortedExisting.sort(null);

                if (sortedTriplet.equals(sortedExisting)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                result.add(triplet);
            }
        }

        return result;
    }
}