package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    // Dealership information
    private String name;
    private String address;
    private String phone;

    // Stores all vehicles at the dealership.
    private List<Vehicle> inventory;

    // Constructor creates a dealership with an empty inventory.
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        // Create the ArrayList when the dealership is created.
        this.inventory = new ArrayList<>();
    }

    // Adds a vehicle to the dealership inventory.
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Returns all vehicles in the inventory.
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
