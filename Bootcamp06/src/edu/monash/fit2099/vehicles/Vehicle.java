package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.Util;

/**
 * Abstract class that represents a Vehicle in the Auto showroom.
 *
 * @see BidsManager
 */
abstract public class Vehicle {
    /**
     * instance variable that represents the current name of the maker of the vehicle.
     */
    private String maker;
    /**
     * instance variable that represents the current name of the model of the vehicle.
     */
    private String model;
    /**
     * instance variable that represents the current vehicle ID.
     */
    private int VId;
    /**
     * instance variable that represents bids as an instance of BidsManager class
     */
    private BidsManager bids;

    /**
     * Constructor.
     *
     * @param maker The name of the maker of the Vehicle
     * @param model The name of the model of the Vehicle
     * @throws VehicleException throws a VehicleException if one of the vehicle objects catch's an exception.
     */
    public Vehicle(String maker, String model) throws VehicleException {
        if (setMaker(maker) && setModel(model)) {
            this.bids = new BidsManager();
            this.VId = Util.nextID();
        } else {
            throw new VehicleException("Incorrect Maker Or Model");
        }
    }

    /**
     * Constructor.
     *
     * @param maker The name of the maker of the Vehicle
     * @param model The name of the model of the Vehicle
     * @param VId   the current Vehicle ID
     * @throws VehicleException throws a VehicleException if one of the vehicle objects catch's an exception.
     */
    public Vehicle(String maker, String model, int VId) throws VehicleException {
        if (setMaker(maker) && setModel(model)) {
            this.bids = new BidsManager();
            this.VId = VId;
        } else {
            throw new VehicleException("Incorrect Maker Or Model");
        }
    }

    /**
     * Setter.
     *
     * @param maker The name of the Vehicle maker.
     * @return boolean isValid if the maker is a valid name.
     */
    public boolean setMaker(String maker) {
        boolean isValid = false;
        if (maker.length() >= 3 && maker.length() <= 15) {
            isValid = true;
            this.maker = maker;
        }
        return isValid;
    }

    /**
     * Setter.
     *
     * @param model The name of the Vehicle model.
     * @return boolean isValid if the model is a valid name.
     */
    public boolean setModel(String model) {
        boolean isValid = false;
        if (model.length() >= 3 && model.length() <= 15) {
            isValid = true;
            this.model = model;
        }
        return isValid;
    }

    /**
     * Getter.
     *
     * @return Current Vehicle ID.
     */
    public int getVId() {
        return VId;
    }


    /**
     * Method that gives a description of a Vehicle.
     *
     * @return Vehicle ID, maker name, and model name.
     */
    public String description() {
        return "|" + VId + "|" + maker + "|" + model + "|";

    }

    /**
     * Getter.
     *
     * @return The bids on a vehicle.
     */
    public BidsManager getBids() {
        return bids;
    }

    /**
     * Setter.
     *
     * @param bids The current bid to be added on a vehicle
     */
    public void setBids(BidsManager bids) {
        this.bids = bids;
    }

    /**
     * toString method
     *
     * @return concatenated string of instance variables
     */

    public String BidDescription(Vehicle v, int key) {
        return ("| Bid ID: " + v.getBids().hashMap.get(key).getBidId()
                + "| Buyer ID: " + v.getBids().hashMap.get(key).getBuyer().getBuyerId()
                + "| price: " + v.getBids().hashMap.get(key).getBidPrice()
                + "| Date: " + v.getBids().hashMap.get(key).getDateOfBid());
    }


}
