import java.util.Scanner;

class Ride implements Comparable<Ride> {
    final Intersection start;
    final Intersection finish;
    final long earliest;
    final long latest;
    final int distance;
    private final int id;

    Ride(Scanner scanner, int id) {
        this.id = id;
        start = new Intersection(scanner);
        finish = new Intersection(scanner);
        earliest = scanner.nextLong();
        latest = scanner.nextLong();
        distance = start.manhattanDistance(finish);
    }

    public boolean isValid(long t) {
        return latest <= t && earliest + distance <= latest;
    }

    /*
    @Override
    public int compareTo(Ride o) {
        return Long.compare(earliest, o.earliest);
    }
    */
    @Override
    public int compareTo(Ride o) {
        if (earliest == o.earliest)
            return Integer.compare(o.distance, distance);
        else if (earliest < o.earliest)
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}