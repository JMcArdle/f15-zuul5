
/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 * 
 * This class creates and populates all of the rooms in the game.
 * 
 * @author Scott Taylor
 * @version 10/28/2015
 */
public class RoomCreator
{

    /**
     * Constructor for objects of class RoomCreator
     */
    public RoomCreator()
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
        outside = new Room("outside the main entrance of the university");
        room2 = new Room("a second room");

        // initialise room exits like this
        outside.addExit("east", room2);
        
        
        //return whatever room they start in
        return outside;
    }
}
