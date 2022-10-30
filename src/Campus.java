/**
 * @author Ryan Warren
 * @HonorPledge I have not given or received help on this assignment
 */

import java.util.*;

/***
 * This is a class that stores Campus Objects that are used to tour
 */
public class Campus {
    private String campusName;
    private Hashtable<String,Location> locations = new Hashtable<String,Location>();
    private Location startingLocation = new Location();
    private String fileName;

    /***
     * Default Contructor for the Campus Class
     */
    public Campus(){

    }

    /***
     * Paramitized Contructor for the Campus Class
     * @param name Name of the Campus
     * @param entry All the Locations the Campus has
     */
    public Campus(String name, Location entry){
        startingLocation = entry;
        campusName = name;
        locations.put(entry.getName(), entry);
    }

    /***
     * Method that adds a location object to the Campus Object
     * @param location Location that is being added to the Campus
     */
    public void addLocation(Location location){
        locations.put(location.getName(),location);
    }

    /***
     * Method that gets a certain location being stored in the Campus Object
     * @param name The name of the location wanted
     * @return The location matching that name
     */
    public Location getLocation(String name){
        return locations.get(name);
    }

    /***
     * Method to remove a location from the Campus Object
     * @param name The name of the location that is going to be removed
     */
    public void removeLocation(String name){
        locations.remove(name);
    }

    /***
     * A setter to set the Campus Object's name
     * @param n The name of the Campus
     */
    public void setCampusName(String n){
        campusName = n;
    }

    /***
     * A getter to return the Campus Object's name
     * @return The Campus's name
     */
    public String getCampusName(){

        return campusName;
    }

    /***
     * A setter to set the starting location of the tour
     * @param start The starting location of the tour
     */
    public void setStartLocation(Location start){
        startingLocation = start;
    }

    /***
     * A getter to return the starting location of the tour
     * @return the starting location of the tour
     */
    public Location getStartLocation(){

        return startingLocation;
    }

    /***
     * A setter that sets the file name of the Campus Object that will be read
     * @param f the file name
     */
    public void setFileName(String f){

        fileName = f;
    }

    /***
     * A getter that returns that name of the file the user passed in
     * @return the file name
     */
    public String getFileName(){

        return fileName;
    }

    /***
     * A method that lists the locations of the Campus object into a set of strings
     * @return the list of locations in the Campus object
     */
    public String toString(){
        return ("Locations: " + locations);
    }

    }

