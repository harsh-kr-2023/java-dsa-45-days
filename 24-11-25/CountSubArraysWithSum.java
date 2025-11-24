public class CountSubArraysWithSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        int targetSum = 5;
        int result = countSubArrays(arr, targetSum);
        System.out.println("Number of sub-arrays with sum " + targetSum + ": " + result);
    }

    public static int countSubArrays(int[] arr, int targetSum) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for(int j = i; j<arr.length;j++){
                currentSum += arr[j];
                if(currentSum == targetSum){
                    count++;
                }
            }
        }
        return count;
    }
}