package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;

/**
 * This class represents a Truck and inherits from Vehicle class
 *
 * @see Vehicle
 */
public class Truck extends Vehicle {
    /**
     * This instance variable represents the current capacity of the truck.
     */
    private int capacity;
    /**
     * This instance variable represents the current number of wheels of the truck.
     */
    private int wheels;


    /**
     * Constructor.
     *
     * @param maker The name of the maker of the Truck
     * @param model The name of the Model of the Truck
     * @param capacity The load capacity of the Truck in tons.
     * @param wheels The number of wheels the truck has.
     * @throws VehicleException throws a VehicleException if one of the vehicle objects catch's an exception.
     */
    public Truck(String maker, String model, int capacity, int wheels) throws VehicleException {
        super(maker, model, nextID());
        if (setCapacity(capacity) && setWheels(wheels)) {
            this.capacity = capacity;
            this.wheels = wheels;
        } else {
            throw new TruckException("Incorrect capacity or wheels");
        }
    }


    /**
     * Constructor.
     *
     * @param maker The name of the maker of the Truck
     * @param model  The name of the Model of the Truck
     * @param VId the current Vehicle ID
     * @param capacity The load capacity of the Truck in tons.
     * @param wheels The number of wheels the truck has.
     * @throws VehicleException throws a VehicleException if one of the vehicle objects catch's an exception.
     */
    public Truck(String maker, String model, int VId, int capacity, int wheels) throws VehicleException {
        super(maker, model, VId);
        if (setCapacity(capacity) && setWheels(wheels)) {
            this.capacity = capacity;
            this.wheels = wheels;
        } else {
            throw new TruckException("Incorrect capacity or wheels");
        }
    }

    /**
     * Setter.
     *
     * @param capacity Current capacity of truck in tons.
     * @return boolean isValid if capacity is valid.
     */
    public boolean setCapacity(int capacity) {
        boolean isValid = false;
        if (capacity >= 1 && capacity <= 15) {
            isValid = true;
            this.capacity = capacity;
        }
        return isValid;
    }

    /**
     * Setter.
     *
     * @param wheels current number of wheels of truck
     * @return boolean isValid if wheels is valid.
     */
    public boolean setWheels(int wheels) {
        boolean isValid = false;
        if (wheels >= 4 && wheels <= 16) {
            isValid = true;
            this.wheels = wheels;
        }
        return isValid;
    }

}
