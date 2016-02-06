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
        commands = new ArrayList<String>();
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
        System.out.println("'I' : Used to check the current inventory of coffee ingredients a player has.");
        System.out.println("'H' : Used to display the this help menu.");
        System.out.println("'D' : Used to drink the current contents of your inventory.");
        System.out.println("");
    }
}