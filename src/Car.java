

class Car {
    Intersection current;
    Ride ride;
    int finishing_time;

    Car() {
        this.current = new Intersection();
    }

    void assing_ride(Ride ride, int current) {
        this.ride = ride;
        this.finishing_time = ride.distance + current;
    }
}


