import java.util.HashMap;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Scott Taylor
 * @version 10/28/2015
 */

public class CommandWords
{
    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("look", CommandWord.LOOK);
        validCommands.put("talk", CommandWord.TALK);
        validCommands.put("attack", CommandWord.ATTACK);
        validCommands.put("sense", CommandWord.SENSE);
        validCommands.put("use", CommandWord.USE);
        validCommands.put("climb", CommandWord.CLIMB);
        validCommands.put("jump", CommandWord.JUMP);
        validCommands.put("leer", CommandWord.LEER);
        validCommands.put("lick", CommandWord.LICK);
        validCommands.put("eat", CommandWord.EAT);
        validCommands.put("drink", CommandWord.DRINK);
        validCommands.put("run", CommandWord.RUN);
        validCommands.put("crawl", CommandWord.CRAWL);
        validCommands.put("torture", CommandWord.TORTURE);
        validCommands.put("escape", CommandWord.ESCAPE);
        validCommands.put("listen", CommandWord.LISTEN);
        validCommands.put("dodge", CommandWord.DODGE);
        validCommands.put("equip", CommandWord.EQUIP);
        validCommands.put("grab", CommandWord.GRAB);
        validCommands.put("drop", CommandWord.DROP);
        validCommands.put("inventory", CommandWord.INVENTORY);
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up (as a string).
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

//     /**
//      * Print all valid commands to System.out.
//      */
//     public void showAll() 
//     {
//         for(String command : validCommands.keySet()) {
//             System.out.print(command + "  ");
//         }
//         System.out.println();
//     }
}
