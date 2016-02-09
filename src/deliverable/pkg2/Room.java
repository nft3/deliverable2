package deliverable.pkg2;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Nicholas Treu
 */
public class Room {

    // Instance variables for attributes of a room
    private final ArrayList<String> roomList;
    private final ArrayList<String> doorAdjectives;
    private final Map<String, String> furniture;
    private final Map<String, String> items;
    
    // Constructor
    public Room() {
        // Add some adjectives to describe the room to roomList.
        roomList = new ArrayList<>();
        roomList.add("Pleasant");
        roomList.add("Effulgent");
        roomList.add("Histrionic");
        roomList.add("Limpid");
        roomList.add("Meretricious");
        roomList.add("Zealous");
        
        // Add some door adjectives.
        doorAdjectives = new ArrayList<>();
        doorAdjectives.add("Bulky");
        doorAdjectives.add("Teeny Tiny");
        doorAdjectives.add("Aqua");
        doorAdjectives.add("Massive");
        doorAdjectives.add("Eloquent");
        doorAdjectives.add("Intimidating");
        
        // Map the rooms to an piece of furnature.
        furniture = new HashMap<>(); 
        furniture.put(roomList.get(0), "Sofa");
        furniture.put(roomList.get(1), "Closet");
        furniture.put(roomList.get(2), "Table");
        furniture.put(roomList.get(3), "Chair");
        furniture.put(roomList.get(4), "Bean Bag");
        furniture.put(roomList.get(5), "Bed");
        
        // Map three rooms containing coffee, cream and sugar.
        // Just hardcode three rooms for simplicity.
        items = new HashMap<>();
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
        try{
            return roomList.contains(roomList.get(currentRoom + 1));
        } catch(IndexOutOfBoundsException e){
            return false;
        }
    }
    
    // Returns true if a South room exists
    public boolean doesSouthRoomExist(int currentRoom){
        try{
            return roomList.contains(roomList.get(currentRoom - 1));
        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    
    // Prints out to the user what room they are in.
    public void printRoomString(int currentRoom){
        // Proper use of 'a' and 'an' if an adjective begins with a vowel or not/
        Set<Character> vowelList = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        if(vowelList.contains(Character.toLowerCase(roomList.get(currentRoom).charAt(0)))){
            System.out.println("You see an " + roomList.get(currentRoom) + " room.");
        } else {
            System.out.println("You see a " + roomList.get(currentRoom) + " room.");
        }
    }
    
    public void printDoors(int currentRoom){
         // Proper use of 'a' and 'an' if an adjective begins with a vowel or not/
        Set<Character> vowelList = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        if(doesNorthRoomExist(currentRoom)){
            if(vowelList.contains(Character.toLowerCase(doorAdjectives.get(currentRoom + 1).charAt(0)))){
                System.out.println("An " + doorAdjectives.get(currentRoom + 1) + " door leads North.");
            } else {
                System.out.println("A " + doorAdjectives.get(currentRoom + 1) + " door leads North.");
            }
        }
        if(doesSouthRoomExist(currentRoom)){
            if(vowelList.contains(Character.toLowerCase(doorAdjectives.get(currentRoom - 1).charAt(0)))){
                System.out.println("An " + doorAdjectives.get(currentRoom - 1) + " door leads South.");
            }
            else{
                System.out.println("A " + doorAdjectives.get(currentRoom - 1) + " door leads South.");
            }
        }
    }
    
    // Returns true if there is an item in the room
    public boolean isItemInRoom(int currentRoom){
        return items.containsKey(roomList.get(currentRoom));       
    }
    
    // Returns the String of the item in the room, if it exists.
    // If it is not in the room, return null.
    public String getItemInRoom(int currentRoom){
        return items.get(roomList.get(currentRoom));
        
    }
    
    // Print out to the user if there is an item in the room or not.   
    public void printItemString(int currentRoom){
        if(isItemInRoom(currentRoom)){
            System.out.println("You found " + getItemInRoom(currentRoom) + "!");
        }
        else {
            System.out.println("You found nothing out of the ordinary in this room.");
        }
    }
    
    // Print out to the user the furniture of the current room that we are in.
    public void printFurnitureString(int currentRoom){
        System.out.println("It has a " + furniture.get(roomList.get(currentRoom)) + " in it.");
    }
}