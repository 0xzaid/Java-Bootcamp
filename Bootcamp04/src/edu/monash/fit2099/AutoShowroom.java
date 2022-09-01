package edu.monash.fit2099;

import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AutoShowroom {

    ArrayList<Vehicle> vehicle_array = new ArrayList<>();
    ArrayList<Buyer> buyer_array = new ArrayList<>();

    public void printStatus() {
        System.out.println("Welcome to FIT2099 Showroom");
        menuOptions();
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    public void menuOptions() {

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
//              BidsManager.addBid(buyerID, price, bid_dob);
            }
        } while (selection != 7);
    }

    public void createSedan() {
        Sedan sedan = new Sedan(readString("Make: "), readString("Model: "), Sedan.nextID(),
                readInteger("Seats: "));
        System.out.println(sedan.description());
        vehicle_array.add(sedan);

    }

    public void createTruck() {
        Truck truck = new Truck(readString("Make: "), readString("Model: "), Truck.nextID(), readInteger("Capacity: "),
                readInteger("Wheels: "));
        System.out.println(truck.description());
        vehicle_array.add(truck);

    }

    public void displayFleet() {
        String result = "";
        for (Vehicle vehicle : vehicle_array)
            if (vehicle.getBids() == null)
                System.out.println(vehicle.description() + "{" + "}");
            else {
                for (int key : vehicle.getBids().getHashMap().keySet())
                    result +=
                            vehicle.description() + " BidId: " +
                                    vehicle.getBids().getHashMap().get(key).getBidId()
                                    + "| BuyerId: " + key + " |" +
                                    "Price: " + vehicle.getBids().getHashMap().get(key).getBidPrice() +
                                    " |" + "Date: " + vehicle.getBids().getHashMap().get(key).
                                    getDateOfBid() + " |\n";
//                           "Buyerid: " + vehicle.getBids().getHashMap().get(vehicle.getVId()).getBuyer().getBuyerId() + "|" +
//                            "Date: " + vehicle.getBids().getHashMap().get(vehicle.getVId()).getDateOfBid() + "|" +
//                            "Price: " + vehicle.getBids().getHashMap().get(vehicle.getVId()).getBidPrice()+ "|";
            }
        System.out.println(result);

//                    "BidID: " +vehicle.getBids().getHashMap().get(vehicle.getVId()).getBidId() + "|" +
//                    "Buyerid: " + vehicle.getBids().getHashMap().get(vehicle.getVId()).getBuyer().getBuyerId() + "|" +
//                    "Date: " + vehicle.getBids().getHashMap().get(vehicle.getVId()).getDateOfBid() + "|" +
//                     "Price: " + vehicle.getBids().getHashMap().get(vehicle.getVId()).getBidPrice()+ "|");
//        for (Vehicle v : vehicle_array)
//            if(v.getBids().getHashMap() != null) {
//                System.out.println(v.getBids().hashMap.values());
    }

    public void displayBuyers() {
        for (Buyer buyer : buyer_array)
            System.out.println(buyer.description());
    }

    public void createBuyer() {
        Buyer buyer = new Buyer(Buyer.nextID(), readString("Given name: "), readString("Family name: "));
        System.out.println(buyer.description());
        buyer_array.add(buyer);

    }

    public void createBid() {
//        String result;
//        String result2;
//        for (int i = 0; i < vehicle_array.size(); i++) {
//            result = "Vehicle (" + i + ") " + vehicle_array.get(i).description();
//            System.out.println(result);

        int vID = readInteger("Enter Vehicle ID: ");
        int buyerID = readInteger("Enter the buyer ID: ");
        String bid_dob = readString("Enter the bid date: ");
        int price = readInteger("Enter the bid price: ");
        BidsManager bidsManager = new BidsManager();
        for (Vehicle i : vehicle_array)
            if (i.getVId() == vID) {
                for (Buyer a : buyer_array)
                    if (a.getBuyerId() == buyerID)
                        bidsManager.addBid(buyerID, price, bid_dob);
                i.setBids(bidsManager);
                //System.out.println(i.getBids().hashMap.values());


            }
    }


//    public void displayCars() {
//        // turn each object into string and display it
//        String result;
//        String result2;
//        for (int i = 0; i < vehicle_array.size(); i++) {
//            result = "edu.monash.fit2099.vehicles.Vehicle (" + i + ") " + vehicle_array.get(i).description();
//
//            System.out.println(result);
//            for (int j = 0; j < vehicle_array.get(i).bids.size(); j++) {
//                result2 = "edu.monash.fit2099.buyers.Buyer: " + vehicle_array.get(i).bids.get(j).getBuyer().givenName +
//                        "\nedu.monash.fit2099.bids.Bid price: " + vehicle_array.get(i).bids.get(j).bidPrice;
//                System.out.println(result2);
//            }
//        }
//    }

    public int Menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("1) New sedan");
        System.out.println("2) New truck");
        System.out.println("3) Display Fleet");
        System.out.println("4) Add Buyer");
        System.out.println("5) List Buyers");
        System.out.println("6) Add Bid");
        System.out.println("7) Exit");
        System.out.println("--------------------");
        System.out.print("Select an option: ");
        return scanner.nextInt();

    }

    public String readString(String prompt) {
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        String s;
        s = input.nextLine();
        return s;
    }

    public int readInteger(String prompt) {
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        int i;
        i = input.nextInt();
        return i;
    }
}