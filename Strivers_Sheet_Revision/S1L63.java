
import java.util.*;

public class S1L63 {
    public static void main(String[] args) {
        System.out.println("Given an array nums of n integers, find the most frequent element in it i.e., the element that occurs the maximum number of times. If there are multiple elements that appear a maximum number of times, find the smallest of them.");
        int[] arr = {4, 4, 5, 5, 6};
        int result = countFrequency(arr);
        System.out.println(result);
    }

    // My approach is use HashMap to store the frequency of each element and then return element with max frequency
    static int countFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxKey = -1;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return maxKey;
    }
}
