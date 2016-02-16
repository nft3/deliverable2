package deliverable.pkg2;

import java.util.ArrayList;
/**
 *
 * @author Nicholas Treu
 */
public class Player {
    // Instance variables about someone who is playing this game
    public int currentRoom; 
    ArrayList<String> inventory;
    
    // Constructor
    public Player(){
        currentRoom = 0;
        inventory = new ArrayList<>();
    }
    
    public int getCurrentRoom(){
        return currentRoom;
    }
    
    // Input a direction and room that they are currently in.
    // Checks if that movement is valid or not before updating 
    public void updateRoom(String direction, Room room){       
        if(direction.equalsIgnoreCase("N") && room.doesNorthRoomExist(currentRoom)){
            currentRoom += 1;
        }
        else if(direction.equalsIgnoreCase("S") && room.doesSouthRoomExist(currentRoom)){
            currentRoom -= 1;
        }
        else {
            System.out.println("The room you are trying to reach does not exist. Please try to move a different direction.");
        }
    }
    
    // Adds and item that was picked up to the inventory.
    public void addToInventory(String item){
        inventory.add(item);
    }
    
    // Print the current contents of the inventory.
    public void printInventory(){             
        boolean coffee = false, sugar = false, cream = false;
        
        // Iterate over the inventory ArrayList.
        for(String str : inventory){
            // Determine if they have coffee in their inventory yet or not
            if(str.equalsIgnoreCase("Coffee")){
                System.out.println("You have COFFEE in your inventory.");
                coffee = true;
            }
            // Check if they have sugar in their inventory or not.
            else if(str.equalsIgnoreCase("Sugar")){
                System.out.println("You have SUGAR in your inventory.");
                sugar = true;
            }
            // Check if they have cream in their inventory yet or not.
            else if(str.equalsIgnoreCase("Cream")){
                System.out.println("You have CREAM in your inventory.");
                cream = true;
            }
        }
        
        // If a boolean flag is still false, we don't have it.
        if(!coffee){
            System.out.println("You do not have COFFEE in your inventory.");
        }
        if(!sugar){
            System.out.println("You do not have SUGAR in your inventory.");
        }
        if(!cream){
            System.out.println("You do not have CREAM in your inventory.");
        }     
    }
    
    public boolean haveAllIngredients(){
        return inventory.contains("Coffee") && inventory.contains("Sugar") &&
                inventory.contains("Cream");
    }
}
