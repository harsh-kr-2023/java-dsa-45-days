
import java.util.*;

public class S1L62 {
    public static void main(String[] args) {
        System.out.println("Given an array, we have found the number of occurrences of each element in the array.");
        int[] arr = { 1, 2, 3, 4, 1, 2, 1 };
        List<List<Integer>> FrequencyArr = countFrequency(arr);
        printList(FrequencyArr);
    }

    // My approach is use HashMap to store the frequency of each element
    static List<List<Integer>> countFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (var entry : freq.entrySet()) {
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    static void printList(List<List<Integer>> arr) {
        for (List<Integer> list : arr) {
            for (int x : list) {
                System.out.print("[" + x + "]");
            }
            System.out.println();
        }
    }
}
