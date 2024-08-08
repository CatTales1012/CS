package Corporate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeGUI extends JFrame {
    private List<Employee> employees;
    private JTextField nameField, ageField, departmentField, salaryField;
    private JTextArea textArea;
    private Function<Employee, String> nameAndDepartmentFunction;

    public EmployeeGUI(List<Employee> employees, Function<Employee, String> nameAndDepartmentFunction) {
        this.employees = employees;
        this.nameAndDepartmentFunction = nameAndDepartmentFunction;

        setTitle("Employee Management");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        inputPanel.add(departmentField);

        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        JButton addButton = new JButton("Add Employee");
        inputPanel.add(addButton);

        // Text area to display the employee list
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);

        // Button action to add employee
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
                updateEmployeeList();
                displayStatistics();
            }
        });

        // Display initial data
        updateEmployeeList();
        displayStatistics();
    }

    private void addEmployee() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String department = departmentField.getText();
            double salary = Double.parseDouble(salaryField.getText());

            Employee newEmployee = new Employee(name, age, department, salary);
            employees.add(newEmployee);

            // Clear input fields after adding
            nameField.setText("");
            ageField.setText("");
            departmentField.setText("");
            salaryField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        }
    }

    private void updateEmployeeList() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(nameAndDepartmentFunction.apply(employee))
              .append("\n");
        }
        textArea.setText(sb.toString());
    }

    private void displayStatistics() {
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);

        List<String> filteredEmployees = employees.stream()
            .filter(e -> e.getAge() > 30)
            .map(nameAndDepartmentFunction)
            .collect(Collectors.toList());

        // Use StringBuilder to format statistics and then append
        StringBuilder sb = new StringBuilder();
        sb.append("\nAverage Salary: ").append(averageSalary).append("\n");
        sb.append("\nEmployees older than 30:\n");
        for (String employee : filteredEmployees) {
            sb.append(employee).append("\n");
        }

        textArea.append(sb.toString());
    }
}