
package main;

import java.util.*;

/** Aircraft object
 *
 * @author adamb
 */
public class Aircraft implements Comparable<Aircraft>{
    //Variables
    private String aircraftId;
    private AircraftType aircraftType;
    private AircraftSize aircraftSize;
    
    private final static Set<String> idSet = new HashSet<>();
    
    //Constructor
    public Aircraft(String aircraftId, String aircraftType, String aircraftSize){
        if(idSet.add(aircraftId)){
            this.aircraftId = aircraftId;
            this.aircraftSize = AircraftSize.getAircraftSizeById(Integer.parseInt(aircraftSize));
            this.aircraftType = AircraftType.getAircraftTypeById(Integer.parseInt(aircraftType));
        }else{
            System.out.println("Aircraft with Id " + aircraftId + " already exists, cannot create an aircraft with a duplicate Id.");
        }
    }
    
    //Getters and Setters
    public String getAircraftId(){
        return aircraftId;   
    }
    
    public AircraftType getAircraftType(){
        return aircraftType;
    }
    
    public AircraftSize getAircraftSize(){
        return aircraftSize;
    }
    
    public final void setAircraftId(String aircraftId){
        if(idSet.add(aircraftId)){
            this.aircraftId = aircraftId;
        }else{
            System.out.println("Aircraft ID already exists, cannot create duplicate.");
        }
    }
    
    public final void setAircraftSize(AircraftSize aircraftSize){
        this.aircraftSize = aircraftSize;
    }
    
    //Overloading setSize with String param
    public final void setAircraftSize(String aircraftSize){
        this.aircraftSize = AircraftSize.getAircraftSizeById(Integer.parseInt(aircraftSize));
    }
    
    public final void setAircraftType(AircraftType aircraftType){
        this.aircraftType = aircraftType;
    }
    
    //Overloading setType with String param
    public final void setAircraftType(String aircraftType){
        this.aircraftType = AircraftType.getAircraftTypeById(Integer.parseInt(aircraftType));
    }
    
    public Set<String> getIds(){
        return idSet;
    }
    
    public void removeAircraft(String aircraftId){
        idSet.remove(aircraftId);
    }
    
    @Override
    public String toString(){
        return "Aircraft - [Id: " + aircraftId + ", Size: " + aircraftSize.getSizeName() + ", Type: " + aircraftType.getTypeName() + "]";
    }

    @Override
    public int compareTo(Aircraft o){
        if(aircraftId.equals(o.getAircraftId())){
            return 0;
        }else if(aircraftId.compareTo(o.getAircraftId()) < 0){
            return -1;
        }else{
            return 1;
        }
    }
}
