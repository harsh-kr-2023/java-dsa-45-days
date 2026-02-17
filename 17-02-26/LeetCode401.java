import java.util.ArrayList;
import java.util.List;

public class LeetCode401 {
    public static void main(String[] args) {
        int turnedOn = 1;
        List<String> result = readBinaryWatch(turnedOn);
        System.out.println(result);
    }
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    if (j < 10) {
                        result.add(i + ":0" + j);
                    } else {
                        result.add(i + ":" + j);
                    }
                }
            }
        }
        return result;
    }
}
