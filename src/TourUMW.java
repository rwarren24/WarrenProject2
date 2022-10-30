/***
 * @author Ryan Warren
 * HonorPledge I have not given or received help on this assignment
 */

import java.util.*;
import java.io.*;
/***
 * The purpose of this class is to start the tour of the campus.
 */
public class TourUMW {
    /***
     *  Main Method that starts the tour of the campus and prompts the user to enter directions or quit.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        TourUMW test = new TourUMW();
        Campus tester = new Campus();
        TourStatus camp = new TourStatus();
        Scanner s = new Scanner(System.in);
        tester = test.setUpCampus(s);
        camp.setCampus(tester);
        camp.setCurrentLocation(tester.getStartLocation());
        int i = 0;
        System.out.println("Your starting locations: " + camp.getCurrentLocation().toString());
        System.out.println("The description of the Location is " + camp.getCurrentLocation().getDescription());
        System.out.println("From here you can go: " + camp.getCurrentLocation().getDoors().toString());
        System.out.println("The Items at your locations are " + camp.getCurrentLocation().getItemsInLocation().toString());
        while(i < 1){
            UserInputCommand command = test.promptUser(s);
            if(command == null){
                System.out.println("You have ended the program ");
                i++;
            }
            else{
                System.out.println(command.carryOut(camp));
            }
        }



    }

    /***
     *  Method that creates the Campus Object by reading the input file and parsing through it. When reading the file it creates location and door and item objects.
     * @param s this is first the user input of the files name then it becomes the file
     * @return this returns a fully created campus object
     * @throws IOException
     */
    public Campus setUpCampus(Scanner s) throws IOException {
        Campus Temp = new Campus();
        System.out.println("Enter a file name: ");
        Temp.setFileName(s.nextLine());
        s = new Scanner(new File(Temp.getFileName().trim()));
        Temp.setCampusName(s.nextLine());
        String desc = new String();
        String start = new String();
        String local = new String();
        String local2 = new String();
        String DLname = new String();
        String Ddir = new String();
        String DEname = new String();
        String type = "Locations:";
        String item1 = new String();
        String message = new String();

            while (s.hasNextLine()) {
                String line = s.nextLine();
                if(line.equals("*****") == true && s.hasNextLine() == true) {
                    if(s.nextLine().equals("Locations:") == true){
                        local = s.nextLine();
                        start = local;
                    }
                    else{
                    }
                }
                else if(line.equals("+++") == true && type.equals("Locations:") == true){
                        local2 = s.nextLine();
                        if(local2.equals("*****") == true){
                            type = "Doors:";
                            s.nextLine();
                            Temp.addLocation(new Location(local,desc));
                            DLname = s.nextLine();
                            Ddir = s.nextLine();
                            DEname = s.nextLine();
                        }
                        else {
                            Temp.addLocation(new Location(local,desc));
                            local = local2;
                            desc = "";
                        }
                    }
                else if(line.equals("+++") == true && type.equals("Doors:") == true){
                    String end = s.nextLine();
                    if(end.equals("*****") == true){
                        s.nextLine();
                        Temp.getLocation(DLname).addDoor(new Door(Ddir, Temp.getLocation(DLname), Temp.getLocation(DEname)));
                        type = "Items:";
                        item1 = s.nextLine();
                        local = s.nextLine();
                        message = s.nextLine();
                    }
                    else if(s.hasNextLine() == true) {
                        Temp.getLocation(DLname).addDoor(new Door(Ddir, Temp.getLocation(DLname), Temp.getLocation(DEname)));
                        DLname = end;
                        Ddir = s.nextLine();
                        DEname = s.nextLine();
                    }
                }
                else if(line.equals("+++") == true && type.equals("Items:")){
                    local2 = s.nextLine();
                    if(local2.equals("*****") && s.hasNextLine() == false){

                    }
                    else {
                        Temp.getLocation(local).addItem(new Item(item1, message));
                        item1 = local2;
                        local = s.nextLine();
                        message = s.nextLine();
                    }
                }
                else{
                    desc += " " + line;
                }
                }
            Temp.setStartLocation(Temp.getLocation(start));
            Temp.getLocation(local).addItem(new Item(item1, message));
        return Temp;
    }

    /***
     * This is a method that prompts the user for a direction
     * @param input this is a scanner that is used to take in the user input for the directions.
     * @return This returns a UserInputCommand reference to the appropriate command object
     */
    public UserInputCommand promptUser(Scanner input){
            System.out.println("Enter a Direction(n,s,e,w), an action(pickup/drop/backpack) or q to quit");
            String r = input.nextLine();
            UserInputCommand command;
            if(r.equals("n") || r.equals("s") || r.equals("e") || r.equals("w")){
                command = new MovementCommand(r);
                return command;
            }
            else if(r.equals("pickup") || r.equals("p")) {
                Scanner l = new Scanner(System.in);
                System.out.println("Please enter the item you would like to grab");
                String wanteditem = l.nextLine();
                command = new PickupCommand(wanteditem);
                return command;
            }
            else if(r.equals("drop") || r.equals("d")){
                Scanner l = new Scanner(System.in);
                System.out.println("Please enter the item you would like to drop");
                String droppeditem = l.nextLine();
                command = new DropCommand(droppeditem);
                return command;
            }
            else if(r.equals("backpack") || r.equals("b")){
                command = new BackpackCommand();
                System.out.println("The Items in your backpack are: ");
                return command;
            }
            else if(r.equals("q")){
                return null;
            }
            else {
                command = new InvalidCommand(r);
                return command;
            }
        }

    }

