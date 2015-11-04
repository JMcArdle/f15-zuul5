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
    private Room room;
    private Player player;
    
    public CommandProcessor(Command command, Room room, Player player)
    {
        this.command = command;
        this.room = room;
        this.player = player;
    }
    
    /**
     * Given a command, process the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public void processCommand() 
    {
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case GO:
                goRoom();
                break;

           
        }
    }

    // implementations of user commands:


    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom() 
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
        Room nextRoom = room.getExit(direction);

        if (nextRoom == null)
        {
            System.out.println("You can\'t go that way.");
        }
        else
        {
            room = nextRoom;
            System.out.println(room.getDescription());
        }
    }
    
    
    
    
}
