import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        List<Integer> bulbs = new ArrayList<>();
        bulbs.add(10);
        bulbs.add(30);
        bulbs.add(20);
        bulbs.add(10);
        // bulbs.add(1);
        // bulbs.add(1);
        // bulbs.add(1);
        List<Integer> result = toggleLightBulbs(bulbs);
        System.out.println(result);
    }

    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < bulbs.size(); i++) {
            // if element alredy in result, remove else add
            if (result.contains(bulbs.get(i))) {
                result.remove(Integer.valueOf(bulbs.get(i)));
            } else {
                result.add(bulbs.get(i));
            }
        }
        // sort
        Collections.sort(result);
        return result;
    }
    
}
