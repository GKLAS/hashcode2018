import java.util.ArrayList;
import java.util.List;

class Car {
	static final int LIMIT = 5;
    Intersection current;
    Ride ride;
    int finishing_time;
    List<Integer> rides_id ;
    Car() {
        this.current = new Intersection();
        rides_id = new ArrayList<>();
    }

    int assign_ride(Ride ride, int current) {
        this.ride = ride;
        this.finishing_time = ride.distance + current;
        this.current=ride.end;
        rides_id.add(ride.id);
    }
    
    int evaluate_ride(Ride ride,int curtime) {
        if(curtime <= finishing_time)
            return -1;
    	int evaluation = 0;
    	int curr_vs_start = manhattan_distance(current, ride.start);
    	if(curr_vs_start + ride.distance > ride.latest ) {
    		return -1;
    	}
    	
    	//poso konta eimaste sthn arxi tou ride
    	if(curr_vs_start <= LIMIT)
    		evaluation += 2*LIMIT-curr_vs_start;
    	
    	//oso makryteri diadromi toso kalytera
    	evaluation += ride.distance;
    
    	
    	return evaluation;
    }
    
    int manhattan_distance(Intersection start,Intersection end) {
    	return Math.abs(end.x-start.x) + Math.abs(end.y-start.y);
    }
}


