import java.util.HashMap;

public class LeetCode575 {
    public static void main(String[] args) {
        int[] candies = {1, 1, 2, 2, 3, 3};
        int result = distributeCandies(candies);
        System.out.println(result);
    }
    public static int distributeCandies(int[] candyType) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int candy : candyType) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        return Math.min(map.size(), candyType.length / 2);
    }
}
