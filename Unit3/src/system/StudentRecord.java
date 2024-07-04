package system;
//importing a scanner to be able to read user input
import java.util.Scanner;

public class StudentRecord {
	
	public static void main(String [] args) {
		
		//creating a login for admin to use to access data
		StuRecManage hr = new StuRecManage();
		
		Record record = new Record();
		
		record.setIdNum(2287);
		record.setIdAge(23);
		record.setIdGrade(13);
		record.setName("Cat");
		
		//adding the record to static data
		hr.add(record);
		
		Scanner input = new Scanner(System.in);
		//allowing option to be an int
		int option = 0;
		
		//menu time
		do {
			menu();
			option = input.nextInt();
			
			switch(option) {
			case 1://adds a student
				//Display message to admin
				System.out.println("What is the Student ID: ");
				
				int idNum = input.nextInt();
				
				System.out.println("What is the Student Age:");
				
				int idAge = input.nextInt();
				
				System.out.println("What is the Student Grade: ");
				
				int idGrade = input.nextInt();
				
				//to consume next line to allow user to input name
				input.nextLine();
				
				System.out.println("What is the Student Name: ");
				
				String name = input.nextLine();
				
				//create the student record
				record = new Record(name, idNum, idAge, idGrade);
				hr.add(record);
				break;
			
			case 2://deletes a student
				
				System.out.println("What is the ID Number of the Student: ");
				int delId = input.nextInt();
				
				hr.delete(delId);
				
				break;
				
			case 3: //update student information
				
				System.out.println("What is the ID Number of the Student: ");
				
				int upId = input.nextInt();
				input.nextLine();
				hr.update(upId, input);
				
				break;
				
			case 4: //Search for students
				
				System.out.println("What is the ID Number of the Student: ");
				int bookId = input.nextInt();
				
				if(!hr.find(bookId)){
					System.out.println("Student Number does not match our records./n");
				}
				break;
				
			case 5: //display student information
					hr.display();
					break;
					
			case 0: 
					System.out.print("\n Have a nice day.");
					System.exit(0);
					break;
					
			default:
				System.out.println("Invailid input\n");
				break;
			}
		}
			while (option != 0);
		
		}
		
		public static void menu() {
			
			//for displaying the menu choices
			System.out.println("MENU");
			System.out.println("1: Add Student");
			System.out.println("2: Remove Student");
			System.out.println("3: Update Student Information");
			System.out.println("4: Search for Student");
			System.out.println("5: Display all Student Information");
			System.out.println("0: Exit Program");
		
	}
}
