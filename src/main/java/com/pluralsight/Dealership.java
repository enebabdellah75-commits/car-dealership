
package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Represents the dealership and manages its vehicles.
public class Dealership {

    private String name;
    private String address;
    private String phone;

    // Stores all vehicles at the dealership.
    private ArrayList<Vehicle> inventory;

    // Creates a dealership with an empty inventory.
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        inventory = new ArrayList<>();
    }

    // Adds a vehicle to the inventory.
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Returns all vehicles.
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Finds vehicles within a price range.
    public List<Vehicle> getVehiclesByPrice(
            BigDecimal minPrice, BigDecimal maxPrice) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice().compareTo(minPrice) >= 0 &&
                    vehicle.getPrice().compareTo(maxPrice) <= 0) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Finds vehicles by make or model.
    public List<Vehicle> getVehiclesByMakeModel(String search) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().toLowerCase().contains(search.toLowerCase()) ||
                    vehicle.getModel().toLowerCase().contains(search.toLowerCase())) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Finds vehicles within a year range.
    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= minYear &&
                    vehicle.getYear() <= maxYear) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Finds vehicles by color.
    public List<Vehicle> getVehiclesByColor(String color) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Finds vehicles within a mileage range.
    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= minMileage &&
                    vehicle.getOdometer() <= maxMileage) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Finds vehicles by type.
    public List<Vehicle> getVehiclesByType(String type) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // Removes a vehicle using its VIN.
    public void removeVehicle(String vin) {

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getVin().equalsIgnoreCase(vin)) {
                inventory.remove(i);
                break;
            }
        }
    }

    // Returns the dealership name.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Returns the dealership address.
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Returns the dealership phone number.
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

