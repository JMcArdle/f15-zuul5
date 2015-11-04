/**
 *  This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Scott Taylor
 * @version 10/28/2015
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private RoomCreator setUp;
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        setUp = new RoomCreator();
        createRooms();
        player = new Player();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        currentRoom = setUp.makeRooms();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        CommandProcessor processor;
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("You can\'t do that here.");
                break;

            case HELP:
                printHelp();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            default:
                processor = new CommandProcessor(command, currentRoom, player);
                processor.processCommand();
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Need to put stuff here");
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.numberOfWords() > 1)
        {
            if (command.getSecondWord().equalsIgnoreCase("the")||
                command.getSecondWord().equalsIgnoreCase("this"))
            {
                if (command.getThirdWord().equalsIgnoreCase("game"))
                {
                    return true;
                }
                else
                {
                    System.out.println("I don\'t understand, quit what?");
                    return false;
                }
            }
            else if (command.getSecondWord().equalsIgnoreCase("game"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;  // signal that we want to quit
        }
    }
}
