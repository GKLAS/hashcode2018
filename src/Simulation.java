import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Simulation {
    final ArrayList<Car> cars = new ArrayList<>();
    final ArrayList<Ride> rides = new ArrayList<>();
    int b;

    abstract int simulate();

    public void read(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.nextInt(); // c
            scanner.nextInt(); // r
            int f = scanner.nextInt();
            int n = scanner.nextInt();
            b = scanner.nextInt();
            long t = scanner.nextLong();

            rides.clear();
            for (int i = 0; i < n; i++) {
                Ride ride = new Ride(scanner, i);
                if (ride.isValid(t)) {
                    rides.add(ride);
                }
            }

            cars.clear();
            for (int i = 0; i < f; i++) {
                cars.add(new Car());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Car car : cars) {
                writer.println(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int run(String input, String output) {
        read(input);
        int total = simulate();
        write(output);
        return total;
    }
}
