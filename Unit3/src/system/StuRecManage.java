package system;

import java.util.LinkedList;
import java.util.Scanner;

public class StuRecManage {
	
	//an empty list to store future data
	LinkedList<Record> list;
	
	public StuRecManage() {
		list = new LinkedList<>();
		
	}
	
	//adding records with the parameter of record
	public void add(Record record) {
		
		//check if a record exists first
		//if not then add it to records
		if(!find(record.getIdNum())) {
			list.add(record);
		}
		else {
			
			System.out.println("This Student is Already in our records.");
		}
	}
	
	//finding records
	public boolean find(int idNum) {
		
		//iterate record with for loop
		for(Record l: list) {
			 if(l.getIdNum() == idNum) {
				 
				 System.out.print(l);
				 return true;
			 }
		}
		return false;
	}
	
	//Delete records
	public void delete(int recIdNum) {
		
		Record recordDel = null;
		
		for(Record ll: list) {
			
			if (ll.getIdNum() == recIdNum) {
				recordDel = ll;
			}
		}
		//if recordDel is null show an error
		if (recordDel == null) {
			System.out.println("Invailid Input.");
		}
		else {
			list.remove(recordDel);
			
			System.out.println("Successfully deleted file.");
		}
	}
	//finding records
	public Record findRecord(int idNum) {
		
		//iterate using for each loop
		for (Record l: list) {
			
			//check record
			if(l.getIdNum() == idNum) {
				return l;
			}
		}
		return null;
	}
	
	//update records
	public void update(int id, Scanner input) {
		
		if(find(id)) {
			Record rec = findRecord(id);
			
			System.out.println("What is the Name of the Student: ");
			String name = input.nextLine();
			
			System.out.println("What is the New Student ID Number: ");
			int idNum = input.nextInt();
			
			System.out.println("What is the Age of the Student: ");
			int idAge = input.nextInt();
			
			System.out.println("What is the Grade of the Student: ");
			int idGrade = input.nextInt();
			
			
			rec.setIdNum(idNum);
			rec.setName(name);
			rec.setIdGrade(idGrade);
			rec.setIdAge(idAge);
			System.out.println("Record Updated Successfully");
		}
		else {
			
			System.out.println("Record Not Found.");
		}
	}
	
	//displaying student info
	public void display() {
		
		if(list.isEmpty()) {
			
			System.out.println("This list has no records.");
		}
		
		for (Record record: list) {
			System.out.println(record.toString());
		}
	}

}
