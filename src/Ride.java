import java.util.Scanner;

class Ride {
    Intersection start;
    Intersection end;
    long earliest;
    long latest;

    Ride(Scanner scanner) {
        start = new Intersection(scanner);
        end = new Intersection(scanner);
        earliest = scanner.nextLong();
        latest = scanner.nextLong();
    }
}