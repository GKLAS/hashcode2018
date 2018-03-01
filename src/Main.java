import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Expecting argument");
            System.exit(-1);
        }

        try (Scanner scanner = new Scanner(new File(args[0]))) {

            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int F = scanner.nextInt();
            int N = scanner.nextInt();
            int B = scanner.nextInt();
            long T = scanner.nextLong();

            System.out.println(R);
            System.out.println(C);
            System.out.println(F);
            System.out.println(N);
            System.out.println(B);
            System.out.println(T);

            ArrayList<Ride> rides = new ArrayList<>();
            rides.ensureCapacity(N);

            for (int i = 0; i < N; i++) {
                rides.add(new Ride(scanner, i));
            }
            Collections.sort(rides);

            Car[] cars = new Car[F];
            for (int i = 0; i < F; i++) {
                cars[i] = new Car();
            }

            while (!rides.isEmpty()) {
                //for each car
                //  if available
                //      assign ride
                //advance time
                break;
            }

            PrintWriter writer = new PrintWriter("output/output.txt");
            for (int i = 0; i < F; i++) {
                writer.print(cars[i].rides_id.size());
                for(int j =0 ; j <cars[i].rides_id.size();j++) {
                    writer.print(" ");
                    writer.print(cars[i].rides_id.get(j));
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
