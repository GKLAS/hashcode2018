import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

abstract class Simulation {
    int b;
    Car[] cars;
    Ride[] rides;

    abstract int simulate();

    public void read(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.nextInt(); // c
            scanner.nextInt(); // r
            int f = scanner.nextInt();
            int n = scanner.nextInt();
            b = scanner.nextInt();
            long t = scanner.nextLong();

            rides = new Ride[n];
            int x = 0;
            for (int i = 0; i < n; i++) {
                Ride ride = new Ride(scanner, i);
                if (ride.latest <= t) {
                    rides[x] = ride;
                    x++;
                }
            }
            rides = Arrays.copyOfRange(rides, 0, x);

            cars = new Car[f];
            for (int i = 0; i < f; i++) {
                cars[i] = new Car();
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
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
