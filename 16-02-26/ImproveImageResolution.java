import java.util.*;

public class ImproveImageResolution {
    public static void main(String[] args) {
        int k = 3;
        int totalDays = 3;
        List<Integer> imageResolution = new ArrayList<>(Arrays.asList(2, 1, 3, 3, 1));
        System.out.println(getMaxResolution2(k, totalDays, imageResolution));
    }

    public static int getMaxResolution(int k, int totalDays, List<Integer> imageResolution) {
        int n = imageResolution.size();
        if (k > n)
            return Collections.min(imageResolution);

        for (int day = 0; day < totalDays; day++) {
            int minIdx = getMinIndex(imageResolution);

            // pick a window of size k "around" minIdx (centered, then clamped)
            int start = minIdx - k / 2;
            if (start < 0)
                start = 0;
            if (start + k > n)
                start = n - k;

            for (int i = start; i < start + k; i++) {
                imageResolution.set(i, imageResolution.get(i) + 1);
            }
        }

        return Collections.min(imageResolution);
    }

    private static int getMinIndex(List<Integer> arr) {
        int idx = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(idx))
                idx = i;
        }
        return idx;
    }

    public static int getMaxResolution2(int k, int totalDays, List<Integer> imageResolution) {
        int n = imageResolution.size();
        long[] a = new long[n];
        long mn = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = imageResolution.get(i);
            mn = Math.min(mn, a[i]);
        }

        long lo = mn, hi = mn + totalDays + 1; // hi exclusive
        while (lo + 1 < hi) {
            long mid = lo + (hi - lo) / 2;
            if (canReach(a, n, k, totalDays, mid))
                lo = mid;
            else
                hi = mid;
        }
        return (int) lo;
    }

    // Can we make every index >= target using <= totalDays window-increments?
    private static boolean canReach(long[] a, int n, int k, int totalDays, long target) {
        long[] startOps = new long[n]; // how many ops start at index s
        long active = 0; // ops currently affecting index i
        long used = 0;

        for (int i = n - 1; i >= 0; i--) {
            // when moving from i+1 to i, ops starting at i+1 stop affecting
            if (i < n - 1)
                active -= startOps[i + 1];

            long cur = a[i] + active;
            if (cur < target) {
                long need = target - cur;
                used += need;
                if (used > totalDays)
                    return false;

                // earliest start that still covers i
                int s = Math.max(0, i - k + 1);
                startOps[s] += need;
                active += need;
            }
        }
        return true;
    }

}