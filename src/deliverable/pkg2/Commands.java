package deliverable.pkg2;

import java.util.ArrayList;
/**
 *
 * @author Nicholas Treu
 */
public class Commands {

    // Keep track of all our valid commands in an ArrayList
    private final ArrayList<String> commands;
    
    public Commands(){
        // Instantiate the ArrrayList object and add the the valid commands to it.
        commands = new ArrayList<>();
        commands.add("N");
        commands.add("S");
        commands.add("L");
        commands.add("I");
        commands.add("H");
        commands.add("D");
    }
  
    // Returns true if "command" if in the commands ArrayList
    public boolean isValidCommand(String command){
        // NOTE: toUpperCase() should take care of the case insensitive requirement
        return commands.contains(command.toUpperCase());
    }
    
    // If a user enters an invalid command, print "What?" per the requirements
    public void printInvalidCommand(){
        System.out.println("What?");
    }
    
    public void printHelp(){
        System.out.println("A list of possible commands:");
        System.out.println("'N' : Used to move to the room that is North of your current room.");
        System.out.println("'S' : Used to move to the room that is South of your current room.");
        System.out.println("'L' : Used to look around the room if there any coffee ingredients in it.");
        System.out.println("'I' : Used to check the inventory of coffee ingredients a player currently has.");
        System.out.println("'H' : Used to display the this help menu.");
        System.out.println("'D' : Used to drink the current contents of your inventory.");
    }
    
    public void decideCommand(String command, Room room, Player player){
        
        int currentRoom = player.getCurrentRoom();
            
        // updateRoom() is written so that is will update the room appropiately.
        if(command.equalsIgnoreCase("N") || command.equalsIgnoreCase("S")){
            player.updateRoom(command, room);
        }
        else if(command.equalsIgnoreCase("L")){
            // Check to see if there is something in this room
            if(room.isItemInRoom(currentRoom)){
                System.out.println("There might be something here...");
                String item = room.getItemInRoom(currentRoom);
                System.out.println("You found some " + item + "! It has been added to your inventory.");
                player.addToInventory(item);
            }
            else {
                System.out.println("You don't see anything out of the ordinary.");
            }
        }
        else if(command.equalsIgnoreCase("I")){
            player.printInventory();
        }
        else if(command.equalsIgnoreCase("H")){
            printHelp();
        }
        else if(command.equalsIgnoreCase("D")){
            if(player.haveAllIngredients()){
                System.out.println("You have all the ingredients.");
                System.out.println("You mix them together and make a delicious coffee.");
                System.out.println("Congradulations! You have won the game!");
                System.exit(0);
            }
            else {
                System.out.println("You do not have all the ingredients.");
                System.out.println("You cannot make a coffee.");
                System.out.println("You lose.");
                System.exit(0);
            }
        }
    }
}