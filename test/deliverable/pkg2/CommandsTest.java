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
public class CommandsTest {
    
    Commands commands = new Commands();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
    public CommandsTest() {
    }
    
    @Before
    // This is used to set up PrintStreams to test print methods.
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    // This is used to clean up after we are done testing.
    public void cleanUpStreams(){
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    // This test is used so that we can test a valid command. 
    // "N" is tested here. It is a valid command.
    public void testIsValidCommandN() {      
        String validCommand = "N";
        assertTrue(commands.isValidCommand(validCommand));
    }
    
    @Test
    // This test is used so that we can test an invalid command/
    // "Z" is tested here and it is not a valid command.
    public void testIsInvalidCommands(){
        String invalidCommand = "Z";
        assertFalse(commands.isValidCommand(invalidCommand));
    }
    
    @Test
    // This test is used to that we can test another valid command.
    // "S" is tested here and it is a valid command.
    public void testIsValidCommandS(){
        String validCommand = "S";
        assertTrue(commands.isValidCommand(validCommand));
    }
    
    @Test
    // This test is used so that we can test what is printed out on an invalid
    // command. "What?" is suppose to be printed out. Testing if that is what is
    // printed to standard out.
    public void testPrintInvalidCommand() {
        // Flush out standard out first.
        System.out.flush();
        commands.printInvalidCommand();          
        assertEquals("What?", outContent.toString());
    }

    @Test
    // This is used to test the print help method. What is printed from that
    // method in the Commands class, should be the same as the String that is 
    // used here.
    public void testPrintHelp() {
        // Create the help String that is printed out.
        String helpString = "A list of possible commands:\n";
        helpString += "'N' : Used to move to the room that is North of your current room.\n";
        helpString += "'S' : Used to move to the room that is South of your current room.\n";
        helpString += "'L' : Used to look around the room if there any coffee ingredients in it.\n";
        helpString += "'I' : Used to check the inventory of coffee ingredients a player currently has.\n";
        helpString += "'H' : Used to display the this help menu.\n";
        helpString += "'D' : Used to drink the current contents of your inventory.\n";
        
        // Flush standard out
        System.out.flush();
        commands.printHelp();
        assertEquals(helpString, outContent.toString());
    }
}