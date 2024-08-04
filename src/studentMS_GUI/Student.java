package studentMS_GUI;

import java.util.HashMap;
import java.util.Map;

class Student {
    private String id;
    private String name;
    private Map<String, String> coursesAndGrades; // Map of course names to grades

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.coursesAndGrades = new HashMap<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Map<String, String> getCoursesAndGrades() { return coursesAndGrades; }

    public void addCourse(String course, String grade) {
        coursesAndGrades.put(course, grade);
    }

    public void updateCourse(String course, String grade) {
        coursesAndGrades.put(course, grade);
    }

    public void removeCourse(String course) {
        coursesAndGrades.remove(course);
    }
}
