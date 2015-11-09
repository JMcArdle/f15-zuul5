import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 *  
 *  This is the main command processor for the game.
 * 
 * @author Scott Taylor
 * @version 11/8/2015
 */
public class CommandProcessor
{
    private Command command;
    private NameResolver resolver;
    private Room currentRoom;
    private Player player;
    private ArrayList<Room> allRooms;
    private String word2;
    private String word3;
    private String word4;
    private String word5;
    private int words;
    
    boolean runInternalCommands;
    String output;
    
    private InternalCommandProcessor internalProcessor;
    
    public CommandProcessor(Room currentRoom, Player player, ArrayList<Room> allRooms)
    {
       this.currentRoom = currentRoom;
       this.player = player;
       this.allRooms = allRooms;
       internalProcessor = new InternalCommandProcessor(currentRoom, player, allRooms);
       resolver = new NameResolver(currentRoom, player, allRooms);
    }
    
    /**
     * Given a command, process the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public void processCommand(Command command) 
    {
        if(command.numberOfWords() < 2)
        {
            System.out.println("You can't do anything without saying what to do it to or at.");
        }
        else
        {
            CommandWord commandWord = command.getCommandWord();
            word2 = command.getSecondWord();
            word3 = command.getThirdWord();
            word4 = command.getFourthWord();
            word5 = command.getFifthWord();
            words = command.numberOfWords();
            runInternalCommands = true;
            
    
            switch (commandWord) {
                case GO:
                    goGo();
                    break;
                case LOOK: 
                    goLook();
                    break;
                case TALK:
                    goTalk();
                    break;
                case ATTACK:
                    goAttack();
                    break;
                case SENSE:
                    goSense();
                    break;
                case USE:
                    goUse();
                    break;
                case CLIMB:
                    goClimb();
                    break;
                case JUMP:
                    goJump();
                    break;
                case LEER:
                    goLeer();
                    break;
                case LICK:
                    goLick();
                    break;
                case EAT:
                    goEat();
                    break;
                case DRINK:
                    goDrink();
                    break;
                case RUN:
                    goRun();
                    break;
                case CRAWL:
                    goCrawl();
                    break;
                case TORTURE:
                    goTorture();
                    break;
                case ESCAPE:
                    goEscape();
                    break;
                case LISTEN:
                    goListen();
                    break;
                case DODGE:
                    goDodge();
                    break;
                case EQUIP:
                    goEquip();
                    break;
                case GRAB:
                    goGrab();
                    break;
                case DROP:
                    goDrop();
                    break;
                case INVENTORY:
                    goInventory();
                    runInternalCommands = false;
                    break;
                default:
                    runInternalCommands = false;
                    System.out.println("Debug: Something went wrong.\n\nThe command "+
                    "used wasn't unknown, but it wasn't known either. This Really shouldn't ever print "+
                    "so if it does, something really went terribly, terribly wrong.");
                    break;
            }
            if (runInternalCommands)
            {
                internalProcessor.execute(output);
            }
        }
    }

    ///implementations of user commands///


    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goGo() 
    {
        String direction = command.getSecondWord();
        if (direction.equalsIgnoreCase("to")||
            direction.equalsIgnoreCase("toward")||
            direction.equalsIgnoreCase("into"))
        {
            direction = command.getThirdWord();
            if (direction.equalsIgnoreCase("the")||
                direction.equalsIgnoreCase("that"))
            {
                direction = command.getFourthWord();
            }
        }

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null)
        {
            System.out.println("You can\'t go that way.");
            runInternalCommands = false;
        }
        else
        {
            currentRoom = nextRoom;
            output = currentRoom.getDescription();
            if(!printOutput())
            {
                System.out.println("You enter the room.");
                runInternalCommands = false;
            }
        }
    }
    
    /**
     * Look at something to get more information
     */
    private void goLook()
    {
        int npcOrItem = 0;
        String target;
        if(word2.equalsIgnoreCase("around"))
        {
            output = (currentRoom.getExtraDescription());
            StringTokenizer description = new StringTokenizer(output, "|");
            if (description.hasMoreTokens())
            {
                System.out.println(description.nextToken());
            }
            else
            {
                System.out.println("You see nothing of importance.");
                runInternalCommands = false;
            }
        }
        else
        {   
            if(word2.equalsIgnoreCase("at"))
            {
                target = word3;
            }
            else
            {
                target = word2;
            }
            npcOrItem = isNPCOrItem(target);
            switch(npcOrItem)
            {
                case 0:
                    System.out.println("Can't find what you want to look at.");
                    runInternalCommands = false;
                    break;
                case 1:
                    output = resolver.resolveNPCFromCurrentRoom(target).getLook();
                    break;
                case 2:
                    output = resolver.resolveItemFromCurrentRoom(target).getLook();
                    break;
                case 3:
                    output = resolver.resolveItemFromInventory(target).getLook();
                    break;
                case 4:
                    output = resolver.resolveItemFromEquip(target).getLook();
                    break;
                default:
                    System.out.println("Debug: looking at something broke. Fix it.");
                    break;
            }
            if(!printOutput())
            {
                System.out.println("Doesn't look interesting.");
                runInternalCommands = false;
            }
        }
    }

    
    
    
    
