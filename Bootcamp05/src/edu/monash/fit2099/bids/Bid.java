package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.vehicles.Vehicle;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * This Class represents a Bid that a Buyer can place on vehicles.
 *
 * @see Buyer
 * @see Vehicle
 */
public class Bid {
    /**
     * ID of the current bid.
     */
    private int bidId;
    /**
     * The current Buyer object .
     */
    private Buyer buyer;

    /**
     * The current bid price in float.
     */
    private float bidPrice;
    /**
     * The current Bid's date in the format of DD/MM/YYYY
     */
    private String dateOfBid;

    /**
     * Constructor.
     *
     * @param bidId     Randomly generated ID
     * @param buyer     Buyer object that is placing a bid
     * @param bidPrice  Price of bid
     * @param dateOfBid The date when the bid was placed
     * @throws BidException if values were input incorrectly
     */
    public Bid(int bidId, Buyer buyer, float bidPrice, String dateOfBid) throws BidException {
        if (setDateOfBid(dateOfBid) && setBidPrice(bidPrice)) {
            this.bidId = nextID();
            this.buyer = buyer;
            this.bidPrice = bidPrice;
            this.dateOfBid = dateOfBid;
        } else {
            throw new BidException("Incorrect bid price or date");
        }

    }

    /**
     * Method that generates random IDs
     *
     * @return Randomly generated integer
     */
    public static int nextID() {
        Random r = new Random();
        int low = 10000;//using literal values is not a good idea, replace them with input parameters
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    /**
     * Setter.
     * <p>
     * Allows the Buyer to set a bid price
     *
     * @param price What the buyer input as a price
     * @return isValid if price is a valid price
     */
    public boolean setBidPrice(float price) {
        boolean isValid = false;
        if (price >= 0) {
            isValid = true;
            this.bidPrice = price;
        }
        return isValid;
    }

    /**
     * Setter.
     * <p>
     * Allows the Buyer to set the date of the bid
     *
     * @param dateOfBid What the buyer input as the date
     * @return isValid if date is a valid date
     */
    public boolean setDateOfBid(String dateOfBid) {
        boolean isValid = false;
        StringTokenizer st = new StringTokenizer(dateOfBid, "/");
        int day = 0;
        int month = 0;
        int year = 0;
        try {
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
        } catch (NumberFormatException e) {
            System.out.println("Date must be in integer format.");
        } catch (Exception e) {
            System.out.println("An exception has occured");
        }
        if (day < 32 && day > 0) {
            if (month <= 12 && month >= 1) {
                if (year <= 2021 && year >= 1930) {
                    System.out.println("Date is correct");
                    isValid = true;
                    this.dateOfBid = dateOfBid;
                }
            }
        }
        return isValid;
    }

    /**
     * Getter
     *
     * @return current Bid ID
     */
    public int getBidId() {
        return bidId;
    }

    /**
     * Getter
     *
     * @return current Buyer
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Getter.
     *
     * @return current Bid Price
     */
    public float getBidPrice() {
        return bidPrice;
    }

    /**
     * Getter
     *
     * @return Current Bid Date
     */
    public String getDateOfBid() {
        return dateOfBid;
    }
}

