package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;

import java.util.ArrayList;
import java.util.HashMap;

public class BidsManager {
    ArrayList<Bid> bid_array = new ArrayList<>();
    // Key BuyerId, Value bid object
    public HashMap<Integer, Bid> hashMap = new HashMap<>();

    public HashMap<Integer, Bid> getHashMap() {
        return hashMap;
    }

    public void addBid(int buyerId, float price, String dateOfBid) {
        Buyer buyer = new Buyer(buyerId);
        Bid bid = new Bid(Bid.nextID(), buyer, price, dateOfBid);

        hashMap.put(buyerId, bid);
        bid_array.add(bid);

        for (int key : hashMap.keySet())
            System.out.println("| Bid ID: " + hashMap.get(key).getBidId()
                    + "| Buyer ID: " + hashMap.get(key).getBuyer().getBuyerId()
                    + "| price: " + hashMap.get(key).getBidPrice()
                    + "| Date: " + hashMap.get(key).getDateOfBid());
    }
}
