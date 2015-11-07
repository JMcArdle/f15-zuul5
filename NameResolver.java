import java.util.ArrayList;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 *  
 *  This class resolves strings into objects
 * 
 * @author Scott Taylor 
 * @version 11/6/2015
 */
public class NameResolver
{
    Player player;
    Room currentRoom;
    ArrayList<Room> allRooms;
    
    /**
     * Constructor for objects of class NameResolver
     */
    public NameResolver(Room currentRoom, Player player, ArrayList<Room> allRooms)
    {
        this.currentRoom = currentRoom;
        this.player = player;
        this.allRooms = allRooms;
    }
    
    /**
     * finds a room based on its name
     */
    public Room resolveRoom(String target)
    {
        Room found = null;
        for(Room room : allRooms)
        {
            if (room.getName().equalsIgnoreCase(target))
            {
                found = room;
            }
        }
        return found;
    }
    
    
    ///NPCs///
    
    /**
     * finds an npc in the room based on name
     */
    public NPC resolveNPCFromCurrentRoom(String target)
    {
        NPC found = null;
        for(NPC npc : currentRoom.getNPCS())
        {
            if (npc.getName().equalsIgnoreCase(target))
            {
                found = npc;
            }
        }
        return found;
    }
    
    /**
     * finds an npc in the entire map based on name
     */
    public NPC resolveNPCFromGlobal(String target)
    {
        NPC found = null;
        for(Room room : allRooms)
        {
            for(NPC npc : room.getNPCS())
            {
                if (npc.getName().equalsIgnoreCase(target))
                {
                    found = npc;
                }
            }
        }
        return found;
    }
    
    
    ///Items///
    
    /**
     * finds item in inventory based on name
     */
    public Item resolveItemFromInventory(String target)
    {
        Item found = null;
        for(Item item : player.getInventory())
        {
            if (item.getName().equalsIgnoreCase(target))
            {
                found = item;
            }
        }
        return found;
    }
    
    /**
     * finds an item in the room based on name
     */
    public Item resolveItemFromCurrentRoom(String target)
    {
        Item found = null;
        for(Item item : currentRoom.getItems())
        {
            if (item.getName().equalsIgnoreCase(target))
            {
                found = item;
            }
        }
        return found;
    }
    
    /**
     * finds an item in the entire map based on name
     */
    public Item resolveItemFromGlobal(String target)
    {
        Item found = null;
        for(Room room : allRooms)
        {
            for(Item item : room.getItems())
            {
                if (item.getName().equalsIgnoreCase(target))
                {
                    found = item;
                }
            }
        }
        return found;
    }

}
