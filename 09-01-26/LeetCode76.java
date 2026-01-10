import java.util.HashMap;

public class LeetCode76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println(result);
    }

    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int required = need.size();
        int formed = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                formed++;
            }
            if(formed == required) {
                
    }
        
}
