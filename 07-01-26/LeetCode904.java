import java.util.HashMap;

public class LeetCode904 {
    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        System.out.println(totalFruit(fruits));
    }
    static int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int maxFruitsInBucket = 0;
        int[] bucket = new int[2];
        // sliding window + hashmap
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        while (right < fruits.length) {
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }
            maxFruitsInBucket = Math.max(maxFruitsInBucket, right - left + 1);
            right++;
        }
        return maxFruitsInBucket;
    }
}
