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
    private WorldSetup setUp;
    private Player player;
    private CommandProcessor processor;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        setUp = new WorldSetup();
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
        createRooms();
        processor = new CommandProcessor(currentRoom, player, setUp.getRoomList());
        
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
        System.out.println("Welcome to <Insert Name here>!");
        System.out.println("<Insert Name Here> is an incredibly <Placeholder> text adventure game!");
        System.out.println("Type 'help' if you need help.\n\n\n");
        System.out.println("You are drinking at an inn.  You have a reputation in this city as a guy that gets things done.  The court mage has come to the pub searching for you.  He tells you that things in the city are not behaving as they should.  People are unable to light fires to cook their food, water has become undrinkable, crops have stopped growing, and the weather is becoming increasingly erratic and unpredictable. He also tells you that he's missing his socks, though you're not sure how that's important. At all. The king has asked for your presence at his castle to help solve this problem.");
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
                processor.processCommand(command);
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
        System.out.println("Make sure to lick and torture everything. EVERYTHING. Also look around.");
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
