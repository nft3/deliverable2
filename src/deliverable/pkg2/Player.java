package deliverable.pkg2;

import java.util.ArrayList;
/**
 *
 * @author Nicholas Treu
 */
public class Player {
    // Instance variables about someone who is playing this game
    static int currentRoom; 
    ArrayList<String> inventory;
    
    // Constructor
    public Player(){
        currentRoom = 0;
        inventory = new ArrayList<String>();
    }
    
    public void updateRoom(String movement, Room room){
        if(movement.equalsIgnoreCase("N") && room.doesNorthRoomExist(currentRoom)){
            currentRoom += 1;
        }
        else if(movement.equalsIgnoreCase("S") && room.doesSouthRoomExist(currentRoom)){
            currentRoom -= 1;
        }
    }
    
    public void addToInventory(){
        
    }
}
