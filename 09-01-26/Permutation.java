import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int n = arr.length;
        ArrayList<ArrayList<Integer>> result = permute(arr);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] arr) {
        // Brute force approach
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPermutations(arr, 0, result);
        return result;
    }

    public static void findPermutations(int[] arr, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : arr) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            findPermutations(arr, index + 1, result);
            swap(arr, index, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}