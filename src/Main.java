import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    class Intersection {
        int x;
        int y;
    }

    class Ride {
        Intersection start;
        Intersection end;
        int earliest;
        int latest;
    }

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
