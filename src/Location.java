/**
 * @author Ryan Warren
 * HonorPledge I have not given or received help on this assignment
 */
import java.util.*;

/***
 * A class that stores all the locations within the Campus Object
 */
public class Location {

    private String name;
    private String description;
    private Boolean hasVisited = false;
    private Boolean isOutside = null;
    private ArrayList<Door> doors = new ArrayList<Door>();
    private ArrayList<Item> items = new ArrayList<Item>();

    /***
     * Default Constructor for Location Class
     */
    public Location(){

    }

    /***
     * Paramiztized Contructor for Location Class
     * @param name sets the name of the location
     * @param description sets the description of the location
     */
    public Location(String name, String description){
            this.name = name;
            this.description = description;
    }

    /***
     * A getter to return the name of the location
     * @return the name of the location
     */
    public String getName(){
        return name;
    }

    /***
     * A setter to set the name of the location
     * @param n the name of the location
     */

    public void setName(String n){
        this.name = n;
    }

    /***
     * A getter to get the description of the location
     * @return the description of the location
     */
    public String getDescription(){
        return description;
    }

    /***
     * A setter to set the description of the location
     * @param d the description of the location
     */
    public void setDescription(String d){
        description = d;
    }

    /***
     * A getter to get the list of doors within the location
     * @return A string of doors within the location
     */
    public String getDoors(){
        return doors.toString();
    }

    /***
     * A method that tests all the possible doors to exit from and if the user input alligns with a door
     * @param dir user inputed direction
     * @return the location of what the user inputed door leads to, or the location that the user is in as they cant leave through the direction they inputed
     */
    public Location leaveLocation(String dir) {
        Door test = new Door();
            for (int i = 0; i <= doors.size()-1; i++) {
                String l = doors.get(i).getDirection();
                if (l.equals(dir)) {
                    test = doors.get(i);
                } else {
                }
            }
            return test.getEntering();
    }

    /***
     * A method that adds a door object to the location
     * @param door the door that is going to be added
     */
    public void addDoor(Door door){
        doors.add(door);
    }

    /***
     * A method that changes the value to true if the user has been to this location
     * @param b The true value that the user has been to this location
     */
    public void setHasVisited(Boolean b){
        hasVisited = b;
    }

    /***
     * A method that returns if the user has visited this location
     * @return True if the user has visiting this location, or false if they havent
     */
    public Boolean getHasVisited(){
        return hasVisited;
    }

    /***
     * A method that adds an item to a location
     * @param item the item being added to the location
     */
    public void addItem(Item item){
        items.add(item);
    }
    /***
     * A method that removes an item to a location
     * @param item the item being removed to the location
     */
    public void removeItem(Item item){
        items.remove(item);
    }

    /***
    A method that returns an item from the list based on its name
    @return item named
    @param name The name of the item
     */
    public Item getItemNamed(String name){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equals(name) == true) {
                return items.get(i);
            }
        }
        return null;
    }
    /***
     * A method that gets all the items in a location
     * @return all the items in the location
     */
    public String getItemsInLocation(){
        return items.toString();
    }
    /***
     * A Method that makes a list of the name of this location
     * @return The names of this location
     */
    public String toString(){
        return "Name: " + name;
    }
}
