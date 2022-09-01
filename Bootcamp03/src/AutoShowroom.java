import java.util.ArrayList;
import java.util.Scanner;

public class AutoShowroom {

    ArrayList<Car> car_array = new ArrayList<>();

    public void printStatus() {
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    public void createCars() {

        int selection;
        do {
            selection = Menu();
            switch (selection) {
                case 1 -> {
                    Car Car1 = new Car(readString("Car Make: "), readString("Car Model: "));
                    car_array.add(Car1);
                    Buyer buyer1 = new Buyer(readString("Buyer id: "), readString("Given name: "),
                            readString("Family name: "));
                    Bid bid1 = new Bid(null, buyer1, readInteger("Price: "),
                            readString("Date of bid: "));
                    Car1.addBid(buyer1, bid1.getBidPrice(), bid1.getDateOfBid());
                }
                case 2 -> {
                    for (Car car : car_array) {
                        System.out.println(car.description());
                    }
                }
            }
        } while (selection != 3);
    }

    public void displayCars() {
        // turn each object into string and display it
        String result;
        String result2;
        for (int i = 0; i < car_array.size(); i++) {
            result = "Car (" + i + ") " + car_array.get(i).description();

            System.out.println(result);
            for (int j = 0; j < car_array.get(i).bids.size(); j++) {
                car_array.get(i).bids.get(j).setBidId();
                result2 = car_array.get(i).bids.get(j).getBuyer().description()
                        + "\nBid price: " + car_array.get(i).bids.get(j).getBidPrice()
                        + "\nBid ID : " + car_array.get(i).bids.get(j).getBidId();
                System.out.println(result2);
            }
        }
    }

    public int Menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Add a car");
        System.out.println("2) List cars");
        System.out.println("3) Exit");
        System.out.println("--------------------");
        System.out.print("Select an option: ");
        return scanner.nextInt();

    }

    public String readString(String prompt) {
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        String s;
        s = input.nextLine();
        return s;
    }

    public int readInteger(String prompt) {
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        int i;
        i = input.nextInt();
        return i;
    }
}