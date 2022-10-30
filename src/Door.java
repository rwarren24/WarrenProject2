/**
 * @author Ryan Warren
 * @HonorPledge I have not given or received help on this assignment
 */

/***
 * A class that stores the door objects of a location
 */
public class Door {
    private String direction;
    private Location leavingLocation = new Location();
    private Location enteringLocation = new Location();

    /***
     * Default Constructor for Door Class
     */
    public Door(){

    }

    /***
     * Paramitized Contructor for the Door Class
     * @param dir Direction of the door
     * @param leave The building that the user would be leaving if they left through the door(aka the building the user is in)
     * @param enter The building that the user would be entering if they left through the door
     */
    public Door(String dir, Location leave, Location enter){
        direction = dir;
        leavingLocation = leave;
        enteringLocation = enter;

    }

    /***
     * Describes the door's direction and the location you would enter
     * @return the doors direction and building you would enter
     */
    public String describe(){
        return ("If you go " + direction + " You will get to " + enteringLocation);
    }

    /***
     * A getter for the location that you are leaving
     * @return the location you are leaving
     */
    public Location getLeaving(){
        return leavingLocation;
    }

    /***
     * A setter to set the location you are leaving
     * @param leave the location set to the one you are leaving
     */
    public void setLeaving(Location leave){
        leavingLocation = leave;
    }

    /***
     * A getter to get the location you are entering
     * @return the location you are entering
     */
    public Location getEntering(){

        return enteringLocation;
    }

    /***
     * A setter to set the location you are entering
     * @param enter the location that is being set to entering
     */
    public void setEntering(Location enter){
        enteringLocation = enter;
    }

    /***
     * A getter to get the direction of the door
     * @return the direction of the door
     */
    public String getDirection(){
        return direction;
    }

    /***
     * A setter to set the direction of the door
     * @param dir the direction that the door will be set to
     */
    public void setDirection(String dir){
        direction = dir;
    }

    /***
     * A method that returns the direction of the door and the building you would enter
     * @return the direction of the door and the building you would enter
     */
    public String toString(){
        return ("Direction of Door: " + direction  + " Building you would enter: " + enteringLocation.getName());
    }
}
