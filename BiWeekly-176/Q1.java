import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        String[] words = {"abcd","def","xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println(mapWordWeights2(words, weights));
    }
    // Brute Force Approach
    public static String mapWordWeights(String[] words, int[] weights) {
        // create a hashmap to store key-value pairs with each alphabet as key and its weight as value
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), weights[i]);
        }
        // Now loop over each word in words and add the weight and find corresponding alphabet
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            int sum = 0;
            for (char c : word.toCharArray()) {
                sum += map.get(c);
                sum %= 26;
            }
            ans.append((char) ('z' - sum));
        }
        return ans.toString();
    }
    // Optimal Approach
    public static String mapWordWeights2(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int sum = 0;
            for (char c : word.toCharArray()) {
                sum = (sum + weights[c - 'a']) % 26;
            }
            ans.append((char) ('z' - sum));
        }
        return ans.toString();
    }
}