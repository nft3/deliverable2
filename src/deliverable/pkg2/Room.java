package deliverable.pkg2;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Nicholas Treu
 */
public class Room {

    // Instance variables for attributes of a room
    private final ArrayList<String> roomList;
    private final Map<String, String> furniture;
    private final Map<String, String> items;
    
    // Constructor
    public Room() {
        // Instantiate the current room value to 0 to start.
               
        // Add some adjectives to describe the room to roomList.
        roomList = new ArrayList<>();
        roomList.add("Pleasant");
        roomList.add("Effulgent");
        roomList.add("Histrionic");
        roomList.add("Limpid");
        roomList.add("Meretricious");
        roomList.add("Zealous");
        
        // Map the rooms to an piece of furnature.
        furniture = new HashMap<String, String>(); 
        furniture.put(roomList.get(0), "Sofa");
        furniture.put(roomList.get(1), "Closet");
        furniture.put(roomList.get(2), "Table");
        furniture.put(roomList.get(3), "Chair");
        furniture.put(roomList.get(4), "Bean Bag");
        furniture.put(roomList.get(5), "Bed");
        
        // Map three rooms containing coffee, cream and sugar.
        // Just hardcode three rooms for simplicity.
        items = new HashMap<String, String>();
        items.put(roomList.get(1), "Coffee");
        items.put(roomList.get(3), "Cream");
        items.put(roomList.get(5), "Sugar");
    }
      
    // Check to see if the adjective that describes a room is in our
    // adjective list
    public boolean doesRoomExist(String str){
        return roomList.contains(str);
    }
    
    // Returns true if a North room exists
    public boolean doesNorthRoomExist(int currentRoom){
        return roomList.contains(roomList.get(currentRoom + 1));
    }
    
    // Returns true if a South room exists
    public boolean doesSouthRoomExist(int currentRoom){
        return roomList.contains(roomList.get(currentRoom - 1));
    }
    
    // Prints out to the user what room they are in.
    public void printRoomString(int currentRoom){
        System.out.println("You are in the " + roomList.get(currentRoom) + " room.");
    }
    
    // Returns true if there is an item in the room
    public boolean isItemInRoom(int currentRoom){
        return items.containsKey(roomList.get(currentRoom));       
    }
    
    // Returns the String of the item in the room, if it exists.
    public String getItemInRoom(int currentRoom){
        if(isItemInRoom(currentRoom)){
            return items.get(roomList.get(currentRoom));
        }
        
        return null;
    }
    
    // Print out to the user if there is an item in the room or not.   
    public void printItemString(int currentRoom){
        if(items.containsKey(roomList.get(currentRoom))){
            System.out.println("You found " + items.get(currentRoom) + "!");
        }
        else {
            System.out.println("You found nothing out of the ordinary in this room.");
        }
    }
    
    // Print out to the user the furniture of the current room that we are in.
    public void printFurnitureString(int currentRoom){
        System.out.println("This room contains a " + furniture.get(currentRoom));
    }
}