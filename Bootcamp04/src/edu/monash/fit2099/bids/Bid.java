package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;

import java.util.Random;

public class Bid {
    int bidId;
    Buyer buyer;
    float bidPrice;
    String dateOfBid;

    public Bid(int bidId, Buyer buyer, float bidPrice, String dateOfBid) {
        //setBidId();
        this.bidId = bidId;
        this.buyer = buyer;
        this.bidPrice = bidPrice;
        this.dateOfBid = dateOfBid;
    }

    public static int nextID() {
        Random r = new Random();
        int low = 10000;//using literal values is not a good idea, replace them with input parameters
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setBidPrice(float price) {
        this.bidPrice = price;
    }

    public void setDateOfBid(String dateOfBid) {
        this.dateOfBid = dateOfBid;
    }

    public int getBidId() {
        return bidId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public float getBidPrice() {
        return bidPrice;
    }

    public String getDateOfBid() {
        return dateOfBid;
    }
}

