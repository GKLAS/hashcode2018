import java.util.Scanner;

class Intersection {
    private final int x;
    private final int y;

    Intersection(Scanner scanner) {
        x = scanner.nextInt();
        y = scanner.nextInt();
    }

    Intersection() {
        x = 0;
        y = 0;
    }

    int manhattanDistance(Intersection b) {
        return Math.abs(b.x - x) + Math.abs(b.y - y);
    }
}
