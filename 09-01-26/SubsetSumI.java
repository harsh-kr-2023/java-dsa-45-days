import java.util.*;

public class SubsetSumI {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = { 3, 1, 2 };
        List<Integer> result = subsetSums(arr, n);
        System.out.println(result);
    }
    public static ArrayList<Integer> subsetSums(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        findSubsets(arr, n, 0, 0, result);
        Collections.sort(result);
        return result;
    }
    public static void findSubsets(int[] arr, int n, int index, int sum, ArrayList<Integer> result) {
        if (index == n) {
            result.add(sum);
            return;
        }
        findSubsets(arr, n, index + 1, sum + arr[index], result);
        findSubsets(arr, n, index + 1, sum, result);
    }
}
