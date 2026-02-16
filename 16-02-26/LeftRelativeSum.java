import java.util.*;

public class LeftRelativeSum {
    public static void main(String[] args) {
        List<Long> arr = new ArrayList<>();
        arr.add(2L);
        arr.add(4L);
        arr.add(3L);
        List<Long> res = computeRelativeSum2(arr);
        System.out.println(res);
    }

    // Brute Force Approach
    public static List<Long> computeRelativeSum(List<Long> arr) {
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                // add aboslute difference if arr[i] > arr[j] else subtract absolute difference
                if (arr.get(i) > arr.get(j)) {
                    System.out.println(arr.get(i) + " " + arr.get(j));
                    sum += Math.abs(arr.get(i) - arr.get(j));
                } else {
                    sum -= Math.abs(arr.get(i) - arr.get(j));
                }
            }
            res.add(sum);
        }
        return res;
    }

    // Optimal Approach
    public static List<Long> computeRelativeSum2(List<Long> arr) {
        List<Long> res = new ArrayList<>(arr.size());
        long prefixSum = 0L;

        for (int i = 0; i < arr.size(); i++) {
            long x = arr.get(i);
            long sum = x * i - prefixSum;
            res.add(sum);
            prefixSum += x;
        }
        return res;
    }
}
