package library;
//Does all operations related to books
//add, check-in, and check-out

import java.util.Scanner;

//class
public class Books {
	
	Book theBooks[] = new Book[50];
	//this calls from other file Book.java
	public static int count;
	
	Scanner input = new Scanner(System.in);
	
	//comparing books to check if it is in our system
	public int compareBooks(Book b) {
		for(int i = 0; i < count; i++) {
			if (b.bookName == theBooks[i].bookName) {
				System.out.println("This book is in our system.");
				return 0;
			}
			else{
				System.out.println("This book isn't in our system.");
			}
		}
		return 1;
	}
	
	//Adding a book
	public void addBook(Book b) {
		  // Get input from the user
		  System.out.println("Enter Book Name: ");
		  String bookName = input.nextLine();
		  System.out.println("Enter Author Name: ");
		  String authorName = input.nextLine();
		  System.out.println("Enter Quantity of Books: ");
		  int bookQty = input.nextInt();
		  // Create a new Book object with the input details
		  b = new Book(bookName, authorName, bookQty);
		  for (int i = 0; i < count; i++) {
		    if (this.compareBooks(this.theBooks[i]) == 0)
		      return;
		  }
		  if (count < 50) {
		    theBooks[count] = b;
		    count++;
		  } else {
		    System.out.println("No more space for books.");
		  }
		}
	
	//Search for a book by name
	public void searchByName() {
		
		System.out.println(
	            "\t\t\t\tSEARCH BY AUTHOR'S NAME");
	 
	        input.nextLine();
	 
	        System.out.println("Enter Author Name:");
	        String authorName = input.nextLine();
	 
	        int flag = 0;
	 
	        System.out.println(
	            "\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
	 
	        for (int i = 0; i < count; i++) {
	 
	            // check the author
	            if (authorName.equalsIgnoreCase(
	                    theBooks[i].authorName)) {
	 
	                //display book information
	                System.out.println(
	                     theBooks[i].bookName + "\t\t"
	                    + theBooks[i].authorName + "\t\t"
	                    + theBooks[i].bookQtyCopy + "\t\t"
	                    + theBooks[i].bookQty);
	                flag++;
	            }
		}
		
		//if there is no match
		if (flag == 0)
			System.out.println("No books with " + authorName + " were found.");
		
	}
	
	//Display all books
	public void showAll() {
		
		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println("Name\tAvailable Qty\tTotal Qty");
		
		for (int i = 0; i < count; i++) {
			
			System.out.println(theBooks[i].bookName + "\t\t" +
					theBooks[i].bookQtyCopy + "\t\t" +
					theBooks[i].bookQty);
		}
	}
	
	//Add qty
	public void updateQty() {
		
		System.out.println("\t\t\t\tUPDATE QUANTITY OF A BOOK\n");
		System.out.println("Enter name of the book");
		
		String bookName = input.nextLine();
		
		for (int i = 0; i < count; i++) {
			
			if(bookName.equalsIgnoreCase(theBooks[i].bookName)) {
				
				//prints information
				System.out.println(theBooks[i].bookName + "\t\t" +
						theBooks[i].bookQtyCopy + "\t\t" +
						theBooks[i].bookQty);
				System.out.println("Enter amount to be added: ");
				int addingQty = input.nextInt();
				theBooks[i].bookQty += addingQty;
				theBooks[i].bookQtyCopy += addingQty;
				
				return;
			}
		}
	}
	
	//Create a menu to access the options
	public void menu() {
	System.out.println("-");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println( "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Check Out Book. ");
        System.out.println("Press 5 to Check In Book");
        System.out.println("-");
	}
 
    // To search the library
    public int isAvailable(int bookQty)
    {
    	System.out.println("What book would you like to search for? ");
    	String bookName = input.nextLine();
    	
        for (int i = 0; i < count; i++) {
            if (bookName == theBooks[i].bookName) {
                if (theBooks[i].bookQtyCopy > 0) {
 
                    System.out.println(
                        "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
 
        System.out.println("No Book with " + bookName + " Available in Library.");
        return -1;
    	}
    
    //check in books
    public void checkInBook(Book b) {
    	  System.out.println("Enter the name of the book to check in: ");
    	  String bookName = input.nextLine();
    	  for (int i = 0; i < count; i++) {
    	    if (bookName.equals(theBooks[i].bookName)) { 
    	      theBooks[i].bookQtyCopy++; 
    	      System.out.println("Book checked in successfully.");
    	      return; // Exit the method after checking in the book
    	    }
    	  }
    	  System.out.println("No book with the name '" + bookName + "' was found.");
    	}
    
    //check out books
    public Book checkOut(Book b) {
    	  System.out.println("Enter Name of book Checking out: ");
    	  String bookName = input.nextLine(); // Read book name first
    	  // Now, prompt for quantity *after* reading book name
    	  System.out.println("Enter the quantity to check out: ");
    	  int checkoutQty = input.nextInt(); 
    	  input.nextLine(); // Consume the newline character
    	  // Now, loop through the books
    	  for(int i = 0; i <count; i++) {
    	    if(bookName.equals(theBooks[i].bookName)) {
    	      if (theBooks[i].bookQtyCopy >= checkoutQty) { 
    	        theBooks[i].bookQtyCopy -= checkoutQty;
    	        // Print success message only if the checkout is successful
    	        System.out.println("Successfully checked out " + checkoutQty + " copies of '" + bookName + "'.");
    	        return theBooks[i]; 
    	      } else {
    	        // Print error message only if not enough copies are available
    	        System.out.println("Not enough copies available for checkout. Only " + theBooks[i].bookQtyCopy + " copies are available.");
    	        return b; // Return the original book object
    	      }
    	    }
    	  }
    	  // Print error message only if the book is not found
    	  System.out.println("No book with the name '" + bookName + "' was found.");
    	  return b; // Return the original book object
    	}
}
