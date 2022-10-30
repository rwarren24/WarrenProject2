/***
 * @author Ryan Warren
 * HonorPledge I have not given or received help on this assignment
 */


/***
 * The purpose of this class is to take directions and print out all items in the users backpack
 */
public class BackpackCommand implements UserInputCommand {

    /***
     * Default constructor for the BackpackCommand class
     *
     */
    public BackpackCommand(){

    }

    /***
     * The carryOut command that is implemented from UserInputCommand that lists the items currently in the user's backpack
     * @param ts the TourStatus object being used by the commands
     */
    @Override
    public String carryOut(TourStatus ts) {
        return ts.backpack.toString();
    }
}
