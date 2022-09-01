package edu.monash.fit2099.buyers;

import java.util.Random;

public class Buyer {
    int buyerId;
    String givenName;
    String familyName;

    /*
    Using givenName and familyName rather than firstName and lastName to avoid confusion because
    different cultures have different understanding of first and last names.
     */

    public Buyer(int newBuyerid) {
        this.buyerId = newBuyerid;
    }

    public Buyer(Integer buyerId, String newGivenName, String newFamilyName) {
        this.buyerId = buyerId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public static int nextID() {
        Random r = new Random();
        int low = 10000;//using literal values is not a good idea, replace them with input parameters
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public String description() {
        return "|" + buyerId + "|" + givenName + "|" + familyName + "|";
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }
}
