import java.util.Scanner;

class Ride implements Comparable<Ride> {
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

    @Override
    public int compareTo(Ride o) {
        return Long.compare(o.earliest, earliest);
    }
}