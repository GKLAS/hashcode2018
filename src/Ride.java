import java.util.Scanner;

class Ride implements Comparable<Ride> {
    final Intersection start;
    final Intersection end;
    final long earliest;
    final long latest;
    final int distance;
    final int id;

    Ride(Scanner scanner ,int id) {
        this.id = id;
        start = new Intersection(scanner);
        end = new Intersection(scanner);
        earliest = scanner.nextLong();
        latest = scanner.nextLong();
        distance =  Math.abs(end.x-start.x) + Math.abs(end.y-start.y);
    }

    @Override
    public int compareTo(Ride o) {
        return Long.compare(earliest, o.earliest);
    }
    
    
}