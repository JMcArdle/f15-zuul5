import java.util.ArrayList;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 *  
 *  This is the main command processor for the game.
 * 
 * @author Scott Taylor
 * @version 11/4/2015
 */
public class CommandProcessor
{
    private Command command;
    private Room currentRoom;
    private Player player;
    private ArrayList<Room> allRooms;
    private String word2;
    private String word3;
    private String word4;
    private String word5;
    private int words;
    
    private InternalCommandProcessor internalProcessor;
    private String internalCommands;
    
    public CommandProcessor(Room room, Player player, ArrayList<Room> allRooms)
    {
        this.currentRoom = room;
        this.player = player;
        this.allRooms = allRooms;
       internalProcessor = new InternalCommandProcessor(room, player, allRooms);
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
                break;
            default:
                System.out.println("Debug: Something went wrong.\n\nThe command "+
                "used wasn't unknown, but it wasn't known either. This Really shouldn't ever print "+
                "so if it does, something really went terribly, terribly wrong.");
        }
    }

    // implementations of user commands:


    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goGo() 
    {
        if(command.numberOfWords() < 2) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
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
        }
        else
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getDescription());
        }
    }
    
    /**
     * Look at something to get more information
     */
    private void goLook()
    {
        
        if(word2.equalsIgnoreCase("around"))
        {
            ///print out the extra description info
    
    
    
            
            
        }
    }
    
    
    
    
    /////All the other methods I haven't finished/////
    private void goTalk()
    {}
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
        
        
    private void executeInternalCommands()
    {
        internalProcessor.execute(internalCommands);
    }
        
}
