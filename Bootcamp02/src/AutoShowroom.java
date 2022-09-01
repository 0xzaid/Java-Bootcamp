public class AutoShowroom {

    private final Car[] car_array = new Car[3];

    public void printStatus(){
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");

    }
    public void createCars() {
        // Creating car objects and store them in array
        Car Car1 = new Car("BMW", "X7");
        Car Car2 = new Car("Audi", "A8");
        Car Car3 = new Car("Mercedes", "GLS");

        car_array[0] = Car1;
        car_array[1] = Car2;
        car_array[2] = Car3;
    }
    public void displayCars() {
        // turn each object into string and display it
        String result;
        for (int i = 0; i < car_array.length; i++) {
            result = "Car ("+i+") " + car_array[i].getCarDescription();
            System.out.println(result);
        }
    }
}