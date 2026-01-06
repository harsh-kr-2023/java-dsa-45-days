public class LeetCode2379 {
    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        int result = minimumRecolors(blocks, k);
        System.out.println(result);
    }

    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minRecolors = Integer.MAX_VALUE;
        int currentRecolors = 0;
        // Sliding Window
        int low = 0;
        int high = k - 1;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                currentRecolors++;
            }
        }
        minRecolors = Math.min(minRecolors, currentRecolors);
        while (high < n - 1) {
            high++;
            if (blocks.charAt(high) == 'W') {
                currentRecolors++;
            }
            if (blocks.charAt(low) == 'W') {
                currentRecolors--;
            }
            low++;
            minRecolors = Math.min(minRecolors, currentRecolors);
        }
        return minRecolors;
    }
}
