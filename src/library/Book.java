package library;

//importing a class to take in user data
import java.util.Scanner;

//this is our class
public class Book {

	//data
	public String bookName;
	public String authorName;
	public int bookQty;
	public int bookQtyCopy;
	
	//creating a scanner class to read input
	Scanner input = new Scanner(System.in);
	
	//Now to create book details
	public void book(String bookName, String authorName, int bookQty){
		
		System.out.println("Enter Book Name: ");
		this.bookName = input.nextLine();
		input.nextLine();
		//these are standard methods to go
		//to next line
		
		System.out.println("Enter Author Name: ");
		this.authorName = input.nextLine();
		
		System.out.println("Enter Quantity of Books: ");
		this.bookQty = input.nextInt();
		bookQtyCopy = this.bookQty;
	}
	public Book(String bookName, String authorName, int bookQty) {
		  this.bookName = bookName;
		  this.authorName = authorName;
		  this.bookQty = bookQty;
		  bookQtyCopy = this.bookQty; 
		}
}
