package carRent;

import java.util.ArrayList;
import java.util.List;

public class Rental {
 
 private List<Vehicle> availableVehicles;
 private List<Vehicle> rentedVehicles;
 
 public Rental() {
  availableVehicles = new ArrayList<>();
  rentedVehicles = new ArrayList<>();
 }
 
 //To add vehicles to rental system
 public void addVehicle(Vehicle vehicle) {
  availableVehicles.add(vehicle);
 }
 
 public List<Vehicle> getAvailableVehicles(){
  return availableVehicles;
 }
 
 public List<Vehicle> getRentedVehicles(){
  return rentedVehicles;
 }
 
 //To lease a vehicle
 public void rentVehicle(Vehicle vehicle) {
  if(availableVehicles.contains(vehicle)) {
   availableVehicles.remove(vehicle);
   rentedVehicles.add(vehicle);
  }
 }
 
 //To bring back the leased vehicle
 public void returnVehicle(Vehicle vehicle) {
  if(rentedVehicles.contains(vehicle)) {
   rentedVehicles.remove(vehicle);
   availableVehicles.add(vehicle);
  }
 }
 
 //To showcase vehicles that are currently accessible and those that have been leased
 public void displayRentalInfo() {
  System.out.println("Available vehicles: ");
  for(Vehicle av : availableVehicles) {
   av.displayInfo();
   System.out.println();
  }
  
  System.out.println("Rented vehicles: ");
  for(Vehicle rv : rentedVehicles) {
   rv.displayInfo();
   System.out.println();
  }
 }
 
 //To compute the overall rental expense
 public double calculateRentalCost(Vehicle vehicle, int rentalDuration) {
  double rentalRate = vehicle.getRentalRate();
  double totalCost = rentalRate * rentalDuration;
  return totalCost;
 }
}