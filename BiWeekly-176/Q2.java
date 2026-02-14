import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        // String[] words = {"apple", "banana", "apply", "bandit"};
        // int k = 2;
        // String[] words = {"car","cat","cartoon"};
        // int k = 3;
        String[] words = {"bat","dog","dog","doggy","bat"};
        int k = 3;
        System.out.println(prefixConnected(words, k));
    }
    // Brute Force Approach
    public static int prefixConnected(String[] words, int k) {
        Arrays.sort(words);
        int group = 0;
        String lastCounted = null;
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() < k) continue;
            String prefix = words[i].substring(0, k);
            if (prefix.equals(lastCounted)) continue;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].length() >= k && words[j].startsWith(prefix)) {
                    group++;
                    lastCounted = prefix;
                    break;
                }
            }
        }
        return group;
    }
}