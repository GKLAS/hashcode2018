import java.util.ArrayList;
import java.util.List;

class Car {
    final List<Integer> rides_id;
    private Intersection current;
    private long finishing_time;
    Car() {
        this.current = new Intersection();
        rides_id = new ArrayList<>();
    }

    void assign_ride(Ride ride) {

        this.finishing_time += manhattan_distance(ride.start, current);

        if(ride.earliest > this.finishing_time)
            this.finishing_time = ride.earliest;

        this.finishing_time += ride.distance ;

        this.current=ride.end;
        rides_id.add(ride.id);
    }

    int evaluate_ride(Ride ride, long T) {

    	int evaluation = 0;
    	if(ride.latest>T)
    	    return -1;
    	int curr_vs_start = manhattan_distance(current, ride.start);

    	if(curr_vs_start + ride.distance > ride.latest ) {
    		return -1;
    	}

    	//poso konta eimaste sthn arxi tou ride
        int LIMIT = 5;
        if (curr_vs_start <= LIMIT)
            evaluation += 2 * LIMIT - curr_vs_start;

        //oso makryteri diadromi toso kalytera
        evaluation += ride.distance;
    
    	
    	return evaluation;
    }

    private int manhattan_distance(Intersection start, Intersection end) {
    	return Math.abs(end.x-start.x) + Math.abs(end.y-start.y);
    }
}


