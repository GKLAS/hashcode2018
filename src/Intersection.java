import java.util.Scanner;

class Intersection {
    int x;
    int y;

    Intersection(Scanner scanner) {
        x = scanner.nextInt();
        y = scanner.nextInt();
    }

    Intersection() {
        x = 0;
        y = 0;
    }
    
    boolean equals(Intersection i) {
    	if(x==i.x && y==i.y)
    		return true;
    	return false;
    }
}
