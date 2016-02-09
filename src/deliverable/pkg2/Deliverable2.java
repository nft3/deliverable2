package deliverable.pkg2;

import java.util.Scanner;
/**
 *
 * @author Nicholas Treu
 */
public class Deliverable2 {
        
    public static void main(String[] args) {
        // Print a welcome message
        System.out.println("Welcome to Coffee Maker Quest 1.1!");
       
        // Create Room, Commands and Player objects
        // Also create a Scanner object for player input
        Room room = new Room();
        Commands commands = new Commands();
        Player player = new Player();
        Scanner in = new Scanner(System.in);
        String nextCommand;
        
        while(true) {
            // Print out what room you are in, furnature description and what
            // door leaves out of the room.
            System.out.println("");
            room.printRoomString(player.getCurrentRoom());
            room.printFurnitureString(player.getCurrentRoom());
            room.printDoors(player.getCurrentRoom());
            
            // Prompt the user to enter and instruction and read it in via stdin.
            System.out.println("");
            System.out.println(" INSTRUCTIONS (N,S,L,I,H,D) > ");
            nextCommand = in.nextLine();
                     
            // Now, we will decide what will happen on each case of the
            if(commands.isValidCommand(nextCommand.trim())){
                commands.decideCommand(nextCommand.trim(), room, player);
            }
            // If the value entered is not one of the specified commands, print the specified error message.
            else{
                commands.printInvalidCommand();
            }
        }
    }
}
