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
public class RoomTest {
    
    Room room = new Room();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
     // There is no need to create an instance of this class.
    public RoomTest() {
    }
    
    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    public void cleanUpStreams(){
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    // "Bulky is a room and it should exist and return true.
    public void testDoesRoomExist() {
        assertTrue(room.doesRoomExist("Bulky"));
    }
    
    @Test
    // "sfskdljfsd" is not a room ad it should not exist and return false
    public void testDoesRoomExistFalse(){
        assertFalse(room.doesRoomExist("sfskdljfsd"));
    }

    @Test
    // From room of index 1 there should be a north room and return true
    public void testDoesNorthRoomExist() {
        assertTrue(room.doesNorthRoomExist(1));
    }
    
    @Test
    // A room North of index 5 should not exist. It should return false.
    public void testDoesNorthRoomExistsInvalid(){
        assertFalse(room.doesNorthRoomExist(5));
    }

    @Test
    // If we are in room index 0 there should not be a south room and return false.
    public void testDoesSouthRoomExistInvalid() {
        assertFalse(room.doesSouthRoomExist(0));
    }
    
    @Test
    // If we are at the room at index 4, we should be able to move to a south room.
    // This should return true.
    public void testDoesSouthRoomExist(){
        assertTrue(room.doesSouthRoomExist(4));
    }

    @Test
    // This will test printing a room string if the room begins with a consonant.
    // The room at index 0 does begin with a consonant and should have "a" instead
    // of "an".
    public void testPrintRoomStringConsonant() {
        String tempString = "You see a Pleasant room.";
        System.out.flush();
        room.printRoomString(0);
        assertEquals(tempString, outContent.toString());
    }
    
    @Test
    // This will test printing a room string if the room begins with a vowel.
    // The room at index 1 does begin with a vowel and should have "an" instead
    // of "a".
    public void testPrintRoomStringVowel(){
        String tempString = "You see an Effulgent room.";
        System.out.flush();
        room.printRoomString(1);
        assertEquals(tempString, outContent.toString());
    }

    @Test
    // This will test printing from a room that does not have a door leading south
    // but has a door that only leads north. This is only the case in room index 0.
    public void testPrintDoorsNorthOnly() {
        String tempString = "A Tiny Tiny door leads North.";
        System.out.flush();
        room.printDoors(0);
        assertEquals(tempString, outContent.toString());
    }
    
    @Test
    // This will test printing from a room that does not have a door leading north
    // but has a door that only leads south. This is only the case in room index 5.
    public void testPrintDoorsSouthOnly() {
        String tempString = "An Eloquent door leads south.";
        System.out.flush();
        room.printDoors(5);
        assertEquals(tempString, outContent.toString());
    }
    
    @Test
    // This will test printing from a room that both has a door that leads north and
    // south. This will also test that printing out the correct usage of "an" and "a"
    // when it is appropiate.
    public void testPrintDoorsBothNorthAndSouth(){
        String tempString = "A Massive door leads North.\n";
        tempString += "An Teeny Tiny door leads South.";
        System.out.flush();
        room.printDoors(2);
        assertEquals(tempString, outContent.toString());
    }

    @Test
    // There is an item in room index three and therefore should return true
    public void testIsItemInRoom() {
        assertTrue(room.isItemInRoom(3));
    }

    @Test
    // There is "Cream" in room index three, check to see if it returns that. 
    public void testGetItemInRoom() {
        assertEquals("Cream", room.getItemInRoom(3));
    }

    @Test
    // Test for the printed String for the item in room index 3.
    public void testPrintItemString() {
        assertEquals("Cream", room.getItemInRoom(3));
    }

    @Test
    // Test for the printed String of the furniture in room index 3.
    public void testPrintFurnitureString() {
        System.out.flush();
        String testString = "It has a Chair in it.";
        room.printFurnitureString(3);
        assertEquals(testString, outContent.toString());
    }
}