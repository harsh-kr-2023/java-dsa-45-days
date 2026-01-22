import java.util.Arrays;

public class FindPlatform {
    public static void main(String[] args) {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(findPlatform(arr, dep));
    }

    public static int findPlatform(int[] arr, int[] dep) {
        // Greedy Approach
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform = 0;
        int result = 0;
        int arrival = 0;
        int departure = 0;
        while (arrival < n && departure < n) {
            if (arr[arrival] <= dep[departure]) {
                platform++;
                arrival++;
            } else {
                platform--;
                departure++;
            }
            result = Math.max(result, platform);
        }
        return result;
    }
}