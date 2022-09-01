package edu.monash.fit2099;

import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.*;

/**
 * This class contains all the methods that involve the interaction between the user and the program
 *
 * @author Zaid Al-Dirbashi
 * @version 1.5.4
 * @see Vehicle
 * @see Truck
 * @see Sedan
 * @see Bid
 * @see Buyer
 * @see BidsManager
 * @since Week 1 of Semester 1 of 2021.
 */

public class AutoShowroom {

    /**
     * Array where Vehicle objects are stored.
     */
    private ArrayList<Vehicle> vehicle_array = new ArrayList<>();

    /**
     * Array where sold vehicles are stored
     */
    private ArrayList<Vehicle> sold_array = new ArrayList<>();

    /**
     * Array where Buyer objects are stored.
     */
    private ArrayList<Buyer> buyer_array = new ArrayList<>();

    /**
     * Welcomes user to the auto showroom and calls menuOptions(), which lists the all menu options a user can input.
     * Then prints a goodbye message.
     *
     * @throws BidException throws a BidException if one of the bid objects catch's an exception.
     */
    public void printStatus() throws BidException {
        System.out.println("-----------------------------" +
                "\nWelcome to FIT2099 Showroom");
        menuOptions();
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    /**
     * Displays menu options and what they can do
     *
     * @throws BidException throws a BidException if one of the bid objects catch's an exception.
     */
    public void menuOptions() throws BidException {

        int selection;
        do {
            selection = Menu();
            switch (selection) {
                case 1 -> createSedan();
                case 2 -> createTruck();
                case 3 -> displayFleet();
                case 4 -> createBuyer();
                case 5 -> displayBuyers();
                case 6 -> createBid();
                case 7 -> bestBid();
                case 8 -> worstBid();
                case 9 -> deleteBid();
                case 10 -> soldVehicles();
            }
        } while (selection != 11);
    }

    /**
     * This method allows the user to input integers into the system to indicate what option they have chosen
     *
     * @return integer value input by user
     */
    public int Menu() {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("1) New sedan");
        System.out.println("2) New truck");
        System.out.println("3) Display Fleet");
        System.out.println("4) Add Buyer");
        System.out.println("5) List Buyers");
        System.out.println("6) Add Bid");
        System.out.println("7) Best bid on vehicle");
        System.out.println("8) Worst bid on vehicle");
        System.out.println("9) Delete Bid");
        System.out.println("10) List sold vehicles");
        System.out.println("11) Exit");
        System.out.println("-----------------------------");
        System.out.print("Select an option: ");
        try {
            result = Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("Must input integers only.");
        } catch (NumberFormatException e) {
            System.out.println("Must input integers only.");
        }
        return result;
    }

    /**
     * Creates a Sedan object from user's input then adds it to the vehicle_array
     * Allows user to input the make, model, and seats.
     */
    public void createSedan() {
        try {
            Sedan sedan = new Sedan(readString("Make: "), readString("Model: "), Util.nextID(),
                    readInteger("Seats: "));
            System.out.println(sedan.description());
            vehicle_array.add(sedan);
        } catch (SedanException e) {
            System.out.println(e.getMessage() + "\nTry Again.");
        } catch (VehicleException e) {
            System.out.println(e.getMessage() + "\nTry Again.");
        }
    }

    /**
     * Creates a Truck object from user's input then adds it to the vehicle_array.
     * Allows user to input the make, model, capacity and wheels.
     */
    public void createTruck() {
        try {
            Truck truck = new Truck(readString("Make: "), readString("Model: "), Util.nextID(), readInteger("Capacity: "),
                    readInteger("Wheels: "));
            System.out.println(truck.description());
            vehicle_array.add(truck);
        } catch (TruckException e) {
            System.out.println(e.getMessage() + "\nTry Again.");
        } catch (VehicleException e) {
            System.out.println(e.getMessage() + "\nTry Again.");
        }
    }

    /**
     * Display's all vehicles in the vehicle_array with their description.
     * If a vehicle has a bid on it, the details of the bid will be displayed too
     */
    public void displayFleet() {
        for (Vehicle v : vehicle_array) {
            if (v instanceof Sedan) {
                Sedan sedan = (Sedan) v;
                System.out.println(sedan.description());
            } else if (v instanceof Truck) {
                Truck truck = (Truck) v;
                System.out.println(truck.description());
            }
            for (int key : v.getBids().getHashMap().keySet()) {
                System.out.println(v.BidDescription(v, key));
            }
        }
    }


    /**
     * Display list of buyers and with their description
     */
    public void displayBuyers() {
        for (Buyer buyer : buyer_array)
            System.out.println(buyer.description());
    }

    /**
     * Create Buyer object and add it to buyer_array
     */
    public void createBuyer() {
        Buyer buyer = Buyer.getInstance(readString("Given name: "), readString("Family name: "));
        if (buyer != null) {
            buyer_array.add(buyer);
            buyer.setBuyerId();
            System.out.println(buyer.description());
        } else
            System.out.println("Something wrong with the buyer's values!!!");

    }

    /**
     * Create Bid object and add it using BidsManager's addBid() method
     *
     * @throws BidException throws a BidException if one of the bid objects catch's an exception.
     * @see BidsManager
     */
    public void createBid() throws BidException {
        try {
            int vID = readInteger("Enter Vehicle ID: ");
            int buyerID = readInteger("Enter the buyer ID: ");
            String date = readString("Enter the bid date: ");
            int price = readInteger("Enter the bid price: ");

            Vehicle v = getVehicle(vID);
            v.getBids().addBid(new Bid(Util.nextID(), getBuyers(buyerID), price, date));

        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException:Must input Integer Only.\nTry again.");
            createBid();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Must input Integer Only.\nTry again.");
            createBid();
        }
    }

    /**
     * Getter.
     *
     * @param id Vehicle ID
     * @return Vehicle object with the same Vehicle ID
     */
    public Vehicle getVehicle(int id) {
        for (Vehicle v : vehicle_array) {
            if (v.getVId() == id) {
                return v;
            }
        }
        return null;
    }

    /**
     * Method that print's the best bid price on a particular vehicle based on it's Vehicle ID. And if highest bid
     * should be sold, then it is sold by calling Sell() method.
     */

    public void bestBid() {
        try {
            boolean isValid = false;
            int vID = readInteger("Which car's highest bid would you like to see? ");
            //go through all vehicles
            for (Vehicle v : vehicle_array) {
                if (v.getVId() == vID) {
                    isValid = true;
                }
                if (isValid) {
                    int temp = 0;
                    for (int key : v.getBids().hashMap.keySet()) {
                        //System.out.println(key);
                        if (v.getBids().hashMap.get(key).getIntPrice() >= temp)
                            temp = v.getBids().hashMap.get(key).getIntPrice();
                    }
                    for (int key2 : v.getBids().hashMap.keySet()) {
                        if (v.getBids().hashMap.get(key2).getIntPrice() >= temp)
                            temp = v.getBids().hashMap.get(key2).getIntPrice();
                    }
                    System.out.println("The highest bid on " + v.description() + " is $" + temp);
                    int sold = readInteger("Sell? \n0) No\n1) Yes\n");
                    if(sold == 1) {
                        Sell(v);
                        break;
                    } else
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException:Must input Integer Only.\nTry again.");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Must input Integer Only.\nTry again.");
        }
    }

    /**
     * Method that print's the worst bid price on a particular vehicle based on it's Vehicle ID.
     */
    public void worstBid() {
        try {
            boolean isValid = false;
            int vID = readInteger("Which car's worst bid would you like to see? ");
            //go through all vehicles
            for (Vehicle v : vehicle_array) {
                if (v.getVId() == vID) {
                    isValid = true;
                }
                if (isValid) {
                    int temp = 0;
                    for (int key : v.getBids().hashMap.keySet()) {
                        //System.out.println(key);
                        if (v.getBids().hashMap.get(key).getIntPrice() >= temp)
                            temp = v.getBids().hashMap.get(key).getIntPrice();
                        break;
                    }
                    for (int key2 : v.getBids().hashMap.keySet()) {
                        if (v.getBids().hashMap.get(key2).getIntPrice() <= temp)
                            temp = v.getBids().hashMap.get(key2).getIntPrice();
                    }
                    System.out.println("The highest bid on " + v.description() + " is $" + temp);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException:Must input Integer Only.\nTry again.");

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Must input Integer Only.\nTry again.");
        }
    }

    /**
     * method that sells a vehicle by removing it from the vehicle array and placing into an array of sold vehicles.
     *
     * @param v Vehicle object to be sold
     */
    public void Sell(Vehicle v) {
        Iterator<Vehicle> iter = vehicle_array.iterator();

        while (iter.hasNext()) {
            Vehicle veh = iter.next();

            if (veh.getVId() == v.getVId()) {
                iter.remove();
                sold_array.add(v);
            }
        }
        System.out.println(v.description() + " is sold!!");
    }

    /**
     * Method that prints all the sold vehicles
     */
    public void soldVehicles() {
        for (Vehicle v : sold_array) {
            System.out.println(v.description());
        }
    }

    /**
     * Getter.
     *
     * @param bID Buyer ID
     * @return buyer Object with same Buyer Id in param
     */
    public Buyer getBuyers(int bID) {
        for (Buyer b : buyer_array) {
            if (b.getBuyerId() == bID) {
                return b;
            }
        }
        return null;
    }

    /**
     * Method that deletes a bid based on the Bid Id.
     */
    public void deleteBid() {
        try {
            int bidID = readInteger("Which bid do you want to delete? ");
            for (Vehicle v : vehicle_array) {
                for (int key : v.getBids().hashMap.keySet()) {
                    System.out.println(key);
                    if (v.getBids().hashMap.get(key).getBidId() == bidID) {
                        System.out.println("Deleted " + v.getBids().hashMap.remove(key).getBidId());
                        v.getBids().hashMap.remove(key);
                    }
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException:Must input Integer Only.\nTry again.");

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Must input Integer Only.\nTry again.");
        }
    }


    /**
     * A method to print a string in the form of a prompt to tell the user what to input, and then
     * get input in the form of a string in response
     *
     * @param prompt which can be any string to indicate to user what to input
     * @return String input by user
     */
    public String readString(String prompt) {
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        String s;
        s = input.nextLine();
        return s;
    }

    /**
     * A method to print a string in the form of a prompt to tell the user what to input, and then get input in
     * the form of an integer in response
     *
     * @param prompt which can be any string to indicate to user what to input
     * @return Integer input by user
     */
    public int readInteger(String prompt) {
        int i;
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        i = Integer.parseInt(input.nextLine());
        return i;
    }
}
