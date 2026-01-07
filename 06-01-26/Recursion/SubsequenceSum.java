public class SubsequenceSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int targetSum = 2;

        int result = countSubsequences(arr, 0, 0, targetSum, 0);
        System.out.println("\nFINAL ANSWER = " + result);
    }

    public static int countSubsequences(
            int[] arr,
            int index,
            int currentSum,
            int targetSum,
            int depth
    ) {

        print(depth, "Call -> index=" + index + ", sum=" + currentSum);

        // base case
        if (index == arr.length) {
            if (currentSum == targetSum) {
                print(depth, "✔ MATCH -> return 1");
                return 1;
            } else {
                print(depth, "✘ NO MATCH -> return 0");
                return 0;
            }
        }

        // pick
        print(depth, "Pick " + arr[index]);
        int include = countSubsequences(
                arr,
                index + 1,
                currentSum + arr[index],
                targetSum,
                depth + 1
        );

        // not pick
        print(depth, "Not Pick " + arr[index]);
        int exclude = countSubsequences(
                arr,
                index + 1,
                currentSum,
                targetSum,
                depth + 1
        );

        int total = include + exclude;
        print(depth, "Return " + total);

        return total;
    }

    // helper for indentation
    private static void print(int depth, String msg) {
        for (int i = 0; i < depth; i++) {
            System.out.print("│   ");
        }
        System.out.println(msg);
    }
}
