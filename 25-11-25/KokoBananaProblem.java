// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

// Example 1:

// Input: piles = [3,6,7,11], h = 8
// Output: 4

public class KokoBananaProblem {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = 0;
        int k = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int Hour = 0;
            for (int pile : piles) {
                Hour += Math.ceil((double) pile / mid);
            }
            if (Hour <= h) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return k;
    }
}
