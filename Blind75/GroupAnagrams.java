import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    // Brute Force Approach
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Traverse the array, check if the string belongs to any existing sublist, if
        // yes then add else create a new sublist
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            boolean found = false;
            for (List<String> list : result) {
                if (isAnagram(str, list.get(0))) {
                    list.add(str);
                    found = true;
                    break;
                }
            }
            if (!found) {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
            }
        }
        return result;
    }

    // Helper function for finding anagrams using HashMap
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    // Optimised Approach using Sorting
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}
