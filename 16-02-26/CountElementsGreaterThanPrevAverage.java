import java.util.List;
import java.util.ArrayList;

public class CountElementsGreaterThanPrevAverage {
    public static void main(String[] args) {
        List<Integer> responseTimes = new ArrayList<>();
        responseTimes.add(100);
        responseTimes.add(200);
        responseTimes.add(150);
        responseTimes.add(300);

        // responseTimes.add(0);
        
        // responseTimes.add(1);
        // responseTimes.add(100);
        System.out.println(countElementsGreaterThanPrevAverage(responseTimes));
    }
    public static int countElementsGreaterThanPrevAverage(List<Integer> responseTimes) {
        if(responseTimes.size() == 1) return 0;
        int[] prevAverages = new int[responseTimes.size()];
        prevAverages[0] = 0;
        for (int i = 1; i < responseTimes.size(); i++) {
            prevAverages[i] = (prevAverages[i - 1] * i + responseTimes.get(i)) / 2;
        }
        for (int i : prevAverages) {
            System.out.print(i + " ");
        }
        int count = 0;
        for (int i = 1; i < responseTimes.size(); i++) {
            if (responseTimes.get(i) > prevAverages[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
