/***
 * @author Ryan Warren
 * HonorPledge I have not given or received help on this assignment
 */

/***
 * The purpose of this class is to take directions and update the current location of the tour
 */
public class MovementCommand implements UserInputCommand {
    String dir;

    /***
     * Paramitized constructor for the MovementCommand class
     * @param dir the direction the user wishes to move
     */
    public MovementCommand(String dir){
        this.dir = dir;
    }
    /***
     * The carryOut command that is implemented from UserInputCommand that moves the user to a new location if that location exists
     * @param ts the TourStatus object being used by the commands
     */
    @Override
    public String carryOut(TourStatus ts){
        String mess = "";
        mess += ("You're current Location is: " + ts.getCurrentLocation().toString() + "\n");
        mess += ("You chose to head in this direction" + " " + dir + "\n");
        if(ts.getCurrentLocation().leaveLocation(dir).getName() == null){
            UserInputCommand in = new InvalidCommand("Bad Direction");
            return in.carryOut(ts);
        }
        else {
            ts.updateTourLocation(dir);
            mess += ("You're new Location is: " + ts.getCurrentLocation().toString() + "\n");
            mess += ("The description of the Location is: " + ts.getCurrentLocation().getDescription() + "\n");
            mess += ("From here you can go: " + ts.getCurrentLocation().getDoors().toString() + "\n");
            mess += ("The Items at your location are " + ts.getCurrentLocation().getItemsInLocation().toString());
            return mess;
        }
    }

}
