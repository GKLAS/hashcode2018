import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class GreedySimulation extends Simulation {
    private void assign(List<Car> cars, Ride ride) {
        Collections.min(cars, Comparator.comparingInt(o -> ride.start.manhattanDistance(o.location))).assignRide(ride);
    }

    @Override
    int simulate() {
        int total = 0;
        Collections.sort(rides);
        for (Ride ride : rides) {
            List<Car> canMakeIt = cars.stream().filter(car -> car.canMakeIt(ride)).collect(Collectors.toList());
            List<Car> onTime = canMakeIt.stream().filter(car -> car.onTime(ride)).collect(Collectors.toList());
            if (!onTime.isEmpty()) {
                assign(onTime, ride);
                total += ride.distance + b;
            } else if (!canMakeIt.isEmpty()) {
                assign(canMakeIt, ride);
                total += ride.distance;
            }
        }
        return total;
    }
}
