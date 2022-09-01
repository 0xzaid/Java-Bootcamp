package edu.monash.fit2099.exceptions;


/**
 * This class represents a custom exception class for Vehicle objects
 */
public class VehicleException extends Exception{

    /**
     * Calls it's parent and passes on the message
     * @param message the error message to indicate what went wrong
     */
    public VehicleException(String message) {
        super(message);
    }
}
