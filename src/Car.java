import java.util.ArrayList;
import java.util.List;

class Car {
    Intersection current;
    Ride ride;
    int finishing_time;
    List<Integer> rides_id ;
    Car() {
        this.current = new Intersection();
        rides_id = new ArrayList<>();
    }

    void assign_ride(Ride ride, int current,int id) {
        this.ride = ride;
        this.finishing_time = ride.distance + current;
        rides_id.add(id);
    }
}


