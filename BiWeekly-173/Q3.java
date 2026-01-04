public class Q3 {
    public static void main(String[] args) {
        // System.out.println("You are given an integer n, a 2D integer array
        // restrictions, and an integer array diff of length n - 1. Your task is to
        // construct a sequence of length n, denoted by a[0], a[1], ..., a[n - 1], such
        // that it satisfies the following conditions:
        // a[0] is 0.
        // All elements in the sequence are non-negative.
        // For every index i (0 <= i <= n - 2), abs(a[i] - a[i + 1]) <= diff[i].
        // For each restrictions[i] = [idx, maxVal], the value at position idx in the
        // sequence must not exceed maxVal (i.e., a[idx] <= maxVal).
        // Your goal is to construct a valid sequence that maximizes the largest value
        // within the sequence while satisfying all the above conditions.
        // Return an integer denoting the largest value present in such an optimal
        // sequence.");
        int n = 10;
        int[][] restrictions = { { 3, 1 }, { 8, 1 } };
        int[] diff = { 2, 2, 3, 1, 4, 5, 1, 1, 2 };
        System.out.println(maximumValue(n, restrictions, diff));
    }

    public static int maximumValue(int n, int[][] restrictions, int[] diff) {
        // n = 5, diff = [2, 2, 2, 2]
        // restriction: position 2 ≤ 1

        // Forward pass:
        // pos 0: 0
        // pos 1: min(0+2, ∞) = 2
        // pos 2: min(2+2, 1) = 1 ← restriction hits!
        // pos 3: min(1+2, ∞) = 3
        // pos 4: min(3+2, ∞) = 5

        // Backward pass:
        // pos 4: stays 5
        // pos 3: min(3, 5+2) = 3 (no change)
        // pos 2: min(1, 3+2) = 1 (no change)
        // pos 1: min(2, 1+2) = 2 (no change)
        // pos 0: min(0, 2+2) = 0 (no change)

        // Max value in sequence = 5
            int[] maxAtPos = new int[n];
            for (int i = 0; i < n; i++) {
                maxAtPos[i] = Integer.MAX_VALUE;
            }
            for (int[] restriction : restrictions) {
                int idx = restriction[0];
                int maxVal = restriction[1];
                maxAtPos[idx] = Math.min(maxAtPos[idx], maxVal);
            }
            maxAtPos[0] = 0;
            for (int i = 1; i < n; i++) {
                maxAtPos[i] = Math.min(maxAtPos[i - 1] + diff[i - 1], maxAtPos[i]);
            }
            for(int i = n - 2; i >= 0; i--) {
                maxAtPos[i] = Math.min(maxAtPos[i + 1] + diff[i], maxAtPos[i]);
            }
            int result = 0;
            for (int val : maxAtPos) {
                result = Math.max(result, val);
            }
            return result;
        }
    }
