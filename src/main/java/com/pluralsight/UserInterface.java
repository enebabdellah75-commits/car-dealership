

package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

// Handles communication between the user and the dealership.
public class UserInterface {

    // Reads information entered by the user.
    private Scanner scanner = new Scanner(System.in);

    // Stores the dealership.
    private Dealership dealership;

    private DealershipFileManager fileManager =
            new DealershipFileManager();

    // Displays the menu and handles user commands.
    public void display() {

        init();

        // Stop if the dealership could not be loaded.
        if (dealership == null) {
            return;
        }

        boolean running = true;

        while (running) {

            System.out.println("\nWhat do you want to do?");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");

            System.out.print("Enter your command: ");

            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {

                case 1:
                    processGetByPriceRequest();
                    break;

                case 2:
                    processGetByMakeModelRequest();
                    break;

                case 3:
                    processGetByYearRequest();
                    break;

                case 4:
                    processGetByColorRequest();
                    break;

                case 5:
                    processGetByMileageRequest();
                    break;

                case 6:
                    processGetByTypeRequest();
                    break;

                case 7:
                    processGetAllVehiclesRequest();
                    break;

                case 8:
                    processAddVehicleRequest();
                    break;

                case 9:
                    processRemoveVehicleRequest();
                    break;

                case 99:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    // Loads the dealership from the inventory file.
    private void init() {

        try {
            dealership = fileManager.getDealership();

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            dealership = null;
        }
    }

    // Displays a list of vehicles.
    private void displayVehicles(List<Vehicle> vehicles) {

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Displays all vehicles.
    private void processGetAllVehiclesRequest() {

        List<Vehicle> vehicles = dealership.getAllVehicles();

        displayVehicles(vehicles);
    }

    // Searches by price range.
    private void processGetByPriceRequest() {

        System.out.print("Minimum price: ");
        BigDecimal min = new BigDecimal(scanner.nextLine());

        System.out.print("Maximum price: ");
        BigDecimal max = new BigDecimal(scanner.nextLine());

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    // Searches by make or model.
    private void processGetByMakeModelRequest() {

        System.out.print("Enter make or model: ");
        String search = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(search));
    }

    // Searches by year range.
    private void processGetByYearRequest() {

        System.out.print("Minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    // Searches by color.
    private void processGetByColorRequest() {

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    // Searches by mileage range.
    private void processGetByMileageRequest() {

        System.out.print("Minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    // Searches by vehicle type.
    private void processGetByTypeRequest() {

        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }

    // Adds a new vehicle to the dealership.
    private void processAddVehicleRequest() {

        System.out.print("VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Vehicle type: ");
        String type = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.print("Price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        Vehicle vehicle = new Vehicle(
                vin, year, make, model, type,
                color, odometer, price
        );

        dealership.addVehicle(vehicle);

        // Save the updated inventory.
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully.");
    }

    // Removes a vehicle using its VIN.
    private void processRemoveVehicleRequest() {

        System.out.print("Enter VIN of vehicle to remove: ");
        String vin = scanner.nextLine();

        dealership.removeVehicle(vin);

        // Save the updated inventory.
        fileManager.saveDealership(dealership);

        System.out.println("Removal request completed.");
    }
}
