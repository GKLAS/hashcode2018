import java.util.ArrayList;
import java.util.List;

class Car {
    private final List<Ride> rides = new ArrayList<>();
    Intersection location = new Intersection();
    private long busyUntil;

    void assignRide(Ride ride) {
        busyUntil += location.manhattanDistance(ride.start);
        if (ride.earliest > busyUntil)
            busyUntil = ride.earliest;
        busyUntil += ride.distance;

        location = ride.finish;
        rides.add(ride);
    }

    boolean canMakeIt(Ride ride) {
        int distance = location.manhattanDistance(ride.start);
        long arrived = busyUntil + distance;
        if (ride.earliest > arrived)
            arrived = ride.earliest;
        return arrived + ride.distance <= ride.latest;
    }

    boolean onTime(Ride ride) {
        int distance = location.manhattanDistance(ride.start);
        return ride.earliest >= busyUntil + distance;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.valueOf(rides.size()));
        for (Ride ride : rides) {
            str.append(' ').append(ride.id);
        }
        return str.toString();
    }
}
