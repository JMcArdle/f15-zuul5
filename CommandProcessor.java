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

    // implementations of user commands:


    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goGo() 
    {
        if(words < 2) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            runInternalCommands = false;
            return;
        }

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
            StringTokenizer description = new StringTokenizer(output, "|");
            System.out.println(description.nextToken());
        }
    }
    
    /**
     * Look at something to get more information
     */
    private void goLook()
    {
        if (words >= 2)
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
                    case 2:
                        output = resolver.resolveItemFromCurrentRoom(target).getLook();
                    case 3:
                        output = resolver.resolveItemFromInventory(target).getLook();
                    case 4:
                        output = resolver.resolveItemFromEquip(target).getLook();
                    default:
                        System.out.println("Debug: looking at something broke. Fix it.");
                        break;
                }
                StringTokenizer look = new StringTokenizer(output, "|");
                if(look.hasMoreTokens())
                    System.out.println(look.nextToken());
            }
        }
    }

    
    
    
    
    /////All the other methods I haven't finished/////
    private void goTalk()
    {
        
    }
    private void goAttack()
    {}
    private void goSense()
    {}
    private void goUse()
    {}
    private void goClimb()
    {}
    private void goJump()
    {}
    private void goLeer()
    {}
    private void goLick()
    {}
    private void goEat()
    {}
    private void goDrink()
    {}
    private void goRun()
    {}
    private void goCrawl()
    {}
    private void goTorture()
    {}
    private void goEscape()
    {}
    private void goListen()
    {}
    private void goDodge()
    {}
    private void goEquip()
    {}
    private void goGrab()
    {}
    private void goDrop()
    {}
    private void goInventory()
    {}
        
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
        
}
