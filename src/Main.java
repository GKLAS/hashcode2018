import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Expecting argument");
            System.err.println("Usage: "+args[0]+" <file_name>");
            System.exit(-1);
        }
        System.out.println("Hello World!");
        try (Scanner scanner = new Scanner(new File(args[1]))) {

            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int F = scanner.nextInt();
            int N = scanner.nextInt();
            int B = scanner.nextInt();
            long T = scanner.nextLong();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
