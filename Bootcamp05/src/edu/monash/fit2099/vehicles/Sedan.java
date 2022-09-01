package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.VehicleException;

/**
 * This class represents a Sedan and inherits from Vehicle class
 *
 * @see Vehicle
 */
public class Sedan extends Vehicle {
    /**
     * This instance variable represents the number of seats in the current sedan.
     */
    private int seats;

    /**
     * Constructor.
     *
     * @param maker The name of the maker of the vehicle
     * @param model The name of the model of the vehicle
     * @param seats The number of seats in the vehicle
     * @throws VehicleException throws a VehicleException if one of the vehicle objects catch's an exception.
     */
    public Sedan(String maker, String model, int seats) throws VehicleException {
        super(maker, model, nextID());
        if (setSeats(seats)) {
            this.seats = seats;
        } else {
            throw new SedanException("Incorrect seats");
        }

    }

    /**
     * Constructor.
     *
     * @param maker The maker of the vehicle
     * @param model The model of the vehicle
     * @param seats The number of seats in the vehicle
     * @param VId   the current Vehicle ID
     * @throws VehicleException throws a VehicleException if one of the vehicle objects catch's an exception.
     */
    public Sedan(String maker, String model, int VId, int seats) throws VehicleException {
        super(maker, model, VId);
        if (setSeats(seats)) {
            this.seats = seats;
        } else {
            throw new SedanException("Incorrect seats");
        }

    }

    /**
     * Setter.
     *
     * @param seats number of seats of the car
     * @return boolean isValid if number of seats is valid.
     */
    public boolean setSeats(int seats) {
        boolean isValid = false;
        if (seats >= 4 && seats <= 5) {
            isValid = true;
            this.seats = seats;
        }
        return isValid;
    }
}
