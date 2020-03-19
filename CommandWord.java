
/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * @author Gobra team
 * @version March 17, 2020 
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), LOOK("look"), QUIT("quit"), HELP("help"), PICKUP("pickup"), BACK("back"),CHECK("check"),DROP("drop"),ATTACK("attack"),UNKNOWN("?");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialize with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}

