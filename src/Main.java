import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Expecting argument");
            System.exit(-1);
        }

        long T;
        int R, C, F, N, B;
        Car[] cars = null;
        Ride[] rides = null;

        try (Scanner scanner = new Scanner(new File(args[0]))) {
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
            Arrays.sort(rides);

            cars = new Car[F];
            for (int i = 0; i < F; i++) {
                cars[i] = new Car();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-2);
        }

        for (Ride ride : rides) {
            int best_car = 0;
            int best_score = 0;
            for (int j = 0; j < cars.length; j++) {
                int score = cars[j].evaluate_ride(ride);
                if (score > best_score) {
                    best_car = j;
                    best_score = score;
                }
            }
            if (best_score > 0)
                cars[best_car].assign_ride(ride);
        }


        try (PrintWriter writer = new PrintWriter("output/output.txt")) {
            for (Car car : cars) {
                writer.print(car.rides_id.size());
                for (Integer id : car.rides_id) {
                    writer.print(" " + id);
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
