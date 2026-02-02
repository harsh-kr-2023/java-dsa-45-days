import java.util.Queue;
import java.util.Set;

public class Q3 {
    public static void main(String[] args) {
        
    }
}
public class RideSharingSystem {
    private Queue<Integer> riders;
    private Queue<Integer> drivers;
    private Set<Integer> activeRiders;

    public RideSharingSystem() {
        riders = new LinkedList<>();
        drivers = new LinkedList<>();
        activeRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        riders.offer(riderId);
        activeRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }

    public int[] matchDriverWithRider() {
        while (!riders.isEmpty() && !activeRiders.contains(riders.peek())) {
            riders.poll();
        }

        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[]{-1, -1};
        }

        int driver = drivers.poll();
        int rider = riders.poll();
        activeRiders.remove(rider);

        return new int[]{driver, rider};
    }

    public void cancelRide(int riderId) {
        activeRides.remove(riderId);
    }
}