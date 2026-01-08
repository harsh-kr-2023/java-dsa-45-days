import java.util.ArrayList;
import java.util.List;


public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    static void findCombinations(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
