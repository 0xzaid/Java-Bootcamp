package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents a bid's manager that uses a hashmap to store values. The keys are represented as the buyer's ID
 * and the values are Bid objects
 *
 * @see HashMap
 * @see Bid
 */

public class BidsManager {
    /**
     * An array that contains bids
     */
    private ArrayList<Bid> bid_array = new ArrayList<>();

    /**
     * A hashmap that stores a BuyerID as the key and the Bid object as the value.
     */
    private HashMap<Integer, Bid> hashMap;

    /**
     * Zero parameter constructor.
     */
    public BidsManager() {
        hashMap = new HashMap<>();
    }

    /**
     * Getter.
     *
     * @return the current hashmap that contains the keys and values
     */
    public HashMap<Integer, Bid> getHashMap() {
        return hashMap;
    }


     /**
     *A method that adds a bid to the bid_array and hashmap using the following parameters:
     *
     * @param buyerId the ID of the buyer placing the bid
     * @param bid The current bid that is being added
     */
    public void addBid(Integer buyerId, Bid bid) {

        hashMap.put(buyerId, bid);
        bid_array.add(bid);

        for (int key : hashMap.keySet())
            System.out.println("| Bid ID: " + hashMap.get(key).getBidId()
                    + "| Buyer ID: " + hashMap.get(key).getBuyer().getBuyerId()
                    + "| price: " + hashMap.get(key).getBidPrice()
                    + "| Date: " + hashMap.get(key).getDateOfBid());
    }

}
