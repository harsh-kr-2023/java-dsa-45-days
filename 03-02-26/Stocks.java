// =====================================
// DSA INTERVIEW TEMPLATE
// =====================================
// PROBLEM: test
// - 
// INPUT:
// - 
// OUTPUT:
// - 
// ASSUMPTIONS:
// - 
// -------------------------------------
// BRUTE FORCE:
// - Idea:
// - Time Complexity:
// - Space Complexity:
// - Why not optimal?
// -------------------------------------
// OPTIMAL APPROACH:
// - Technique / Pattern:
// - Why it works:
// - Invariant (if any):
// -------------------------------------
// EDGE CASES:
// - 
// - 
// - 
// -------------------------------------
// FINAL COMPLEXITY:
// - Time:
// - Space:
// -------------------------------------
// FAILURE MODES 
// =====================================
// CODE BELOW
// =====================================
public class Stocks {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
    }
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            if (profit > 0) {
                totalProfit += profit;
            }
        }
        return totalProfit;
    }
}
