import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class Simulation {
    public static int play(String file) {
        long T;
        Car[] cars;
        Ride[] rides;
        int R, C, F, N, B;

        try (Scanner scanner = new Scanner(new File("inputs/" + file + ".in"))) {
            R = scanner.nextInt();
            C = scanner.nextInt();
            F = scanner.nextInt();
            N = scanner.nextInt();
            B = scanner.nextInt();
            T = scanner.nextLong();

            rides = new Ride[N];
            for (int i = 0; i < N; i++) {
                rides[i] = new Ride(scanner, i);
            }

            cars = new Car[F];
            for (int i = 0; i < F; i++) {
                cars[i] = new Car();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        int total = 0;
        Arrays.sort(rides);
        for (Ride ride : rides) {
            Car best_car = null;
            int best_score = 0;
            for (Car car : cars) {
                int score = car.evaluate_ride(ride, T, B);
                if (score > best_score) {
                    best_car = car;
                    best_score = score;
                }
            }
            if (best_score > 0) {
                List<Car> best = new ArrayList<>();
                best.add(best_car);
                for (Car car : cars) {
                    if (car != best_car && car.evaluate_ride(ride, T, B) == best_score) {
                        best.add(car);
                    }
                }
                best.sort(Comparator.comparingInt(o -> ride.start.manhattan_distance(o.current)));
                best_car = best.get(0);
                best_car.assign_ride(ride);
                total += best_score;
            }
        }

        try (PrintWriter writer = new PrintWriter("outputs/" + file + ".out")) {
            for (Car car : cars) {
                writer.println(car);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return total;
    }
}
