
package main;

/** DataType for the size of an aircraft
 *
 * @author adamb
 */
public enum AircraftSize {
    LARGE("Large", 1),
    SMALL("Small", 2),
    UNDEFINED("Undefined", 5);
    
    //Variables
    private final String sizeName;
    private final Integer sizeId;
    
    //Constructor
    private AircraftSize(String sizeName, Integer sizeId){
        this.sizeName=sizeName;
        this.sizeId=sizeId;
    }
    
    //Getters
    public String getSizeName(){
        return sizeName;
    }
    
    public Integer getSizeId(){
        return sizeId;
    }
    
    //Methods
    public static AircraftSize getAircraftSizeById(Integer aircraftSizeId){
        if(aircraftSizeId != null){
            for(AircraftSize size : AircraftSize.values()){
                if(size.getSizeId().equals(aircraftSizeId)){
                    return size;
                }
            }
        }
        return UNDEFINED;
    }
}
