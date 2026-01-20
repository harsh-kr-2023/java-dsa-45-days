public class LeetCode1217 {
    public static void main(String[] args) {
        int[] position = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(minCostToMoveChips(position));
    }

    public static int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);

    }
}
