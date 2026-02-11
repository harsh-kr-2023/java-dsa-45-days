public class DistanceBetweenWords {
    public static void main(String[] args) {
        String[] words = { "i", "am", "a", "student", "from", "a", "university", "in", "a", "country" };
        String word1 = "a";
        String word2 = "country";
        System.out.println(findDistance2(words, word1, word2));
    }
    // Brute Force Approach
    public static int findDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        distance = Math.min(distance, Math.abs(i - j));
                    }
                }
            }
        }
        return distance;
    }
    // Optimised Approach
    public static int findDistance2(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }
        return distance;
    }
}
