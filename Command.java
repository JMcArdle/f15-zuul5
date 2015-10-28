/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of 5 parts: a CommandWord and 4 strings
 * (for example, if the command was "take map", then the first two parts
 * are TAKE and "map" while the remainder are <null>).
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the CommandWord is UNKNOWN.
 *
 * If the command does not have 5 words, then the remaining words are <null>.
 * 
 * @author  Scott Taylor
 * @version 10/28/2015
 */

public class Command
{
    private CommandWord commandWord;
    private String secondWord;
    private String thirdWord;
    private String fourthWord;
    private String fifthWord;

    /**
     * Create a command object. First and second words must be supplied, but
     * the second may be null.
     * @param commandWord The CommandWord. UNKNOWN if the command word
     *                  was not recognised.
     * @param secondWord The second word of the command. May be null.
     */
    public Command(CommandWord commandWord, String secondWord, String thirdWord,
                   String fourthWord, String fifthWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
        this.fourthWord = fourthWord;
        this.fifthWord = fifthWord;
    }

    /**
     * Return the command word (the first word) of this command.
     * @return The command word.
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return The third word of this command. Returns null if there was no
     * third word.
     */
    public String getThirdWord()
    {
        return thirdWord;
    }
   
    /**
     * @return The fourth word of this command. Returns null if there was no
     * fourth word.
     */
    public String getFourthWord()
    {
        return fourthWord;
    }
    
    /**
     * @return The fifth word of this command. Returns null if there was no
     * fifth word.
     */
    public String getFifthWord()
    {
        return fifthWord;
    }
    
    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * @return true if the command has a second word.
     */
    public int numberOfWords()
    {
        int counter = 0;
        if (commandWord != null)
            counter++;
        if (secondWord != null)
            counter++;
        if (thirdWord != null)
            counter++;
        if (fourthWord != null)
            counter++;
        if (fifthWord != null)
            counter++;
        return counter;
    }
    
    
}

