public class LeetCode1423 {
    public static void main(String[] args) {
        int[] cardPoints = { 1,79,80,1,1,1,200,1 };
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    static int maxScore(int[] cardPoints, int k) {
        int r = cardPoints.length - 1;
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        maxSum = Math.max(sum, maxSum);
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[k-1-i];
            sum += cardPoints[r];
            r--;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}