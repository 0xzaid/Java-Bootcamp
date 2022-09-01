import java.util.UUID;

public class Bid {
    private String bidId;
    private Buyer buyer;
    private int bidPrice;
    private String dateOfBid;

    public Bid(String bidId, Buyer buyer, int bidPrice, String dateOfBid) {
        this.bidId = bidId;
        this.buyer = buyer;
        this.bidPrice = bidPrice;
        this.dateOfBid = dateOfBid;
    }

    public void setBidId() {
        this.bidId = UUID.randomUUID().toString();
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setBidPrice(int price) {
        this.bidPrice = price;
    }

    public void setDateOfBid(String dateOfBid) {
        this.dateOfBid = dateOfBid;
    }

    public String getBidId() {
        return bidId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public String getDateOfBid() {
        return dateOfBid;
    }
}

