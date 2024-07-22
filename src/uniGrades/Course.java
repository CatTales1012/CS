package uniGrades;

public class Course {
	//creating object Course with name, code for a class, and maximum students
    private String name;
    private String code;
    private int maxCapacity;

    protected static int numEnrolled = 0;

    public Course() {
    }

    //constructors
    public Course(String name, String code, int maxCapacity) {
        this.name = name;
        this.code = code;
        this.maxCapacity = maxCapacity;
    }

    //getters and setters methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
