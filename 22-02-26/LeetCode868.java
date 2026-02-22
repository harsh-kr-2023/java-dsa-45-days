public class LeetCode868 {
    public static void main(String[] args) {
        int n = 22;
        System.out.println(binaryGap(n));
    }
    public static int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                max = Math.max(max, count);
                count = 1;
            } else {
                count++;
            }
        }
        return max;
    }
}
