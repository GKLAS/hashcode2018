import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class GreedySimulation extends Simulation {
    @Override
    int simulate() {
        int total = 0;
        Arrays.sort(rides);
        for (Ride ride : rides) {
            List<Car> canMakeIt = Arrays.stream(cars).filter(car -> car.canMakeIt(ride)).collect(Collectors.toList());
            List<Car> onTime = canMakeIt.stream().filter(car -> car.onTime(ride)).collect(Collectors.toList());
            if (!onTime.isEmpty()) {
                Car best_car = Collections.min(onTime, Comparator.comparingInt(o -> ride.start.manhattanDistance(o.location)));
                best_car.assignRide(ride);
                total += ride.distance + b;
            } else if (!canMakeIt.isEmpty()) {
                Car best_car = Collections.min(canMakeIt, Comparator.comparingInt(o -> ride.start.manhattanDistance(o.location)));
                best_car.assignRide(ride);
                total += ride.distance;
            }
        }
        return total;
    }
}
