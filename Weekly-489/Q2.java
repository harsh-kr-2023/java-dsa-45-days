import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        int[] nums = {20,10,30,30};
        System.out.println(firstUniqueFreq(nums));
    }
    public static int firstUniqueFreq(int[] nums) {
        // use map to store element and its frequency and return first element with unique frequency
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : freqMap.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }
        for (int num : nums) {
            int freq = freqMap.get(num);
            if (freqCount.get(freq) == 1) {
                return num;
            }
        }

        return -1; 
    }
}