    /////All the other methods I haven't finished/////
    private void goTalk()
    {
        String target;
        if (word2.equalsIgnoreCase("to") || word2.equalsIgnoreCase("with"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        NPC npcToTalk = resolver.resolveNPCFromCurrentRoom(target);
        output = npcToTalk.getTalk();
        printOutput();
        
        ///Need to add a way to figure out if it should use the regular or removal talk method///
    }
    
    private void goAttack()
    {
        int npcOrItem = 0;
        String target;
        if(word2.equalsIgnoreCase("darkness"))
        {
            System.out.println("You attack the darkness!");
            runInternalCommands = false;
        }
        else
        {   
            if(word2.equalsIgnoreCase("the"))
            {
                target = word3;
            }
            else
            {
                target = word2;
            }
            npcOrItem = isNPCOrItem(target);
            switch(npcOrItem)
            {
                case 0:
                    System.out.println("Can't find that.");
                    runInternalCommands = false;
                    break;
                case 1:
                    output = resolver.resolveNPCFromCurrentRoom(target).getAttack();
                    break;
                case 2:
                    output = resolver.resolveItemFromCurrentRoom(target).getAttack();
                    break;
                case 3:
                    output = resolver.resolveItemFromInventory(target).getAttack();
                    break;
                case 4:
                    output = resolver.resolveItemFromEquip(target).getAttack();
                    break;
                default:
                    System.out.println("Debug: attacking something broke. Fix it.");
                    break;
            }
            if(!printOutput())
            {
                System.out.println("Can't attack that.");
                runInternalCommands = false;
            }
        }
    }
    
    private void goSense()
    {
        //Nothing goes here?
    }
    
    private void goUse()
    {
        int has = 0;
        String target = null;
        if(word2.equalsIgnoreCase("the"))
        {
            if (word3.equalsIgnoreCase("force"))
            {
                System.out.println("Do or do not, there is no try.");
                runInternalCommands = false;
            }
            else
                target = word3;
        }
        else
        {
            target = word2;
        }
        if(resolver.resolveItemFromInventory(target) != null)
            has = 1;
        else if(resolver.resolveItemFromEquip(target) != null)
            has = 2;
        switch(has)
        {
            case 0:
                System.out.println("You don't have that.");
                runInternalCommands = false;
                break;
            case 1:
                output = resolver.resolveItemFromInventory(target).getUse();
                break;
            case 2:
                output = resolver.resolveItemFromEquip(target).getUse();
                break;
            default:
                System.out.println("Debug: using something broke. Fix it.");
                break;
        }
        if(!printOutput())
        {
            System.out.println("Can't use that.");
            runInternalCommands = false;
        }
    }
    
    private void goClimb()
    {
        //Nothing goes here?
    }
    
    private void goJump()
    {
        //Nothing goes here?
    }
    
    private void goLeer()
    {
        String target;
        if (word2.equalsIgnoreCase("at"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        NPC npcToLeer = resolver.resolveNPCFromCurrentRoom(target);
        output = npcToLeer.getLeer();
        if(!printOutput())
        {
            System.out.println("They don't notice.");
            runInternalCommands = false;
        }
    }
    
    private void goLick()
    {
        int npcOrItem = 0;
        String target;
        if(word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        npcOrItem = isNPCOrItem(target);
        switch(npcOrItem)
        {
            case 0:
                System.out.println("Can't find what you want to lick.");
                runInternalCommands = false;
                break;
            case 1:
                output = resolver.resolveNPCFromCurrentRoom(target).getLick();
                break;
            case 2:
                output = resolver.resolveItemFromCurrentRoom(target).getLick();
                break;
            case 3:
                output = resolver.resolveItemFromInventory(target).getLick();
                break;
            case 4:
                output = resolver.resolveItemFromEquip(target).getLick();
                break;
            default:
                System.out.println("Debug: licking something something broke. Fix it.");
                break;
        }
        if(!printOutput())
        {
            System.out.println("Can't lick that.");
            runInternalCommands = false;
        }
    }
    
    private void goEat()
    {
        int has = 0;
        String target;
        if(word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        if(resolver.resolveItemFromInventory(target) != null)
            has = 1;
        else if(resolver.resolveItemFromEquip(target) != null)
            has = 2;
        else if(resolver.resolveItemFromCurrentRoom(target) != null)
            has = 3;
        switch(has)
        {
            case 0:
                System.out.println("Can't find that.");
                runInternalCommands = false;
                break;
            case 1:
                output = resolver.resolveItemFromInventory(target).getEat();
                break;
            case 2:
                output = resolver.resolveItemFromEquip(target).getEat();
                break;
            case 3:
                output = resolver.resolveItemFromCurrentRoom(target).getEat();
            default:
                System.out.println("Debug: eating something broke. Fix it.");
                break;
        }
        if(!printOutput())
        {
            System.out.println("Can't eat that.");
            runInternalCommands = false;
        }
    }
    
    private void goDrink()
    {
        int has = 0;
        String target;
        if(word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        if(resolver.resolveItemFromInventory(target) != null)
            has = 1;
        else if(resolver.resolveItemFromEquip(target) != null)
            has = 2;
        else if(resolver.resolveItemFromCurrentRoom(target) != null)
            has = 3;
        switch(has)
        {
            case 0:
                System.out.println("Can't find that.");
                runInternalCommands = false;
                break;
            case 1:
                output = resolver.resolveItemFromInventory(target).getDrink();
                break;
            case 2:
                output = resolver.resolveItemFromEquip(target).getDrink();
                break;
            case 3:
                output = resolver.resolveItemFromCurrentRoom(target).getDrink();
            default:
                System.out.println("Debug: drinking something broke. Fix it.");
                break;
        }
        if(!printOutput())
        {
            System.out.println("Can't drink that.");
            runInternalCommands = false;
        }
    }
    
    private void goRun()
    {
        //What goes here?
    }
    
    private void goCrawl()
    {
        String target;
        if (word2.equalsIgnoreCase("in") || word2.equalsIgnoreCase("under"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        Item itemToCrawl = resolver.resolveItemFromCurrentRoom(target);
        output = itemToCrawl.getCrawl();
        if(!printOutput())
        {
            System.out.println("Can't crawl under that.");
            runInternalCommands = false;
        }
    }
    
    private void goTorture()
    {
        String target;
        if (word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        NPC npcToTorture = resolver.resolveNPCFromCurrentRoom(target);
        output = npcToTorture.getTorture();
        if(!printOutput())
        {
            System.out.println("You can't do that to them.");
            runInternalCommands = false;
        }
    }
    
    private void goEscape()
    {
        String target;
        if (word2.equalsIgnoreCase("from"))
        {
            if (word2.equalsIgnoreCase("from"))
            {
                target = word4;
            }
            else
            {
               target = word3;
            }
        }
        else if (word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        NPC npcToEscape = resolver.resolveNPCFromCurrentRoom(target);
        output = npcToEscape.getEscape();
        if(!printOutput())
        {
            System.out.println("You can't escape them.");
            runInternalCommands = false;
        }
    }
    
    private void goListen()
    {
        String target;
        if (word2.equalsIgnoreCase("to"))
        {
            if (word2.equalsIgnoreCase("the"))
            {
                target = word4;
            }
            else
            {
               target = word3;
            }
        }
        else
        {
            target = word2;
        }
        NPC npcToEscape = resolver.resolveNPCFromCurrentRoom(target);
        output = npcToEscape.getEscape();
        if(!printOutput())
        {
            System.out.println("They don't say anything.");
            runInternalCommands = false;
        }
    }
    
    private void goDodge()
    {
        int npcOrItem = 0;
        String target;
        if(word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        npcOrItem = isNPCOrItem(target);
        switch(npcOrItem)
        {
            case 0:
                System.out.println("You can't dodge something that isn't here.");
                runInternalCommands = false;
                break;
            case 1:
                output = resolver.resolveNPCFromCurrentRoom(target).getDodge();
                break;
            case 2:
                output = resolver.resolveItemFromCurrentRoom(target).getDodge();
                break;
            case 3:
                output = resolver.resolveItemFromInventory(target).getDodge();
                break;
            case 4:
                output = resolver.resolveItemFromEquip(target).getDodge();
                break;
            default:
                System.out.println("Debug: dodging something something broke. Fix it.");
                break;
        }
        if(!printOutput())
        {
            System.out.println("Can't dodge that.");
            runInternalCommands = false;
        }
    }
    
    private void goEquip()
    {
        runInternalCommands = false;
        int has = 0;
        String target;
        Item item = null;
        if(word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        if(resolver.resolveItemFromInventory(target) != null)
            has = 1;
        else if(resolver.resolveItemFromEquip(target) != null)
            has = 2;
        switch(has)
        {
            case 0:
                System.out.println("You don't have that.");
                break;
            case 1:
                item = (resolver.resolveItemFromInventory(target));
                break;
            case 2:
                item = (resolver.resolveItemFromEquip(target));
                break;
            default:
                System.out.println("Debug: equipping something broke. Fix it.");
                break;
        }
        if (item != null)
        {
            if(player.equip(item))
            {
                System.out.println("You equip " + item.getName());
            }
            else
            {
                System.out.println("Can't equip that.");
            }
        }
    }
    
    private void goGrab()
    {
        int npcOrItem = 0;
        String target;
        if(word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        npcOrItem = isNPCOrItem(target);
        switch(npcOrItem)
        {
            case 0:
                System.out.println("Can't grab something that isn't here.");
                runInternalCommands = false;
                break;
            case 1:
                output = resolver.resolveNPCFromCurrentRoom(target).getGrab();
                break;
            case 2:
                output = resolver.resolveItemFromCurrentRoom(target).getGrab();
                break;
            case 3:
                output = resolver.resolveItemFromInventory(target).getGrab();
                break;
            case 4:
                output = resolver.resolveItemFromEquip(target).getGrab();
                break;
            default:
                System.out.println("Debug: grabbing something something broke. Fix it.");
                break;
        }
        if(!printOutput())
        {
            System.out.println("Can't grab that.");
            runInternalCommands = false;
        }
    }
    
    private void goDrop()
    {
        runInternalCommands = false;
        int has = 0;
        String target;
        Item item = null;
        if(word2.equalsIgnoreCase("the"))
        {
            target = word3;
        }
        else
        {
            target = word2;
        }
        if(resolver.resolveItemFromInventory(target) != null)
            has = 1;
        else if(resolver.resolveItemFromEquip(target) != null)
            has = 2;
        switch(has)
        {
            case 0:
                System.out.println("You don't have that.");
                break;
            case 1:
                item = (resolver.resolveItemFromInventory(target));
                break;
            case 2:
                item = (resolver.resolveItemFromEquip(target));
                break;
            default:
                System.out.println("Debug: equipping something broke. Fix it.");
                break;
        }
        if (item != null)
        {
            player.takeAwayItem(item);
            currentRoom.addItem(item);
            System.out.println("You drop " + item.getName());
        }
        else
        {
            System.out.println("You don't have that.");
        }
    }
    
    private void goInventory()
    {
        for(Item item : player.getInventory())
        {
            System.out.println(item.getName());
        }
    }
        
    
    
    
    private int isNPCOrItem(String target)
    {
        int npcOrItem = 0;
        if(resolver.resolveNPCFromCurrentRoom(target) != null)
            npcOrItem = 1;
        if (npcOrItem == 0)
        {
            if(resolver.resolveItemFromCurrentRoom(target) != null)
                npcOrItem = 2;
        }
        if (npcOrItem == 0)
        {
            if(resolver.resolveItemFromInventory(target) != null)
                npcOrItem = 3;
        }
        if (npcOrItem == 0)
        {
            if(resolver.resolveItemFromEquip(target) != null)
                npcOrItem = 4;
        }
        return npcOrItem;
    }
    
    private boolean printOutput()
    {
        StringTokenizer toPrint = new StringTokenizer(output, "|");
        if(toPrint.hasMoreTokens())
        {
            System.out.println(toPrint.nextToken());
            return true;
        }
        else
        {
            return false;
        }
    }
}
