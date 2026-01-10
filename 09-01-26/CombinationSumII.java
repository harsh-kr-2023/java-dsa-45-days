import java.util.*;
public class CombinationSumII {
    public static void main(String[] args) {
        // int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        // int target = 8;
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Brute force approach
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    public static void findCombinations(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
