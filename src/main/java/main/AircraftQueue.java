
package main;

import java.util.*;

/** Object for the aircraft queue
 *
 * @author adamb
 */
public class AircraftQueue {
    
    //Variables
    private final TreeSet<Aircraft> queue = new TreeSet<>(comparator);
    
    //Methods
    public String add(Aircraft aircraft){
	if(aircraft.getAircraftId() != null){
            queue.add(aircraft);
            queue.comparator();
            return aircraft.toString() + " has been added to the queue.";
	}
	return "Aircraft was not added to the queue.";
    }
    
    public String remove(){
        //Remove the aircraft Id from the Id set
        Aircraft aircraftId = queue.first();
        aircraftId.removeAircraft(aircraftId.getAircraftId());
        
        //Remove the aircraft from the queue
	Aircraft aircraft = queue.pollFirst();
	return aircraft.toString() + " has been removed from queue.";
    }
    
    public Integer getSize(){
        return queue.size();
    }
    
    public void printQueue(){    
        Iterator<Aircraft> it = queue.iterator();
        System.out.println("Current airplane queue in order of removal:");
        while(it.hasNext()){
            System.out.print(it.next() + "\n");
        }
        System.out.println("-------------------------------------------------\n");
    }
    
    private final static Comparator<Aircraft> comparator = (Aircraft o1, Aircraft o2) -> {
        if(o2.getAircraftType().getTypeId() - o1.getAircraftType().getTypeId() != 0){
            return(o1.getAircraftType().getTypeId() - o2.getAircraftType().getTypeId());
        }
        
        if(o2.getAircraftSize().getSizeId() - o1.getAircraftSize().getSizeId() != 0){
            return(o1.getAircraftSize().getSizeId() - o2.getAircraftSize().getSizeId());
        }
        
        return 1;
    };
}
