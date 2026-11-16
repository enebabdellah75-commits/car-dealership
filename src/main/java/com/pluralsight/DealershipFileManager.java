package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;


    // Handles reading and saving the dealership inventory file.
    public class DealershipFileManager {

        // Reads the inventory file and creates a Dealership object.
        public Dealership getDealership() {

            try (BufferedReader reader = new BufferedReader(
                    new FileReader("inventory.csv"))) {

                // Read the first line containing dealership information.
                String dealershipLine = reader.readLine();

                String[] dealershipInfo = dealershipLine.split("\\|");

                // Create the dealership using its information.
                Dealership dealership = new Dealership(
                        dealershipInfo[0],
                        dealershipInfo[1],
                        dealershipInfo[2]
                );

                // Read the remaining lines containing vehicle information.
                String vehicleLine;

                while ((vehicleLine = reader.readLine()) != null) {

                    // Separate the vehicle information using pipes.
                    String[] vehicleInfo = vehicleLine.split("\\|");

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

                    // Add the vehicle to the dealership inventory.
                    dealership.addVehicle(vehicle);
                }

                // Return the dealership with all its vehicles.
                return dealership;

            } catch (IOException e) {

                // Display an error if the file cannot be read.
                System.out.println("Error reading inventory file.");

                return null;
            }
        }

        // Saves the dealership information and vehicles to the file.
        public void saveDealership(Dealership dealership) {


        }
}
