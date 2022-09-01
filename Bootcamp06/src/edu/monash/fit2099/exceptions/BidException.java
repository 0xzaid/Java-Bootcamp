package edu.monash.fit2099.exceptions;

/**
 * This class represents a custom exception class for Bid objects
 */
public class BidException extends Exception{

    /**
     * Calls it's parent and passes on the message
     * @param message the error message to indicate what went wrong
     */
    public BidException(String message) {
        super(message);
    }
}
