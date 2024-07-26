package carRent;

import java.util.ArrayList;
import java.util.Scanner;

public class RentMain {

    public static void main(String[] args) {
    	 //Establishing a scanner object for obtaining user input
    	  Scanner scanner = new Scanner(System.in);
    	  //Establishing a RentalSystem object that is utilized to invoke the corresponding methods.Establishing a RentalSystem object that is utilized to invoke the corresponding methods.
    	  Rental rentalSystem = new Rental();
    	  
    	// Create an ArrayList to hold vehicles temporarily before adding them to Rental
    	  ArrayList<Vehicle> availableRentals = new ArrayList<>();

    	  
    	  Vehicle car = new Vehicle("Porsche", "Carrera", 2021, 5000);
    	  Vehicle motorbike = new Vehicle("Honda", "GL1800", 2022, 500);
    	  Vehicle truck = new Vehicle("Ford", "Ranger", 2021, 1500);
    	  
    	  rentalSystem.addVehicle(car);
    	  rentalSystem.addVehicle(motorbike);
    	  rentalSystem.addVehicle(truck);
    	  
    	  while (true) {
    	   //Choices available to the use
    	   System.out.println();
    	   System.out.println("===== Vehicle Rental System =====");
    	   System.out.println("1. Rent a Vehicle");
    	   System.out.println("2. Return a Vehicle");
    	   System.out.println("3. Display Rental Information");
    	   System.out.println("4. Add Vehicle to Rental");
    	   System.out.println("5. Exit");
    	   System.out.println();
    	   System.out.print("Enter your choice: ");
    	   
    	   int choice = scanner.nextInt();
    	   scanner.nextLine();
    	   
    	   switch (choice) {
    	   case 1: {
    	    //Rent a vehicle
    	    System.out.print("Enter the vehicle make: ");
    	    String make = scanner.nextLine();
    	    System.out.print("Enter the vehicle model: ");
    	    String model = scanner.nextLine();
    	    
    	    Vehicle selectedVehicle = null;
    	    
    	    //Checks the vehicles in available vehicles
    	    for(Vehicle v : rentalSystem.getAvailableVehicles()) {
    	     if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
    	      selectedVehicle = v;
    	     }
    	     
    	    }
    	    
    	    if(selectedVehicle != null) {
    	     //Include the vehicle in the list of rented vehicles
    	     rentalSystem.rentVehicle(selectedVehicle);
    	     System.out.print("Enter the rental duration in days: ");
    	     int rentalDuration = scanner.nextInt();
    	     //Compute the total cost for the rental
    	     double rc = rentalSystem.calculateRentalCost(selectedVehicle, rentalDuration);
    	     System.out.println("Successfully rented.");
    	     System.out.println("Total rental Cost: " + rc);
    	    }
    	    else {
    	     System.out.println("Matching vehicle is not available for rent.");
    	    }
    	    break;
    	    }
    	   
    	   case 2: {
    	    //Give back a vehicle
    	    System.out.println("Enter the vehicle make: ");
    	    String make = scanner.nextLine();
    	    System.out.println("Enter the vehicle model: ");
    	    String model = scanner.nextLine();
    	    
    	    Vehicle selectedVehicle = null;
    	    
    	    //Examines the vehicles within the rented vehicle inventory
    	    for(Vehicle v : rentalSystem.getRentedVehicles()) {
    	     if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
    	      selectedVehicle = v;
    	     }
    	    }
    	    if(selectedVehicle != null) {
    	     //Include in the list of returned vehicles
    	     rentalSystem.returnVehicle(selectedVehicle);
    	     System.out.println("Vehicle returned successfully.");
    	    }
    	    else {
    	     System.out.println("Invalid return. Vehicle not rented.");
    	    }
    	   }
    	   
    	   case 3: {
    	    //Show information about the rental
    	    rentalSystem.displayRentalInfo();  
    	    break;
    	   }
    	   
    	   case 4:{
               //Add Vehicle
               AddVehicle.addVehicle(availableRentals, scanner);
               break;
             }
    	   
    	   case 5: {
    	    //Exit
    	     System.out.println("Thank you for using the Vehicle Rental System. Goodbye!");
    	     scanner.close();
    	     System.exit(0);
    	   }
    	   
    	   
    	   default:
    	    System.out.println("Invalid choice. Please enter valid option...");
    	   }
    	  }
    	 }
}