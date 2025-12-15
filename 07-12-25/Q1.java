public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[] nums = {4, 5, 4};
        int[] result = q1.sortByReflection(nums);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] sortByReflection(int[] nums) {
        int[] newArr = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            int newNum = binaryReflection(nums[i]);
            int j = i - 1;
            while(j >= 0 && newArr[j] > newNum) {
                newArr[j + 1] = newArr[j];
                j--;
            }
            newArr[j + 1] = newNum;
        }
        return newArr;
    }
    static int binaryReflection(int n) {
        String bin = Integer.toBinaryString(n);
        String revBin = "";
        while(bin.length() > 0) {
            revBin += bin.charAt(bin.length() - 1);
            bin = bin.substring(0, bin.length() - 1);
        }
        int revNum = Integer.parseInt(revBin, 2);
        return revNum;
    }
}