public class MinDeletionCost {
    public static void main(String[] args) {
        // String s = "aabaac";
        // int[] cost = {1, 2, 3, 4, 1, 10};
        // String s = "abc";
        // int[] cost = {10, 5, 8};
        // String s = "aaa";
        // int[] cost = {907055607, 714321275, 852902050};
        // String s = "aaaaaa";
        // int[] cost = {0, 1, 2, 3, 4, 5};
        String s = "mjvuu";
        int[] cost = {728052804,796037807,668485422,572545092,223318586};
        System.out.println(minDeletionCost(s, cost));
    }
    static long minDeletionCost(String s, int[] cost) {
        long totalCost = 0;
        long[] charSums = new long[26];
        
        for (int i = 0; i < s.length(); i++) {
            totalCost += cost[i];
            charSums[s.charAt(i) - 'a'] += cost[i];
        }
        
        long maxCharSum = 0;
        for (long sum : charSums) {
            maxCharSum = Math.max(maxCharSum, sum);
        }
        return (int)(totalCost - maxCharSum);
    }
}
