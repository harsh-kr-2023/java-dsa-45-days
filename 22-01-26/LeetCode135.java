import java.util.Arrays;

public class LeetCode135 {
    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        System.out.println(candy2(ratings));
    }

    public static int candy(int[] ratings) {
        // Brute Force
        int n = ratings.length;
        int[] leftNeighbors = new int[n];
        int[] rightNeighbors = new int[n];
        Arrays.fill(leftNeighbors, 1);
        Arrays.fill(rightNeighbors, 1);
        // Left to Right then Right to Left
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftNeighbors[i] = leftNeighbors[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightNeighbors[i] = Math.max(rightNeighbors[i], rightNeighbors[i + 1] + 1);
            }
        }
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(leftNeighbors[i], rightNeighbors[i]);
        }
        return totalCandies;
    }

    // Optimized Approach
    public static int candy2(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        int totalCandies = 0;
        // Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }
}