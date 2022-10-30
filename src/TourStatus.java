/***
 * @author Ryan Warren
 * HonorPledge I have not given or received help on this assignment
 */

import java.util.ArrayList;

/***
 * The purpose of this class is to take directions and update the current location of the tour
 */
public class TourStatus {
    private Campus campus = new Campus();
    private Location currentLocation = new Location();

    ArrayList<Item> backpack = new ArrayList<Item>();

    /***
     * Default Contructor for the TourStatus Class
     */
    public TourStatus(){

    }

    /***
     * This method is a setter for setting the campus
     * @param campus Campus Object to Tour
     */
    public void setCampus(Campus campus){
            this.campus = campus;
    }

    /***
     * This is a getter that returns the Campus that is being toured
     * @return Campus Object that is being toured
     */
    public Campus getCampus(){
        return this.campus;
    }

    /***
     * A setter to set the current location of the tour
     * @param location Current Location of the tour
     */
    public void setCurrentLocation(Location location){
        currentLocation = location;
    }

    /***
     * A getter to get the current location of the tour
     * @return the current location of the tour
     */
    public Location getCurrentLocation(){
        return currentLocation;
    }

    /***
     * A method to update the currentLocation of the tour based on user input, will not update the location if there are no doors to leave from.
     * @param dir The direction that the user has inputed.
     */
    public void updateTourLocation(String dir){
       if(currentLocation.leaveLocation(dir).getName() == null){

       }
       else{
           campus.getLocation(currentLocation.getName()).setHasVisited(true);
           currentLocation = currentLocation.leaveLocation(dir);
       }

    }

    /***
     * This is a method that adds an item to the ArrayList of items called backpack
     * @param item the item being added to the backpack
     */
    public void addToBackpack(Item item){
        backpack.add(item);
    }
    /***
     * This is a method that removes an item to the ArrayList of items called backpack
     * @param item the item being removed from the backpack
     */
    public void removeFromBackpack(Item item){
        backpack.remove(item);
    }
    /***
     * This is a method that drops an item from the backpack and puts it in a Location
     * @param name the name of the item being dropped
     */
    public Item dropItemFromBackpack(String name){
        for(int i = 0; i < backpack.size(); i++){
            if(backpack.get(i).getName().equals(name) == true){
                currentLocation.addItem(backpack.get(i));
                backpack.remove(i);
                return currentLocation.getItemNamed(name);
            }
            else{
                return null;
            }
        }
        return null;
    }
}

