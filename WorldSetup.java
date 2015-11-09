import java.util.ArrayList;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 * 
 * This class creates and populates all of the rooms in the game.
 * 
 * @author Scott Taylor
 * @version 10/28/2015
 */
public class WorldSetup
{
    private ArrayList<Room> allRooms;

    /**
     * Constructor for objects of class RoomCreator
     */
    public WorldSetup()
    {
    }
    
    /**
     * creates all the npcs
     */
    public void createNPCS()
    {
    }
    
    /**
     * create all the items
     */
    public void createItems()
    {
    }

    /**
     * Creates all the rooms
     */
    public Room makeRooms()
    {
        //declare all the rooms on this line
        Room outside, room2, room3, roomEtc;

        // create the rooms like this
        outside = new Room("outside","outside the main entrance of the university");
        room2 = new Room("room 2","a second room");

        // initialise room exits like this
        outside.addExit("east", room2);
        
        
        
        //then add the rooms to the master list of all the rooms
        allRooms.add(outside);
        allRooms.add(room2);
        
        
        //add all items to their rooms here
        //roomName.addItem(item);
        
        //all npcs to their rooms here
        //roomName.addNPC(npc);
        
        //return whatever room they start in
        return outside;
    }
    
    
    /**
     * passes back all the rooms created in a list
     * so they can be accessed by the command processor
     */
    public ArrayList<Room> getRoomList()
    {
        return allRooms;
    }
}
