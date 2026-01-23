import java.util.Stack;

public class LeetCode739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperaturesStack(temperatures);
        for (int days : result) {
            System.out.print(days + " ");
        }
    }

    // Brute Force Approach
    public static int[] dailyTemperatures(int[] temperatures) {
        // Brute Force Approach
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // Optimized Approach using 2 Pointers
    public static int[] dailyTemperaturesOptimized(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int hottest = 0;
        for (int i = n - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            int days = 1;
            while (temperatures[i + days] <= currentTemp) {
                days += result[i + days];
            }
            result[i] = days;
        }
        return result;
    }

    // Optimized Approach using Stack
    public static int[] dailyTemperaturesStack(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                System.out.println("Current Index: " + i + ", Popped Index: " + index);
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
