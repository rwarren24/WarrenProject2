/**
 * @author Ryan Warren
 * HonorPledge I have not given or received help on this assignment
 */
import java.util.*;

/***
 * The purpose of this class is to store items from a location and or the users backpack
 */
public class Item {
    private String name;
    private String message;
    /***
     * Default constructor for Item class
     */
    public Item(){
    }
    /***
     * Paramitized constructore for Item class
     * @param s Scanner that can be used to create an item
     */
    public Item(Scanner s){

    }
    /***
     * Paramitized constructore for Item class
     * @param name the name of the item being created
     * @param message message that accompanies the item
     */
    public Item(String name, String message){
        this.name = name;
        this.message = message;
    }
    /***
     * A getter to get the items name
     *
     */
    public String getName(){
        return name;
    }
    /***
     * A setter to set the items name
     * @param name the items name
     */
    public void setName(String name){
        this.name = name;
    }
    /***
     * A getter to get the items message
     *
     */
    public String getMessage(){
        return message;
    }
    /***
     * A setter to set the items message
     * @param message the items name
     */
    public void setMessage(String message){
        this.message = message;
    }
    /***
     * A method to return the name and description of the item and its message
     *
     */
    public String toString(){
        return ("The Item: " + name + " Description: " + message);
    }
}
