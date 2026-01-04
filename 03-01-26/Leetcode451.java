import java.util.HashMap;

public class Leetcode451 {
    public static void main(String[] args) {
        // String s = "tree";
        String s = "bbAa";
        System.out.println(frequencySort(s));
    }
    static String frequencySort(String s) {
        // use a hashmap to store the frequency of each character then sort the characters by frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // create an array of buckets where index represents frequency
        StringBuilder[] buckets = new StringBuilder[s.length() + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new StringBuilder();
            }
            for (int i = 0; i < freq; i++) {
                buckets[freq].append(c);
            }
        }
        // build the result string from the buckets
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                sb.append(buckets[i]);
            }
        }
        return sb.toString();
    }
}