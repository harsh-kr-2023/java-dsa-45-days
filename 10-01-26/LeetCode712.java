import java.util.HashMap;
import java.util.Map;

public class LeetCode712 {
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    // Wrong Solution
    public static int minimumDeleteSum(String s1, String s2) {
        // We'll use a HashMap, first insert all elemets of s1 with frequency then if element ins2 then remove it else add it and return asciisum of map
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                map.put(s2.charAt(i), 1);
            }
        }
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }
}
