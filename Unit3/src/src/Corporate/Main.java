package Corporate;

import javax.swing.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a dataset
        List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Alice", 29, "HR", 50000),
            new Employee("Bob", 35, "Engineering", 70000),
            new Employee("Charlie", 45, "Marketing", 80000),
            new Employee("David", 31, "Engineering", 75000),
            new Employee("Eve", 28, "HR", 60000)
        ));

        // Step 2: Define the Function to concatenate name and department
        Function<Employee, String> nameAndDepartmentFunction = e -> e.getName() + " (" + e.getDepartment() + ")";

        // Launch GUI
        SwingUtilities.invokeLater(() -> {
            try {
                new EmployeeGUI(employees, nameAndDepartmentFunction).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
