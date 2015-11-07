import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Scott Taylor
 * @version 11/4/2015
 */

public class Room 
{
    
    ///fields///
    private String name;
    private String description;
    private String extraDescription;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<NPC> npcs;
    private ArrayList<Item> items;

    
    ///constructor///
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String name, String description) 
    {
        this.name = name;
        this.description = description;
        extraDescription = "You see nothing of importance.";
        exits = new HashMap<String, Room>();
        npcs = new ArrayList<NPC>();
        items = new ArrayList<Item>();
    }
    
    
    ///methods///
    
    //setters//
    
    /**
     * Change the name of the room
     * @param name the new name
     */
    public void setName(String name)
    {
        this.name = name;
    }
        
    /**
     * Reset the description of the room
     * @param descriptioin the new description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * Change the extra description when the player looks around
     * @param description the extra text to put in
     */
    public void setExtraDescription(String description)
    {
        extraDescription = description;
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void addExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Remove an exit from this room
     * @param del the exit to delete
     */
    public void removeExit(String rem)
    {
        exits.remove(rem);
    }
    
    
    /**
     * add npc to the room
     * @param npc new npc to add
     */
    public void addNPC(NPC npc)
    {
        npcs.add(npc);
    }
    
    /**
     * remove npc from the room
     * @param rem npc to remove
     */
    public void removeNPC(NPC rem)
    {
        npcs.remove(rem);
    }
    
    /**
     * add item to the room
     * @param item new item to add
     */
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    /**
     * remove item from the room
     * @param rem item to remove
     */
    public void removeItem(Item rem)
    {
        items.remove(rem);
    }
    
    
    //getters//
    
    
    /**
     * returns the name of the room
     * 
     * @return name of the room
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * returns the description of the room
     * 
     * @return The short description of the room
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * returns the extra desctiption of the room
     * 
     * @return the extra info when looking around
     */
    public String getExtraDescription()
    {
        return extraDescription;
    }
    
    /**
     * returns the list of NPCs in the room
     * @return the NPC list
     */
    public ArrayList<NPC> getNPCS()
    {
        return npcs;
    }
    
    /**
     * returns the list of items in the room
     * @return the item list
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    
}

