
package com.pluralsight;

import java.util.List;
import java.util.Scanner;

// Handles communication between the user and the dealership.
public class UserInterface {

    // Reads information entered by the user.
    private Scanner scanner = new Scanner(System.in);

    // Stores the dealership being used by the application.
    private Dealership dealership;


    // Displays the menu and handles user commands.
    public void display() {

        // Load the dealership information.
        init();

        // Keeps the menu running until the user quits.
        boolean running = true;

        while (running) {

            // Display the menu options.
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

            // Get the user's command.
            System.out.print("Enter your command: ");
            int command = scanner.nextInt();

            // Process the selected command.
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
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }


    // Loads the dealership information from the inventory file.
    private void init() {

        // Create the file manager.
        DealershipFileManager fileManager = new DealershipFileManager();

        // Load the dealership and its vehicles.
        this.dealership = fileManager.getDealership();
    }


    // Displays a list of vehicles.
    private void displayVehicles(List<Vehicle> vehicles) {

        // Go through each vehicle in the list.
        for (Vehicle vehicle : vehicles) {

            System.out.println(vehicle);
        }
    }


    // Displays all vehicles in the dealership.
    private void processGetAllVehiclesRequest() {

        // Get all vehicles from the dealership.
        List<Vehicle> vehicles = dealership.getAllVehicles();

        // Display the vehicles.
        displayVehicles(vehicles);
    }


    // Searches for vehicles within a price range.
    private void processGetByPriceRequest() {

    }


    // Searches for vehicles by make and model.
    private void processGetByMakeModelRequest() {

    }


    // Searches for vehicles within a year range.
    private void processGetByYearRequest() {

    }


    // Searches for vehicles by color.
    private void processGetByColorRequest() {

    }


    // Searches for vehicles within a mileage range.
    private void processGetByMileageRequest() {

    }


    // Searches for vehicles by type.
    private void processGetByTypeRequest() {

    }


    // Adds a vehicle to the dealership.
    private void processAddVehicleRequest() {

    }


    // Removes a vehicle from the dealership.
    private void processRemoveVehicleRequest() {

    }

}
