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
 * @version 11/8/2015
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
                switchCommands();
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
                    resolver.findNPC(npcToMove).removeNPC(npcToMove);
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
            System.out.println("Debug: the move npc command didn't have enough words, needs at least 3 (command npc room)");
        }
    }
    
    private void goMoveItem()
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
            Item itemToMove = resolver.resolveItemFromCurrentRoom(arg1);
            if(itemToMove == null)
            {
                itemToMove = resolver.resolveItemFromGlobal(arg1);
            }
            if(itemToMove != null)
            {
                Room goTo = resolver.resolveRoom(arg2);
                if (goTo != null)
                {
                    resolver.findItem(itemToMove).removeItem(itemToMove);
                    goTo.addItem(itemToMove);
                }
                else
                {
                    System.out.println("Debug: that room couldn't be found.");
                }
            }
            else
            {
                System.out.println("Debug: that item couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the move item command didn't have enough words, needs at least 3 (command npc room)");
        }
    
    }
    
    private void goAddNPC()
    {
        if(command.countTokens() == 12)
        {
            String name = command.nextToken();
            String look = command.nextToken();
            String attack = command.nextToken();
            String leer = command.nextToken();
            String lick = command.nextToken();
            String torture = command.nextToken();
            String escape = command.nextToken();
            String listen = command.nextToken();
            String dodge = command.nextToken();
            String grab = command.nextToken();
            String room = command.nextToken();
            Room goTo = null;
            goTo = resolver.resolveRoom(room);
            if (goTo != null)
            {
                goTo.addNPC(new NPC(name,look,attack,leer,lick,torture,escape,listen,dodge,grab));
            }
            else
            {
                System.out.println("Debug: the room you want to add an an npc to doesn't exist");
            }
        }
        else
        {
            System.out.println("Debug: addNPC internal command needs 12 words (command, 10 words for the signature, and the room name");
        }
    }
    
    private void goRemoveNPC()
    {
        if(command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            if (arg2.equalsIgnoreCase("from"))
            {
                if(command.hasMoreTokens())
                {
                    arg2 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the remove npc command didn't specify where to remove from");
                }
            }
            NPC npcToRemove = resolver.resolveNPCFromCurrentRoom(arg1);
            if(npcToRemove == null)
            {
                npcToRemove = resolver.resolveNPCFromGlobal(arg1);
            }
            if(npcToRemove != null)
            {
                Room goTo = resolver.resolveRoom(arg2);
                if (goTo != null)
                {
                    goTo.removeNPC(npcToRemove);
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
            System.out.println("Debug: the remove npc command didn't have enough words, needs at least 3 (command npc room)");
        }
    }
    
    private void goAddNPCTalk()
    {
        if (command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            while (command.hasMoreTokens())
            {
                arg2 = arg2 + " " + command.nextToken();
            }
            NPC targetNPC = resolver.resolveNPCFromCurrentRoom(arg1);
            if(targetNPC == null)
            {
                targetNPC = resolver.resolveNPCFromGlobal(arg1);
            }
            if(targetNPC != null)
            {
                targetNPC.addTalk(arg1);
            }
            else
            {
                System.out.println("Debug: could not find the npc");
            }
        }
        else
        {
            System.out.println("Debug add npc talk needs 3 words (command npc words)");
        }
    }
    
    private void goRemoveNPCTalk()
    {
        if (command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            while (command.hasMoreTokens())
            {
                arg2 = arg2 + " " + command.nextToken();
            }
            NPC targetNPC = resolver.resolveNPCFromCurrentRoom(arg1);
            if(targetNPC == null)
            {
                targetNPC = resolver.resolveNPCFromGlobal(arg1);
            }
            if(targetNPC != null)
            {
                targetNPC.removeTalk(arg1);
            }
            else
            {
                System.out.println("Debug: could not find the npc");
            }
        }
        else
        {
            System.out.println("Debug remove npc talk needs 3 words (command npc words without quotes)");
        }
    }
    
    private void goAddItem()
    {
        if(command.countTokens() == 14)
        {
            String name = command.nextToken();
            String look = command.nextToken();
            String attack = command.nextToken();
            String lick = command.nextToken();
            String eat = command.nextToken();
            String drink = command.nextToken();
            String crawl = command.nextToken();
            String listen = command.nextToken();
            String dodge = command.nextToken();
            String grab = command.nextToken();
            String use = command.nextToken();
            String eq = command.nextToken();
            boolean equipable = false;
            String room = command.nextToken();
            Room goTo = null;
            if (eq.equalsIgnoreCase("1") || eq.equalsIgnoreCase("01") || eq.equalsIgnoreCase("yes") || eq.equalsIgnoreCase("true"))
            {
                equipable = true;
            }
            goTo = resolver.resolveRoom(room);
            if (goTo != null)
            {
                goTo.addItem(new Item(name,look,attack,lick,eat,drink,crawl,listen,dodge,grab, use, equipable));
            }
            else
            {
                System.out.println("Debug: the room you want to add an an item to doesn't exist");
            }
        }
        else
        {
            System.out.println("Debug: addItem internal command needs 9 words (command, 9 words for the signature, and the room name");
        }
    }
    
    private void goRemoveItem()
    {
        if(command.countTokens() >= 3)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            if (arg2.equalsIgnoreCase("from"))
            {
                if(command.hasMoreTokens())
                {
                    arg2 = command.nextToken();
                }
                else
                {
                    System.out.println("Debug: the remove item command didn't specify where to remove it from");
                }
            }
            Item itemToRemove = resolver.resolveItemFromCurrentRoom(arg1);
            if(itemToRemove == null)
            {
                itemToRemove = resolver.resolveItemFromGlobal(arg1);
            }
            if(itemToRemove != null)
            {
                Room goTo = resolver.resolveRoom(arg2);
                if (goTo != null)
                {
                    goTo.removeItem(itemToRemove);
                }
                else
                {
                    System.out.println("Debug: that room couldn't be found.");
                }
            }
            else
            {
                System.out.println("Debug: that item couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the remove item command didn't have enough words, needs at least 3 (command item room)");
        }
    }
    
    private void goModifyNPC()
    {
        if(command.countTokens() >= 4)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            String arg3 = command.nextToken();
            while (command.hasMoreTokens())
            {
                arg3 = arg3 + " " + command.nextToken();
            }
            NPC targetNPC = resolver.resolveNPCFromCurrentRoom(arg1);
            if(targetNPC == null)
            {
                targetNPC = resolver.resolveNPCFromGlobal(arg1);
            }
            if(targetNPC != null)
            {
                switch(arg2.trim().toLowerCase())
                {
                    case "name":
                        targetNPC.setName(arg3);
                        break;
                    case "look":
                        targetNPC.setLook(arg3);
                        break;
                    case "attack":
                        targetNPC.setAttack(arg3);
                        break;
                    case "leer":
                        targetNPC.setLeer(arg3);
                        break;
                    case "lick":
                        targetNPC.setLick(arg3);
                        break;
                    case "torture":
                        targetNPC.setTorture(arg3);
                        break;
                    case "escape":
                        targetNPC.setEscape(arg3);
                        break;
                    case "listen":
                        targetNPC.setListen(arg3);
                        break;
                    case "dodge":
                        targetNPC.setDodge(arg3);
                        break;
                    case "grab":
                        targetNPC.setGrab(arg3);
                        break;
                    default:
                        System.out.println("Debug: modify npc recieved a field to modify that isn't doesn't exist");
                        break;
                }
            }
            else
            {
                System.out.println("Debug: could not find the npc");
            }
        }
        else
        {
            System.out.println("Debug: the modifyNPC command didn't have enough words, needs at least 4 (command npc modify newValue)");
        }
    }
    
    private void goModifyItem()
    {
        if(command.countTokens() >= 4)
        {
            String arg1 = command.nextToken();
            String arg2 = command.nextToken();
            String arg3 = command.nextToken();
            while(command.hasMoreTokens())
            {
                arg3 = arg3 + " " + command.nextToken();
            }
            Item targetItem = resolver.resolveItemFromCurrentRoom(arg1);
            if(targetItem == null)
            {
                targetItem = resolver.resolveItemFromGlobal(arg1);
            }
            if(targetItem != null)
            {
                switch(arg2.trim().toLowerCase())
                {
                    case "name":
                        targetItem.setName(arg3);
                        break;
                    case "look":
                        targetItem.setLook(arg3);
                        break;
                    case "attack":
                        targetItem.setAttack(arg3);
                        break;
                    case "lick":
                        targetItem.setLick(arg3);
                        break;
                    case "eat":
                        targetItem.setEat(arg3);
                        break;
                    case "drink":
                        targetItem.setDrink(arg3);
                        break;
                    case "listen":
                        targetItem.setListen(arg3);
                        break;
                    case "dodge":
                        targetItem.setDodge(arg3);
                        break;
                    case "grab":
                        targetItem.setGrab(arg3);
                        break;
                    default:
                        System.out.println("Debug: modify item recieved a field to modify that isn't doesn't exist");
                        break;
                }
            }
            else
            {
                System.out.println("Debug: could not find the item");
            }
        }
        else
        {
            System.out.println("Debug: the modifyItem command didn't have enough words, needs at least 4 (command npc modify new value no quotes)");
        }
    }
    
    private void goAddInventory()
    {
        if(command.countTokens() >= 2)
        {
            String item = command.nextToken();
            Item itemToAdd = resolver.resolveItemFromCurrentRoom(item);
            if(itemToAdd == null)
            {
                itemToAdd = resolver.resolveItemFromGlobal(item);
            }
            if(itemToAdd != null)
            {
                Room from = null;
                from = resolver.findItem(item);
                if (from != null)
                {
                    player.addToInventory(itemToAdd);
                    from.removeItem(itemToAdd);
                }
                System.out.println("Debug: the item was found when the name was resolved, but then couldn't find the room it was in "+
                "somehow...\n\nI really hope this never prints out because it means I royally screwed something up.");
            }
            else
            {
                System.out.println("Debug: that item couldn't be found.");
            }
        }
        else
        {
            System.out.println("Debug: the add Inventory command didn't have enough words, needs at least 2 (command item)");
        }
    }
    
    private void goRemoveInventory()
    {
        if(command.countTokens() >= 2)
        {
            String item = command.nextToken();
            Item itemToRemove = resolver.resolveItemFromInventory(item);
            if(itemToRemove != null)
            {
                player.removeFromInventory(itemToRemove);
            }
            else
            {
                System.out.println("Couldn't find the item to remove from the player's inventory.");
            }
        }
        else
        {
            System.out.println("Debug: the remove Inventory command didn't have enough words, needs at least 2 (command item)");
        }
    }
    
    private void goEquip()
    {
        if(command.countTokens() >= 2)
        {
            String item = command.nextToken();
            Item itemToEquip = resolver.resolveItemFromInventory(item);
            if(itemToEquip != null)
            {
                player.equip(itemToEquip);
            }
            else
            {
                System.out.println("Debug: couldn't find the item to equip in the player's inventory.");
            }
        }
        else
        {
            System.out.println("Debug: the equip command didn't have enough words, needs at least 2 (command item)");
        }
    }
    
    private void goDrop()
    {
        if(command.countTokens() >= 2)
        {
            String item = command.nextToken();
            Item itemToDrop = resolver.resolveItemFromInventory(item);
            if(itemToDrop != null)
            {
                player.removeFromInventory(itemToDrop);
                currentRoom.addItem(itemToDrop);
            }
            else
            {
                System.out.println("Debug: couldn't find the item to drop in the player's inventory.");
            }
        }
        else
        {
            System.out.println("Debug: the remove Inventory command didn't have enough words, needs at least 2 (command item)");
        }
    }
    
    private void goPhase1()
    {
        resolver.resolveRoom("inn").setExtraDescription("Stuff");
    }
    
    private void goPhase2()
    {
        //Make all the changes needed at phase change
    }
    
    private void goPhase3()
    {
        //Make all the changes needed at phase change
    }
    
    private void goPhase4()
    {
        //Make all the changes needed at phase change
    }
    
//     Not sure if this fits in the internal commands, will see later//
//         private void goUse()
//         {
//             if(command.countTokens() >= 2)
//             {
//                 String item = command.nextToken();
//                 Item itemToUse = resolver.resolveItemFromInventory(item);
//                 if(itemToUse != null)
//                 {
//                     player.use(itemToUse);
//                 }
//                 else
//                 {
//                     System.out.println("Debug: couldn't find the item to drop in the player's inventory.");
//                 }
//             }
//             else
//             {
//                 System.out.println("Debug: the use command didn't have enough words, needs at least 2 (command item)");
//             }
//         }
    
    private void goCheckInventory()
    {
        if(command.countTokens() >= 4)
        {
            if(command.hasMoreTokens())
            {
                String item = command.nextToken();
                Item itemToCheck = resolver.resolveItemFromInventory(item);
                if(itemToCheck == null)
                {
                    itemToCheck = resolver.resolveItemFromEquip(item);
                }
                if(itemToCheck != null)
                {
                    if (command.hasMoreTokens())
                    {
                        removeReadTokens();
                        switchCommands();
                    }
                    else
                    {
                        System.out.println("Ran out of tokens when looking for the command to use");
                    }
                }
                else
                {
                    //didn't find item, don't do anything
                }
            }
            System.out.println("Ran out of tokens when looking for the item to look for");
        }
        else
        {
            System.out.println("Debug: the check Inventory command didn't have enough words, needs at least 4 (command item command xxx)");
        }
    }
    
    private void goCheckEquip()
    {
        if(command.countTokens() >= 4)
        {
            if(command.hasMoreTokens())
            {
                String item = command.nextToken();
                Item itemToCheck = resolver.resolveItemFromEquip(item);
                if(itemToCheck == null)
                {
                    itemToCheck = resolver.resolveItemFromEquip(item);
                }
                if(itemToCheck != null)
                {
                    if (command.hasMoreTokens())
                    {
                        removeReadTokens();
                        switchCommands();
                    }
                    else
                    {
                        System.out.println("Ran out of tokens when looking for the command to use");
                    }
                }
                else
                {
                    //didn't find item, don't do anything
                }
            }
            System.out.println("Ran out of tokens when looking for the item to look for");
        }
        else
        {
            System.out.println("Debug: the check equip command didn't have enough words, needs at least 4 (command item command xxx)");
        }
    }
    
    private void removeReadTokens()
    {
        String newCommand = null;
        while(command.hasMoreTokens())
        {
            newCommand = newCommand + " " + command.nextToken();
        }
        command = new StringTokenizer(newCommand);
    }
    
    private void switchCommands()
    {
        switch(command.nextToken().trim().toLowerCase())
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
            case "-anpctalk":
                goAddNPCTalk();
                break;
            case "-rnpctalk":
                goRemoveNPCTalk();
            case "-aitem":
                goAddItem();
                break;
            case "-ritem":
                goRemoveItem();
                break;
            case "-modnpc":
                goModifyNPC();
                break;
            case "-moditem":
                goModifyItem();
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
            case "-phase1":
                goPhase1();
                break;
            case "-phase2":
                goPhase2();
                break;
            case "-phase3":
                goPhase3();
                break;
            case "-phase4":
                goPhase4();
                break;

            case "-checkinv":
                goCheckInventory();
                break;
            case "-checkeq":
                goCheckEquip();
                break;
            default:
            System.out.println("Debug: you tried to call an internal command that isn't in "+
            "the list of available internal commands. Try checking your spelling.\n");
        }
    }
}
