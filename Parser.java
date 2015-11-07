import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class is part of _____, a text based adventure game created
 *  by modifying the "World of Zuul" game. 
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a 2 to 5 word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Scott Taylor
 * @version 10/28/2015
 */
public class Parser 
{
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;
        String word3 = null;
        String word4 = null;
        String word5 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();
        inputLine = inputLine.trim();

        // Find up to fill the command.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext())
        {
            word1 = tokenizer.next();
            if(tokenizer.hasNext())
            {
                word2 = tokenizer.next();
                if(tokenizer.hasNext()) 
                {
                    word3 = tokenizer.next();
                    if(tokenizer.hasNext())
                    {
                        word4 = tokenizer.next();
                        if(tokenizer.hasNext())
                        {
                            word5 = tokenizer.next();
                        }
                    }
                }
            }
        }

        return new Command(commands.getCommandWord(word1), word2, word3, word4, word5);
    }
}
