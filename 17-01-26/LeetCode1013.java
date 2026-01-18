public class LeetCode1013 {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0 };
        System.out.println(canThreePartsEqualSum(arr));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int partSum = sum / 3;
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == partSum) {
                count++;
                currentSum = 0;
            }
        }
        System.out.println(count);
        if (count == 3) {
            return true;
        }
        return false;
    }
}
