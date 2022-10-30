/***
 * @author Ryan Warren
 *HonorPledge I have not given or received help on this assignment
 */


/***
 * The purpose of this class is to take directions and pickup the item specified by the user
 */
public class PickupCommand implements UserInputCommand{
    String itemName;

    /***
     * Paramitized constructor for the PickupCommand class
     * @param itemName The String of the item that is to be picked up
     */
    public PickupCommand(String itemName){
        this.itemName = itemName;
    }

    /***
     * The carryOut command that is implemented from UserInputCommand that picks up an item and puts it in the users backpack
     * @param ts the TourStatus object being used by the commands
     */
    @Override
    public String carryOut(TourStatus ts) {
        String mess = "";
        if(ts.getCurrentLocation().getItemNamed(itemName) == null){
            mess += ("The item you listed is not at this Location ");
            return mess;
        }
        else{
            ts.addToBackpack(ts.getCurrentLocation().getItemNamed(itemName));
            mess += ("You added " + ts.getCurrentLocation().getItemNamed(itemName).toString());
            return mess;
        }
    }
}
