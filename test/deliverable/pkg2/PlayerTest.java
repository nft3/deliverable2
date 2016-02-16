package deliverable.pkg2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nicholas Treu
 */
public class PlayerTest {
    
    Player player = new Player();
    Room room = new Room();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
    // There is no need to create an instance of this class.
    public PlayerTest() {
    }
    
    @Before
    // Set up a print stream for standard out to test print statements
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    // Clean up the print streams used to test printing out.
    public void cleanUpStreams(){
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    // This test is used to check that to start off, the player is in room at 
    // index 0.
    public void testGetCurrentRoom() {
        int startingValue = 0; // This is the correct value
        assertEquals(startingValue, player.getCurrentRoom());
    }
    
    @Test
    // This will test if we are in a valid room, such as index 3.
    public void testGetCurrentRoomN(){
        player.currentRoom = 3;
        assertEquals(3, player.getCurrentRoom());
    }
    
   
    @Test
    // This will test the value of currentRoom after an update North is done.
    public void testUpdateRoomNorth() {
        String validCommandN = "N";
   
        // After this command the value shold be 1.
        player.updateRoom(validCommandN, room);
        assertEquals(player.getCurrentRoom(), 1);
    }
    
    @Test
    // This will test the value of currentRoom after an update South is done.
    public void testUpdateRoomSouth(){
        String validCommandS = "S";
        
        // After this the command value should be 0.
        player.updateRoom(validCommandS, room);
        assertEquals(player.getCurrentRoom(), 0);
    }
    
    @Test 
    // This will test the value of currentRoom if an invalid command is entered
    public void testUpdateRoomInvalid(){
        String invalidCommand = "P";
        // After this invalid command the value should still be 0.
        player.updateRoom(invalidCommand, room);
        assertEquals(player.getCurrentRoom(), 0);
    }
    
    @Test
    // This will test if you can move south from currentRoom = 0. This is an
    // invalid move and should print the an appropiate output String. Testing
    // if it does do that.
    public void testUpdateRoomOutOfBounds(){
        String invalidString = "The room you are trying to reach does not exist. "
                + "Please try to move a different direction.";
        
        System.out.flush();
        player.updateRoom(invalidString, room);
        assertEquals(invalidString, outContent.toString());
    }

    @Test
    // Test if an item is added to the inventory. Do this by adding a String
    // and then testing if the size of the ArrayList is 1 after an item was added to it.
    public void testAddToInventory() {
        String someItem = "This is an item string";
        player.addToInventory(someItem);
        
        // After we add an item to the inventory, the size should be 1.
        assertEquals(player.inventory.size(), 1);
    }

    @Test
    // Test if once Cream, Coffee and Sugar are added to the inventory, the appropiate
    // String is printed out. Make a fresh object to test out adding things to inventory.
    public void testPrintInventory() {
        Player player0 = new Player();
        
        player0.addToInventory("Cream");
        player0.addToInventory("Coffee");
        player0.addToInventory("Sugar");
        
        System.out.flush();
        String tempString = "You have COFFEE in your inventory.\n";
        tempString += "You have CREAM in your inventory.\n";
        tempString += "You have SUGAR in your inventory.\n";
        
        player0.printInventory();
        assertEquals(tempString, outContent.toString());
    }

    @Test
    // Test if we have "Coffee", "Sugar" and "Cream" then print out true.
    // Make a fresh object to test.
    public void testHaveAllIngredients() {
        Player player1 = new Player();
        
        player1.addToInventory("Cream");
        player1.addToInventory("Coffee");
        player1.addToInventory("Sugar");
        
        assertTrue(player1.haveAllIngredients());
    }
    
    @Test
    // Test if we don't have any of "Coffee", "Sugar" or "Cream"
    // Make a fresh object to test
    public void testHaveNoIngredients(){
        Player player2 = new Player();
        
        assertFalse(player2.haveAllIngredients());
    }
}
