import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 * 
 * This class reads, interprets and executes the internal commands passed from object
 * descriptions when their various interactions are called by the player
 * 
 * @author Scott Taylor
 * @version 11/6/2015
 */
public class InternalCommandProcessor
{
    private StringTokenizer tokens;
    private StringTokenizer command;
    private Player player;
    private Room currentRoom;
    private ArrayList<Room> allRooms;
    private NameResolver resolver;

    /**
     * Constructor
     * 
     * @param room the current room the player is in
     * @param player the player object
     * @param allRooms a list of all the rooms in the game
     */
    public InternalCommandProcessor(Room room, Player player, ArrayList<Room> allRooms)
    {
        this.currentRoom = room;
        this.player = player;
        this.allRooms = allRooms;
        resolver = new NameResolver(room, player, allRooms);
    }
        
        
    
    /**
     * This method is responsible for interpreting and executing any methods
     * called for by the descriptions of items when the player interacts with them.
     * 
     * It does this via a psudo-command line style of checking for arguments passed
     * as separate tokens after the printed description from the object.
     */
    public void execute(String exe)
    {
        tokens = new StringTokenizer(exe, "|");
        while(tokens.hasMoreTokens())
        {
            command = new StringTokenizer(tokens.nextToken());
            if (command.hasMoreTokens())
            {
                switch(command.nextToken())
                {
                    case "-mplayer":
                        goMovePlayer();
                        break;
                    case "-mnpc":
                        goMoveNPC();
                        break;
                    case "-mitem":
                        goMoveItem();
                        break;
                    case "-anpc":
                        goAddNPC();
                        break;
                    case "-rnpc":
                        goRemoveNPC();
                        break;
                    case "-aitem":
                        goAddItem();
                        break;
                    case "-ritem":
                        goRemoveItem();
                        break;
                    case "-ainv":
                        goAddInventory();
                        break;
                    case "-rinv":
                        goRemoveInventory();
                        break;
                    case "-equip":
                        goEquip();
                        break;
                    case "-drop":
                        goDrop();
                        break;
                    case "-use":
                        goUse();
                        break;
                    default:
                    System.out.println("Debug: you tried to call an internal command that isn't in "+
                    "the list of available internal commands. Try checking your spelling.\n"+
                    "Also, remove any leading whitespace characters.");
                }
            }
        }
    }
    
    /**
     * Moves the player to another room
     */
    private void goMovePlayer()
    {
        if(command.hasMoreTokens())
        {
            String arg1 = command.nextToken();
            if(arg1.equalsIgnoreCase("to"))
            {
                if(command.hasMoreTokens())
                {
                    arg1 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the move player command didn't specify where to move");
                }
            }
            Room destination = resolver.resolveRoom(arg1);
            if ( destination !=null)
            {
                currentRoom = destination;
            }
        }
        else
        {
            System.out.println("Debug: the move player command didn't specify where to move");
        }
    }
    
    /**
     * Moves an npc to another room
     */
    private void goMoveNPC()
    {
        if(command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            if (arg2.equalsIgnoreCase("to"))
            {
                if(command.hasMoreTokens())
                {
                    arg2 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the move player command didn't specify where to move");
                }
            }
            NPC npcToMove = resolver.resolveNPCFromCurrentRoom(arg1);
            if(npcToMove == null)
            {
                npcToMove = resolver.resolveNPCFromGlobal(arg1);
            }
            if(npcToMove != null)
            {
                Room goTo = resolver.resolveRoom(arg2);
                if (goTo != null)
                {
                    findNPC(npcToMove).removeNPC(npcToMove);
                    goTo.addNPC(npcToMove);
                }
                else
                {
                    System.out.println("Debug: that room couldn't be found.");
                }
            }
            else
            {
                System.out.println("Debug: that npc couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the move npc command didn't have enough words, needs at least 3");
        }
    }
    
    
    
    /////The methods I still need to finish//////
    
    private void goMoveItem()
    {}
    private void goAddNPC()
    {}
    private void goRemoveNPC()
    {}
    private void goAddItem()
    {}
    private void goRemoveItem()
    {}
    private void goAddInventory()
    {}
    private void goRemoveInventory()
    {}
    private void goEquip()
    {}
    private void goDrop()
    {}
    private void goUse()
    {}
    
    
    
    
    
    //For finding NPCs and Items
    
    /**
     * finds what room an NPC is in
     * 
     * @param target the NPC to look for
     * @return Room what room they are in
     */
    private Room findNPC(NPC target)
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
     * finds what room an item is in
     * 
     * @param target the item to look for
     * @return Room what room it is in
     */
    private Room findItem(Item target)
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

    
}
