public class Car {
    //instance variables
    private final String car_make;
    private final String car_model;

    //constructor
    public Car(String car_make, String car_model) {
        this.car_make = car_make;
        this.car_model = car_model;
    }
    //getter
    public String getCarDescription() {
        return "Maker:" + car_make + " and Model:" + car_model;
    }
}