import java.util.*;

public class SubsequenceSum2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int targetSum = 2;

        printOneSubsequence(arr, 0, 0, targetSum, new ArrayList<>());
    }

    public static boolean printOneSubsequence(
            int[] arr,
            int index,
            int currentSum,
            int targetSum,
            List<Integer> path
    ) {

        // base case
        if (index == arr.length) {
            if (currentSum == targetSum) {
                System.out.println(path);
                return true; // STOP after first valid subsequence
            }
            return false;
        }

        // pick
        path.add(arr[index]);
        if (printOneSubsequence(
                arr,
                index + 1,
                currentSum + arr[index],
                targetSum,
                path
        )) {
            return true; // propagate success upward
        }
        path.remove(path.size() - 1); // backtrack

        // not pick
        if (printOneSubsequence(
                arr,
                index + 1,
                currentSum,
                targetSum,
                path
        )) {
            return true;
        }

        return false;
    }
}
