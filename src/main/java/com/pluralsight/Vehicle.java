package com.pluralsight;

import java.math.BigDecimal;

public class Vehicle {
    private String vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private BigDecimal price;

    // Constructor to create a vehicle with its information.
    public Vehicle(String vin, int year, String make, String model,
                   String vehicleType, String color, int odometer,
                   BigDecimal price) {

        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
    // Returns the vehicle VIN.
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    // Returns the vehicle year.
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Returns the vehicle make.
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    // Returns the vehicle model.
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Returns the vehicle type.
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // Returns the vehicle color.
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Returns the vehicle odometer reading.
    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // Returns the vehicle price.
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
