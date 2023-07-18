
package main;

/** DataType for the type of an aircraft
 *
 * @author adamb
 */
public enum AircraftType {
    PASSENGER("Passenger", 1),
    CARGO("Cargo", 2),
    UNDEFINED("Undefined", 5);
    
    //Variables
    private final String typeName;
    private final Integer typeId;
    
    //Constructor
    private AircraftType(String typeName, Integer typeId){
        this.typeName = typeName;
        this.typeId = typeId;
    }
    
    //Getters
    public String getTypeName(){
        return typeName;
    }
    
    public Integer getTypeId(){
        return typeId;
    }
    
    //Methods
    public static AircraftType getAircraftTypeById(Integer aircraftTypeId){
        if(aircraftTypeId != null){
            for(AircraftType type : AircraftType.values()){
                if(type.getTypeId().equals(aircraftTypeId)){
                    return type;
                }
            }
        }
        return UNDEFINED;
    }
}
