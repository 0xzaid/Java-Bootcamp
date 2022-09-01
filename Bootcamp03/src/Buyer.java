public class Buyer {
    private String buyerId;
    private String givenName;
    private String familyName;

    /*
    Using givenName and familyName rather than firstName and lastName to avoid confusion because
    different cultures have different understanding of first and last names.
     */

    public Buyer(String newBuyerid) {
        this.buyerId = newBuyerid;
    }

    public Buyer(String buyerId, String newGivenName, String newFamilyName) {
        this.buyerId = buyerId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String description() {
        return "Buyer ID : " + buyerId + " Given name: " + givenName + " Family name: " + familyName;
    }
}
