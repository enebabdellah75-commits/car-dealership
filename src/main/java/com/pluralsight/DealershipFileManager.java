
package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

// Handles reading and saving the dealership inventory file.
public class DealershipFileManager {

    // Reads the inventory file and creates a Dealership object.
    public Dealership getDealership() {

        try (BufferedReader reader = new BufferedReader(
                new FileReader("inventory.csv"))) {

            // Read the first line containing dealership information.
            String dealershipLine = reader.readLine();

            if (dealershipLine == null) {
                throw new IOException("The inventory file is empty.");
            }

            // Separate the dealership information using pipes.
            String[] dealershipInfo = dealershipLine.split("\\|");

            // Create the dealership.
            Dealership dealership = new Dealership(
                    dealershipInfo[0],
                    dealershipInfo[1],
                    dealershipInfo[2]
            );

            // Read the remaining vehicle lines.
            String vehicleLine;

            while ((vehicleLine = reader.readLine()) != null) {

                if (vehicleLine.trim().isEmpty()) {
                    continue;
                }

                // Separate the vehicle information.
                String[] vehicleInfo = vehicleLine.split("\\|");

                if (vehicleInfo.length != 8) {
                    throw new IOException("Invalid vehicle line: " + vehicleLine);
                }

                // Create a Vehicle object.
                Vehicle vehicle = new Vehicle(
                        vehicleInfo[0],
                        Integer.parseInt(vehicleInfo[1]),
                        vehicleInfo[2],
                        vehicleInfo[3],
                        vehicleInfo[4],
                        vehicleInfo[5],
                        Integer.parseInt(vehicleInfo[6]),
                        new BigDecimal(vehicleInfo[7])
                );

                // Add the vehicle to the dealership.
                dealership.addVehicle(vehicle);
            }

            return dealership;

        } catch (IOException | NumberFormatException e) {
            throw new IllegalStateException(
                    "Could not load inventory.csv: " + e.getMessage(), e);
        }
    }

    // Saves the dealership and all vehicles to the inventory file.
    public void saveDealership(Dealership dealership) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter("inventory.csv"))) {

            // Write the dealership information first.
            writer.println(
                    dealership.getName() + "|" +
                            dealership.getAddress() + "|" +
                            dealership.getPhone()
            );

            // Write each vehicle to the file.
            for (Vehicle vehicle : dealership.getAllVehicles()) {

                writer.println(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice()
                );
            }

        } catch (IOException e) {
            System.out.println("Error saving inventory file.");
            System.out.println(e.getMessage());
        }
    }
}

