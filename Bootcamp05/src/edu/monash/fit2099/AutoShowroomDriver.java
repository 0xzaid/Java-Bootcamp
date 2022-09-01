package edu.monash.fit2099;

import edu.monash.fit2099.exceptions.BidException;

/**
 * The driver class for the Auto showroom project.
 *
 * @author Zaid Al-Dirbashi
 * @version 1.5.4
 *
 *
 */
public class AutoShowroomDriver {

    /**
     * This is the main method of the auto showroom program. And it makes use of the auto showroom class.
     * @see AutoShowroom
     * @param args unused.
     * @throws BidException throws a BidException if one of the bid objects catch's an exception.
     */
    public static void main(String[] args) throws BidException {
        AutoShowroom showRoom = new AutoShowroom();
        showRoom.printStatus();

    }
}