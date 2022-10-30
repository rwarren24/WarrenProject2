/***
 * @author Ryan Warren
 * HonorPledge I have not given or received help on this assignment
 */

/***
 * The purpose of this class is to tell the User if their input is invalid
 */
public class InvalidCommand implements UserInputCommand {
    String InvalidCommand;

    /***
     * Paramitized constructor for the InvalidCommand class
     * @param invalidCommand The String of the invalidCommand
     */
    public InvalidCommand(String invalidCommand){
        this.InvalidCommand = invalidCommand;
    }

    /***
     * The carryOut command that is implemented from UserInputCommand that tells the user the input is invalid
     * @param ts the TourStatus object being used by the commands
     */
    @Override
    public String carryOut(TourStatus ts) {
        if(InvalidCommand.equals("Bad Direction")){
            return ("You did not enter a valid direction ");
        }
        else {
            return ("Input Invalid, please enter a valid input ");
        }
    }
}
