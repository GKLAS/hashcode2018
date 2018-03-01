import java.util.ArrayList;
import java.util.List;

class Car {
    final List<Integer> rides_id;
    private Intersection current;
    private long finishing_time;

    Car() {
        current = new Intersection();
        rides_id = new ArrayList<>();
    }

    void assign_ride(Ride ride) {

        finishing_time += manhattan_distance(current, ride.start);

        if (ride.earliest > finishing_time)
            finishing_time = ride.earliest;

        finishing_time += ride.distance;

        current = ride.end;
        rides_id.add(ride.id);
    }

    int evaluate_ride(Ride ride, long T, int B) {

        if (ride.latest > T)
            return -1;

        int distance = manhattan_distance(current, ride.start);

        if (distance + ride.distance > ride.latest) {
            return -1;
        }

        int evaluation = ride.distance;
        if (ride.earliest >= finishing_time + distance)
            evaluation += B;
        return evaluation;
    }

    private int manhattan_distance(Intersection start, Intersection end) {
        return Math.abs(end.x - start.x) + Math.abs(end.y - start.y);
    }
}
