package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.vehicles.Vehicle;

public class Sedan extends Vehicle {
    private int seats;

    public Sedan(String maker, String model, int seats) {
        super(maker, model, nextID());
        this.seats = seats;

    }

    public Sedan(String maker, String model, int vId, int seats) {
        super(maker, model, vId);
        this.seats = seats;
    }
}
