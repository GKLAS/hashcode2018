import java.util.ArrayList;

class Car {
    private final ArrayList<Ride> rides = new ArrayList<>();
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
        long arrived = busyUntil + location.manhattanDistance(ride.start);
        if (ride.earliest > arrived)
            arrived = ride.earliest;
        return arrived + ride.distance <= ride.latest;
    }

    boolean onTime(Ride ride) {
        return ride.earliest >= busyUntil + location.manhattanDistance(ride.start);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.valueOf(rides.size()));
        for (Ride ride : rides) {
            str.append(' ').append(ride);
        }
        return str.toString();
    }
}
