package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.buyers.Buyer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

abstract public class Vehicle {
    //instance variables
    private String maker;
    private String model;
    private int VId;
    public BidsManager bids;

    public Vehicle(String maker, String model) {
        this.maker = maker;
        this.model = model;
        nextID();
    }

    public int getVId() {
        return VId;
    }

    public Vehicle(String maker, String model, int VId) {
        this.maker = maker;
        this.model = model;
        this.VId = VId;
    }

    public static int nextID() {
        Random r = new Random();
        int low = 10000;//using literal values is not a good idea, replace them with input parameters
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public String description() {
        return "|" + VId + "|" + maker + "|" + model + "|";

    }

    public BidsManager getBids() {
        return bids;
    }

    public void setBids(BidsManager bids) {
        this.bids = bids;
    }
//    public void addBid(Buyer newBuyer, int price, String date) {
//        BidsManager.addBid(new Bid(null, newBuyer, price, date));
//    }

}