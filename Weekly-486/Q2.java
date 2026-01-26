import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        // int[] nums = { 1, -2, 3, -4 };
        // int k = 3;
        int[] nums = { 5, 4, -9, 6 };
        int k = 2;
        int[] ans = rotatePositiveElements(nums, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] rotatePositiveElements(int[] nums, int k) {
        int n = nums.length;
        int[] result = nums.clone();

        int[] positives = Arrays.stream(nums).filter(x -> x >= 0).toArray();
        int posCount = positives.length;
        if (posCount <= 1) {
            return result;
        }
        k = k % posCount;

        int[] rotatedPositives = new int[posCount];
        for (int i = 0; i < posCount; i++) {
            System.out.println("Placing " + positives[i] + " at position " + ((i - k + posCount) % posCount));
            rotatedPositives[(i - k + posCount) % posCount] = positives[i];
        }

        int posIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                result[i] = rotatedPositives[posIndex++];
            }
        }

        return result;
    }
}
