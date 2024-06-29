package library;

import java.util.Scanner;
//this allows us to read input by user

public class Library {
	
	//main driver method
	public static void main(String[] args) {
		
		try (//allow input
		Scanner input = new Scanner(System.in)) {
			//help display the menu
			System.out.println("Select from the options: ");
			
			//create object that is a Book Class
			Books obj = new Books();
			
			//these will allow for menu selection
			int choice;
			
			//creating menu that won't end
			do {
				
				obj.menu();
				choice = input.nextInt();
			
				Book b = new Book(null, null, choice);
				switch(choice) {
				
				case 1:
					//adding book as option 1
					obj.addBook(b);
					break;
				case 2:
					//update qty of book
					obj.updateQty();
					break;
				case 3:
					//search for a book
					obj.searchByName();
					break;
				case 4:
					//check out a book
					obj.checkOut(b);
					break;
				case 5:
					//check in a book
					obj.checkInBook(b);
					break;
					
				default:
					System.out.println("Enter you choice using numbers.");
					
					}
				}
				while (choice != 0);
		}
		
		
	}
}
