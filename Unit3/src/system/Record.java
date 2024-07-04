package system;

public class Record {

	//instance variables
	private String name;
	private int idNum;
	private int idAge;
	private int idGrade;
	
	//default construct
	public Record() {}
	
	//add parameters to the construct
	public Record(String name, int idNum, int idAge, int idGrade) {
		
		this.name = name;
		this.idNum = idNum;
		this.idAge = idAge;
		this.idGrade = idGrade;
	}
	
	//get the value of idNum
	public int getIdNum() {return idNum;}
	
	//set value of idNum
	public void setIdNum(int idNum) {
		
		this.idNum = idNum;
	}
	
	//get value of idAge
	public int getIdAge() {return idAge;}
	
	//set idAge
	public void setIdAge(int idAge) {
		
		this.idAge = idAge;
	}
	
	//get value of idGrade
	public int getIdGrade() {return idGrade;}
	
	//set value of idGrade
	public void setIdGrade(int idGrade) {
		
		this.idGrade = idGrade;
	}
	
	//get value of name
	public String getName() {return name;}
	
	//set name
	
	public void setName(String name) {
		this.name = name;
	}
	
	//return the records
	@Override public String toString() {
		
		return "Records{ " +
		"name = " + name + ": ID Number- " +  idNum
		+ " : Grade- " + idGrade + " : Age- " + idAge +"}";
	}
	
}
