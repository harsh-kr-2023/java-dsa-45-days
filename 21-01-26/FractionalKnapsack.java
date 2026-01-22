import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] values = { 100, 60, 100, 200 };
        int[] weights = { 20, 10, 50, 50 };
        int capacity = 90;
        System.out.println(fractionalKnapsack(values, weights, capacity));
    }

    public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        // Create an array of items with value-to-weight ratio
        int n = values.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        // Sort the items in descending order of value-to-weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double totalValue = 0.0;
        for (Item item : items) {
            if (capacity == 0) break;
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.ratio * capacity;
                capacity = 0;
            }
        }
        return totalValue;
    }
    static class Item {
        int value;
        int weight;
        double ratio;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }
}