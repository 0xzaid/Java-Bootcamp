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

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
            }
        } while (selection != 7);
    }

    /**
     * Creates a Sedan object from user's input then adds it to the vehicle_array
     * Allows user to input the make, model, and seats.
     */
    public void createSedan() {
        try {
            Sedan sedan = new Sedan(readString("Make: "), readString("Model: "), Sedan.nextID(),
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
            Truck truck = new Truck(readString("Make: "), readString("Model: "), Truck.nextID(), readInteger("Capacity: "),
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
        String result = "";
        for (Vehicle vehicle : vehicle_array) {
            if (vehicle instanceof Sedan) {
                Sedan sedan = (Sedan) vehicle;
                System.out.println(sedan.description());
            } else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                System.out.println(truck.description());
            }
            for (int key : vehicle.getBids().getHashMap().keySet()) {
                result +=
                        vehicle.description() + " BidId: " +
                                vehicle.getBids().getHashMap().get(key).getBidId()
                                + "| BuyerId: " + key + " |" +
                                "Price: " + vehicle.getBids().getHashMap().get(key).getBidPrice() +
                                " |" + "Date: " + vehicle.getBids().getHashMap().get(key).
                                getDateOfBid() + " |\n";
            }
            //System.out.println(result);
        }
        System.out.println(result);
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
            BidsManager bidsManager = new BidsManager();
            for (Vehicle vehicle : vehicle_array)
                if (vehicle.getVId() == vID) {
                    for (Buyer buyer1 : buyer_array)
                        if (buyer1.getBuyerId() == buyerID) {
                            Bid bid = new Bid(Bid.nextID(), buyer1, price, date);
                            Buyer buyer = Buyer.getInstance(buyer1.getGivenName(), buyer1.getFamilyName());
                            assert buyer != null;
                            buyer.setBuyerId(buyerID);
                            bidsManager.addBid(buyerID, bid);
                        }
                    vehicle.setBids(bidsManager);
                }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException:Must input Integer Only.\nTry again.");
            createBid();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Must input Integer Only.\nTry again.");
            createBid();
        }
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
        System.out.println("7) Exit");
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
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        int i;
        i = Integer.parseInt(input.nextLine());
        return i;
    }
}
