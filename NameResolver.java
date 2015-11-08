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
     * finds item if it's equipped
     */
    public Item resolveItemFromEquip(String target)
    {
        Item found = null;
        if(player.getEquipped().getName().equalsIgnoreCase(target))
        {
            found = player.getEquipped();
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

    
    
    
    //methods to find the location of NPCs and objects//
    
    
    /**
     * finds what room an NPC is in
     * 
     * @param target the NPC to look for
     * @return Room what room they are in
     */
    public Room findNPC(NPC target)
    {
        Room in = null;
        breaker:for(Room room : allRooms)
        {
            for(NPC npc : room.getNPCS())
            {
                if(npc == target)
                {
                    in = room;
                    break breaker;
                }
            }
        }
        return in;
    }
    
    
    /**
     * finds what room an NPC is in given a string
     * 
     * @param target the string of the npc name to look for
     * @return Room what room they are in
     */
    public Room findNPC(String target)
    {
        NPC npc = resolveNPCFromCurrentRoom(target);
        if (npc == null)
        {
            npc = resolveNPCFromGlobal(target);
        }
        Room in = null;
        if (npc != null)
        {
            breaker:for(Room room : allRooms)
            {
                for(NPC search : room.getNPCS())
                {
                    if(search.getName() == target)
                    {
                        in = room;
                        break breaker;
                    }
                }
            }
        }
        return in;
    }
    
    
    
    /**
     * finds what room an item is in
     * 
     * @param target the item to look for
     * @return Room what room it is in
     */
    public Room findItem(Item target)
    {
        Room in = null;
        breaker:for(Room room : allRooms)
        {
            for(Item item : room.getItems())
            {
                if(item == target)
                {
                    in = room;
                    break breaker;
                }
            }
        }
        return in;
    }
    
    /**
     * finds what room an item is in given a string
     * 
     * @param target the string of the item name to look for
     * @return Room what room it is in
     */
    public Room findItem(String target)
    {
        Item item = resolveItemFromCurrentRoom(target);
        if (item == null)
        {
            item = resolveItemFromGlobal(target);
        }
        Room in = null;
        if (item != null)
        {
            breaker:for(Room room : allRooms)
            {
                for(Item search : room.getItems())
                {
                    if(search.getName() == target)
                    {
                        in = room;
                        break breaker;
                    }
                }
            }
        }
        return in;
    }
    
}
