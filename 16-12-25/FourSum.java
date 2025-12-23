import java.util.ArrayList;
import java.util.List;

class FourSum {
    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        // int[] nums = { 2, 2, 2, 2 };
        // int target = 8;
        // int[] nums = { 0, 1, 1 };
        List<List<Integer>> answer = fourSum(nums, target);
        System.out.println(answer);
    }

    // static List<List<Integer>> fourSum(int[] nums, int target) {
    // List<List<Integer>> answer = new ArrayList<>();
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // for (int k = j + 1; k < n; k++) {
    // for (int l = k + 1; l < n; l++) {
    // if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
    // List<Integer> quadruplet = new ArrayList<>();
    // quadruplet.add(nums[i]);
    // quadruplet.add(nums[j]);
    // quadruplet.add(nums[k]);
    // quadruplet.add(nums[l]);
    // answer.add(quadruplet);
    // }

    // }
    // }
    // }
    // }
    // return removeDuplicates(answer);
    // }

    // static List<List<Integer>> fourSum(int[] nums, int target) {
    // List<List<Integer>> answer = new ArrayList<>();
    // int n = nums.length;
    // for (int i = 0; i < n - 3; i++) {
    // for (int j = i + 1; j < n; j++) {
    // HashSet<Integer> set = new HashSet<>();
    // for (int k = j + 1; k < n; k++) {
    // int fourth = target-(nums[i] + nums[j] + nums[k]);
    // if (set.contains(fourth)) {
    // List<Integer> quadruplet = new ArrayList<>();
    // quadruplet.add(nums[i]);
    // quadruplet.add(nums[j]);
    // quadruplet.add(fourth);
    // quadruplet.add(nums[k]);
    // answer.add(quadruplet);
    // }
    // set.add(nums[k]);
    // }
    // }
    // }
    // return removeDuplicates(answer);
    // }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        // sort nums
        java.util.Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[k]);
                        quadruplet.add(nums[l]);
                        answer.add(quadruplet);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }
            }
        }
        return answer;
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