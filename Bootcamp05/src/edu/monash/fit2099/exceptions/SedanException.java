package edu.monash.fit2099.exceptions;

/**
 * This class represents a custom exception class for Sedan objects
 */
public class SedanException extends VehicleException{

    /**
     * Calls it's parent and passes on the message
     * @param message the error message to indicate what went wrong
     */
    public SedanException(String message) {
        super(message);
    }
}
