import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<Ride> rides = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            R = scanner.nextInt();
            C = scanner.nextInt();
            F = scanner.nextInt();
            N = scanner.nextInt();
            B = scanner.nextInt();
            T = scanner.nextLong();

            rides.ensureCapacity(N);

            for (int i = 0; i < N; i++) {
                rides.add(new Ride(scanner, i));
            }
            Collections.sort(rides);

            cars = new Car[F];
            for (int i = 0; i < F; i++) {
                cars[i] = new Car();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-2);
        }

        while (!rides.isEmpty()) {
            //for each car
            //  if available
            //      assign ride
            //advance time
            break;
        }

        try (PrintWriter writer = new PrintWriter("output/output.txt")) {
            for (int i = 0; i < cars.length; i++) {
                writer.print(cars[i].rides_id.size());
                for (Integer id : cars[i].rides_id) {
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
