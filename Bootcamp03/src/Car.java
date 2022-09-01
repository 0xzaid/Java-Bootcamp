import java.util.ArrayList;

public class Car {
    //instance variables
    private String car_make;
    private String car_model;
     ArrayList<Bid> bids = new ArrayList<>();

    public Car(String car_make, String car_model) {
        this.car_make = car_make;
        this.car_model = car_model;
    }

    public String description() {
        return "Maker: " + car_make + " and Model: " + car_model;
    }

    public void addBid(Buyer newBuyer, int price, String date) {
        Bid bid = new Bid(null, newBuyer, price, date);
        bids.add(bid);
    }

}