package carRent;

import java.util.ArrayList;
import java.util.Scanner;

public class AddVehicle {
    public static void addVehicle(ArrayList<Vehicle> availableRentals, Scanner scanner) {
        // Loop to continuously add vehicles until the user chooses to exit
        while (true) {
            System.out.println("\nChoose a vehicle type to add:");
            System.out.println("1. Car");
            System.out.println("2. Truck");
            System.out.println("3. Motorcylce");
            System.out.println("4. Exit to Main Menu"); 
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addCar(availableRentals, scanner);
                    break;
                case 2:
                    addTruck(availableRentals, scanner);
                    break;
                case 3:
                    addMotorcycle(availableRentals, scanner);
                    break;
                case 4:
                	System.out.println("Returning to Main Menu.");
                    //  No 'return' statement here. We are exiting the while loop 
                    return; // Exit the switch-case
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCar(ArrayList<Vehicle> availableRentals, Scanner scanner) {
        System.out.print("Enter the make of the car: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model of the car: ");
        String model = scanner.nextLine();
        System.out.print("Enter the year of the car: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the rental rate of the car: ");
        double rentalRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the number of doors: ");
        int numDoors = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Is it a convertible (true/false): ");
        boolean isConvertible = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter the fuel type: ");
        String fuelType = scanner.nextLine();
        Car newCar = new Car(make, model, year, rentalRate, numDoors, isConvertible, fuelType);
        availableRentals.add(newCar);
        System.out.println("Car added successfully!");
    }

    private static void addTruck(ArrayList<Vehicle> availableRentals, Scanner scanner) {
        System.out.print("Enter the make of the truck: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model of the truck: ");
        String model = scanner.nextLine();
        System.out.print("Enter the year of the truck: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the rental rate of the truck: ");
        double rentalRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the load capacity: ");
        int loadCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Is it four-wheel drive (true/false): ");
        boolean isFourWheelDrive = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter the cargo type: ");
        String cargoType = scanner.nextLine();
        Truck newTruck = new Truck(make, model, year, rentalRate, loadCapacity, isFourWheelDrive, cargoType);
        availableRentals.add(newTruck);
        System.out.println("Truck added successfully!");
    }
    private static void addMotorcycle(ArrayList<Vehicle> availableRentals, Scanner scanner) {
        System.out.print("Enter the make of the Bike: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model of the Bike: ");
        String model = scanner.nextLine();
        System.out.print("Enter the year of the Bike: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the rental rate of the Bike: ");
        double rentalRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("What is the Bike Type: ");
        String bikeType = scanner.nextLine();
        Motorcycle newMotorcycle = new Motorcycle(make, model, year, rentalRate, bikeType);
        availableRentals.add(newMotorcycle);
        System.out.println("Bike added successfully!");
    }
}