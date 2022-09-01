package edu.monash.fit2099.buyers;

import edu.monash.fit2099.Util;

/**
 * This class represents a Buyer that can place bids on vehicles in the showroom
 *
 * @see edu.monash.fit2099.vehicles.Vehicle
 * @see edu.monash.fit2099.bids.Bid
 */
public class Buyer {
    /**
     * Current buyer's ID
     */
    private int buyerId;
    /**
     * Current buyer's given name.
     */
    private String givenName;
    /**
     * Current buyer's family name.
     */
    private String familyName;

    /*
    Using givenName and familyName rather than firstName and lastName to avoid confusion because
    different cultures have different understanding of first and last names.
     */

    /**
     * Constructor.
     *
     * @param newBuyerid Create a Buyer object from id
     */
    private Buyer(int newBuyerid) {
        this.buyerId = newBuyerid;
    }

    /**
     * Zero Parameter constructor.
     */
    private Buyer() {
    }

    /**
     * Constructor.
     *
     * @param buyerId       Id of this Buyer
     * @param newGivenName  Given name of this Buyer
     * @param newFamilyName Family name of this Buyer
     */
    private Buyer(Integer buyerId, String newGivenName, String newFamilyName) {
        this.buyerId = buyerId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    /**
     * Get an instance of Buyer
     *
     * @param givenName  Given name of the buyer
     * @param familyName Family name of the buyer
     * @return Buyer object with the given name and family name
     */
    public static Buyer getInstance(String givenName, String familyName) {
        boolean isValid = false;
        Buyer buyer = new Buyer();
        if (buyer.setGivenName(givenName)) {
            if (buyer.setFamilyName(familyName)) {
                isValid = true;
            }
        }
        if (isValid) {
            return buyer;
        } else {
            return null;
        }
    }

    /**
     * Getter.
     * <p>
     * Get the current Buyer Id.
     *
     * @return Buyer Id
     */
    public int getBuyerId() {
        return buyerId;
    }

    /**
     * Setter.
     * <p>
     * Set the current Buyer's given name.
     *
     * @param givenName Buyer's given name
     * @return new given name
     */
    public boolean setGivenName(String givenName) {
        boolean isValid = false;
        if (givenName.length() >= 2 && givenName.length() <= 15) {
            isValid = true;
            this.givenName = givenName;
        }
        return isValid;
    }

    /**
     * Setter.
     * <p>
     * Set the current Buyer's family name.
     *
     * @param familyName buyer's family name
     * @return new buyer's family name
     */
    public boolean setFamilyName(String familyName) {
        boolean isValid = false;
        if (familyName.length() >= 2 && familyName.length() <= 15) {
            isValid = true;
            this.familyName = familyName;
        }
        return isValid;
    }

    /**
     * @return Current buyer's description
     */
    public String description() {
        return "|" + buyerId + "|" + givenName + "|" + familyName + "|";
    }

    /**
     * Getter.
     * <p>
     * Get the current buyer's given name
     *
     * @return buyer's given name
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * Getter.
     * <p>
     * Get the current buyer's family name
     *
     * @return buyer's family name
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Setter.
     * <p>
     * Set current buyer's ID to a randomly generated Id
     */
    public void setBuyerId() {
        this.buyerId = Util.nextID();
    }

    /**
     * Setter.
     * <p>
     * Set current's Buyer's ID to the buyer Id given from the parameter
     *
     * @param buyerId new buyer id
     */
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }


    /**
     * toString method
     *
     * @return concatenated string of instance variables
     */
    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId=" + buyerId +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
