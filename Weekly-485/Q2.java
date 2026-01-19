import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        // int[] costs = { 4, 8, 5, 3 };
        // int[] capacity = { 1, 5, 2, 7 };
        // int budget = 8;
        int[] costs = { 3, 5, 7, 4 };
        int[] capacity = { 2, 4, 3, 6 };
        int budget = 7;
        System.out.println(maxCapacity(costs, capacity, budget));
    }

    public static int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;

        // Handle single machine case
        int maxCapacity = 0;
        for (int i = 0; i < n; i++) {
            if (costs[i] < budget) {
                maxCapacity = Math.max(maxCapacity, capacity[i]);
            }
        }

        // Create and sort machines by cost
        Machine[] machines = new Machine[n];
        for (int i = 0; i < n; i++) {
            machines[i] = new Machine(costs[i], capacity[i]);
        }
        Arrays.sort(machines, (a, b) -> a.cost - b.cost);

        // Precompute maximum capacity for each prefix (up to each index)
        int[] maxCapUpTo = new int[n];
        maxCapUpTo[0] = machines[0].capacity;
        for (int i = 1; i < n; i++) {
            maxCapUpTo[i] = Math.max(maxCapUpTo[i - 1], machines[i].capacity);
        }

        // For each machine, find the best partner using two-pointer approach
        for (int i = 1; i < n; i++) {
            int left = 0, right = i - 1;
            int remaining = budget - machines[i].cost - 1; // -1 to ensure strictly less

            if (remaining <= 0)
                continue;

            // Binary search for machine with max cost <= remaining
            int bestIdx = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (machines[mid].cost <= remaining) {
                    bestIdx = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (bestIdx != -1) {
                maxCapacity = Math.max(maxCapacity,
                        machines[i].capacity + maxCapUpTo[bestIdx]);
            }
        }

        return maxCapacity;
    }

    static class Machine {
        int cost;
        int capacity;

        Machine(int cost, int capacity) {
            this.cost = cost;
            this.capacity = capacity;
        }
    }
}