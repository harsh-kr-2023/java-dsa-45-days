import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        String[] words = { "able", "area", "echo", "also" };
        List<List<String>> result = wordSquares(words);
        for (List<String> square : result) {
            System.out.println(square);
        }

    }

    static List<List<String>> wordSquares(String[] words) {
        // check for all combinations of 4 words which satisfy the below conditions
        // given and add them to a list and return the list
        // You are given a string array words, consisting of
        // distinct 4-letter strings, each containing lowercase English letters.
        // A word square consists of 4 distinct words: top, left, right and bottom,
        // arranged as follows:

        // top forms the top row.
        // bottom forms the bottom row.
        // left forms the left column (top to bottom).
        // right forms the right column (top to bottom).
        // It must satisfy:

        // top[0] == left[0], top[3] == right[0]
        // bottom[0] == left[3], bottom[3] == right[3]
        // Return all valid distinct word squares, sorted in ascending lexicographic
        // order by the 4-tuple (top, left, right, bottom

        
        // Brute Force approach
        // Method 1: Brute Force with Pruning
        // Generate all permutations of 4 words from the list
        // For each permutation, assign to (top, left, right, bottom)
        // Check all 4 corner constraints
        // Check if we can fill the middle rows consistently
        List<List<String>> result = new java.util.ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String top = words[i];
            for (int j = 0; j < n; j++) {
                if(j == i) continue;
                String left = words[j];
                if(top.charAt(0) != left.charAt(0)) continue;
                for (int k = 0; k < n; k++) {
                    if(k == i || k == j) continue;
                    String right = words[k];
                    if(top.charAt(3) != right.charAt(0)) continue;
                    for (int l = 0; l < n; l++) {
                        if(l == i || l == j || l == k) continue;
                        String bottom = words[l];
                        if(bottom.charAt(0) != left.charAt(3)) continue;
                        if(bottom.charAt(3) != right.charAt(3)) continue;
                        List<String> square = new java.util.ArrayList<>();
                        square.add(top);
                        square.add(left);
                        square.add(right);
                        square.add(bottom);
                        result.add(square);
                    }
                }
            }
        }
        return result;
    }
}
