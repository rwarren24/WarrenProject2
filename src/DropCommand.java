/***
 * @author Ryan Warren
 * HonorPledge I have not given or received help on this assignment
 */

/***
 * The purpose of this class is to take directions and drop the item the user has specified
 */
public class DropCommand implements UserInputCommand{
    String itemName;

    /***
     * Paramitized constructor for the DropCommand class
     * @param itemName The String of the item name that the user is dropping
     */
    public DropCommand(String itemName){
        this.itemName = itemName;
    }

    /***
     * The carryOut command that is implemented from UserInputCommand that drops an item and from users backpack and puts it in their current location
     * @param ts the TourStatus object being used by the commands
     */
    @Override
    public String carryOut(TourStatus ts) {
        String mess = "";
        if(ts.dropItemFromBackpack(itemName) == null ){
            mess += ("You do not have that item in your backpack ");
            return mess;
        }
        else{
            mess += ("The " + ts.getCurrentLocation().getItemNamed(itemName) + " has been dropped in " + ts.getCurrentLocation().toString());
            return mess;
        }
    }
}
