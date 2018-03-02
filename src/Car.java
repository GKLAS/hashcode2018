import java.util.ArrayList;
import java.util.List;

class Car {
    private final List<Integer> rides_id = new ArrayList<>();
    private Intersection current = new Intersection();
    private long finishing_time;

    void assign_ride(Ride ride) {
        finishing_time += current.manhattan_distance(ride.start);

        if (ride.earliest > finishing_time)
            finishing_time = ride.earliest;

        finishing_time += ride.distance;

        current = ride.end;
        rides_id.add(ride.id);
    }

    int evaluate_ride(Ride ride, long T, int B) {
        if (ride.latest > T)
            return -1;

        int distance = current.manhattan_distance(ride.start);

        long arrived = finishing_time + distance;
        if (ride.earliest > arrived)
            arrived = ride.earliest;
        if (arrived + ride.distance > ride.latest)
            return -1;

        int evaluation = ride.distance;
        if (ride.earliest >= finishing_time + distance)
            evaluation += B;
        return evaluation;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.valueOf(rides_id.size()));
        for (Integer id : rides_id) {
            str.append(' ').append(id);
        }
        return str.toString();
    }
}
