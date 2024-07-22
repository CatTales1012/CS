package uniGrades;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseManagement {

    private CourseManagement() {
    	//to prevent a runtime error, this is an exception
        throw new IllegalStateException("Utility class");
    }

    private static final List<Course> courses =  new ArrayList<>();

    private static final List<Student> students = new ArrayList<>();

    public static void addCourse(String name, String code, int maxCapacity) {
    	//to add courses to the system
        Course course = new Course(name, code, maxCapacity);
        courses.add(course);
    }

    public static boolean enrollStudent(Student student, Course course) {
    	//to enroll a student to a course as long as it is not at max capacity
        if (course.getMaxCapacity() > Course.numEnrolled) {
            student.addCourse(course);
            students.add(student);
            Course.numEnrolled++;
            return true;
        }
        return false;
    }

    public static void assignGrade(Student student, Course course, int grade) {
    	//assigning a grade to a student
        student.setGrade(course, grade);
    }

    public static Course getCourseByCode(String courseCode) {
    	//this allows you to find the course by course code
        return courses.stream().filter(course -> course.getCode().equals(courseCode)).findFirst().orElse(null);
    }

    public static Student getStudentById(String studentId2) {
    	//finding a student by ID number
        return students.stream().filter(student -> student.getId().equals(studentId2)).findFirst().orElse(null);
    }

    public static int calculateOverallGrade(Student student) {
    	//finding total grade for student
        int total = 0;
        for (Course course : student.getCourses()) {
            total += student.getGrades().get(course);
        }
        return total / student.getCourses().size();
    }

    public static List<Course> getCourses() {
    	//cannot modify list courses
        return Collections.unmodifiableList(courses);
    }

    public static List<Student> getStudents() {
    	//cannot modify list students
        return Collections.unmodifiableList(students);
    }
}
