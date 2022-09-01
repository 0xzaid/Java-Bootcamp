package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.vehicles.Vehicle;

public class Truck extends Vehicle {
    private int capacity;
    private int wheels;

    public Truck(String maker, String model, int capacity, int wheels) {
        super(maker, model, nextID());
        this.capacity = capacity;
        this.wheels = wheels;
    }

    public Truck(String maker, String model, int VId, int capacity, int wheels) {
        super(maker, model, VId);
        this.capacity = capacity;
        this.wheels = wheels;
    }
}
