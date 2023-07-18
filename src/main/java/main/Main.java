
package main;

import java.util.*;

/** Main class for the air-traffic control system
 *
 * @author adamb
 */
public class Main {
    
    private static boolean systemRunning = false;
    private static AircraftQueue aircraftQueue = new AircraftQueue();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        aqm_request_process();
    }
    
    private static void aqm_request_process(){
        Scanner input = new Scanner(System.in);
        startMessage();
        
        Integer selection = -1;
        while(selection != 0){
            if(!systemRunning){
                //Start the system or quit
                if(input.hasNextInt()){
                    selection = input.nextInt();
                    
                    switch(selection){
                        case 0 -> quit();
                        case 1 -> selection = 1;
                        default -> {
                                System.out.println("Selection not recognized, please enter a valid number.\n");
                                input.nextLine();
                                startMessage();
                        }
                    }
                }else{
                    System.out.println("Selection not recognized, please enter a valid number.\n");
                    input.nextLine();
                    startMessage();
                }
            }
            
            //System has been started
            if(selection == 1 && !systemRunning){
                systemRunning = true;
                runningMessage();
            }
            
            //System is active and awaiting user input
            if(systemRunning){
                commandMessage();
                
                if(input.hasNextInt()){
                    selection = input.nextInt();
                    
                    switch(selection){
                        case 0 -> quit();
                        case 1 -> createNew(input);
                        case 2 -> remove();
                        case 3 -> viewQueue();
                        default -> {
                                System.out.println("Selection not recognized, please enter a valid number.\n");
                                input.nextLine();
                        }
                    }
                }else{
                    System.out.println("Selection not recognized, please enter a valid number.\n");
                    input.nextLine();
                }
            }
        }
    }
    
    //Create a new aircraft and add it to the queue
    private static void createNew(Scanner scanner){
        //Variables
        String type = "";
        String size = "";
        String id = "";
        
        /*Beginning of main block of code*/
        System.out.println("Please enter the new aircraft ID #:");
        
        while(id.isBlank()){
        	if(scanner.hasNextLine()){
            	id = scanner.nextLine().trim();
            }
        }
        
        //Select a type
        typeMessage();
        while(type.isBlank()) {
        	if(scanner.hasNextLine()) {
        		if(scanner.hasNextInt()){
        			type = scanner.nextLine().trim();
        		}else{
	                System.out.println(scanner.nextLine() + " is not recognized Type. Setting Type as Undefined");
	                type = "5";
	            }
        	}
        }
        
        //Select a size
        sizeMessage();
        while(size.isBlank()) {
        	if(scanner.hasNextInt()){
                size = scanner.nextLine().trim();
            }else{
                System.out.println(scanner.nextLine() + " is not a recognized Size. Setting Size as Undefined");
                size = "5";
            }
        }
    	
        //Add the aircraft to the queue
        Aircraft newAircraft = new Aircraft(id, type, size);
        System.out.println(aircraftQueue.add(newAircraft));
        System.out.println("""
                           --------------------------------------------------
                           """);
    }
    
    //Remove the next aircraft in the queue
    private static void remove(){
        if(aircraftQueue.getSize() == 0){
            System.out.println("""
                               There are no planes in the queue.
                               --------------------------------------------------
                               """);
        }else{
            System.out.println(aircraftQueue.remove());
            System.out.println("""
                               --------------------------------------------------
                               """);
        }
    }
    
    //View the queue in order of their priority
    private static void viewQueue(){
        if(aircraftQueue.getSize() == 0){
            System.out.println("""
                               There are no planes in the queue.
                               --------------------------------------------------
                               """);
        }else{
            aircraftQueue.printQueue();
        }
    }
    
    //List acceptable user inputs on the main menu
    private static void commandMessage(){
        System.out.println("""
                           Please select one of the following options: 
                            0 - Quit 
                            1 - Add a new Aircraft to the queue
                            2 - Remove the next Aircraft from the queue
                            3 - View the Aircraft currently in the queue
                           --------------------------------------------------
                           """);
    }
    
    //Display acceptable user inputs on start menu
    private static void startMessage(){
        System.out.println("""
                           Hello, please select one of the following options: 
                            0 - Quit 
                            1 - Start 
                           --------------------------------------------------
                           """);
    }
    
    //Display message upon start up
    private static void runningMessage(){
        System.out.println("""
                           The system has started successfully.
                           --------------------------------------------------
                           """);
    }
    
    //Display message for size options
    private static void sizeMessage(){
        System.out.println("""
                           Select a size:
                            1 - Large
                            2 - Small
                           --------------------------------------------------
                           """);
    }
    
    //Display message for type options
    private static void typeMessage(){
        System.out.println("""
                           Select a type:
                            1 - Passenger
                            2 - Cargo 
                           --------------------------------------------------
                           """);
    }
    
    //Display message upon quitting
    private static void quit(){
        System.out.println("System is shutting down, Thank you and Goodbye!");
    }
}
