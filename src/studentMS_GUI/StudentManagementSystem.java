package studentMS_GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class StudentManagementSystem extends JFrame {
    private JTable studentTable;
    private DefaultTableModel studentTableModel;
    private ArrayList<Student> students;
    private ArrayList<String> courses;
    private JTextArea studentDetailsArea; // Area to show details of selected student

    public StudentManagementSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        setupUI();
    }

    private void setupUI() {
        setTitle("Student Management System");
        setSize(1000, 600); // Increased size for better layout space
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add Student Tab
        JPanel addStudentPanel = createAddStudentPanel();
        tabbedPane.addTab("Add Student", addStudentPanel);

        // Update Student Tab
        JPanel updateStudentPanel = createUpdateStudentPanel();
        tabbedPane.addTab("Update Student", updateStudentPanel);

        // View Student Details Tab
        JPanel viewStudentPanel = createViewStudentPanel();
        tabbedPane.addTab("View Student Details", viewStudentPanel);

        // Enroll Student Tab
        JPanel enrollStudentPanel = createEnrollStudentPanel();
        tabbedPane.addTab("Enroll Student", enrollStudentPanel);

        // Assign Grade Tab
        JPanel assignGradePanel = createAssignGradePanel();
        tabbedPane.addTab("Assign Grade", assignGradePanel);

        // Manage Courses Tab
        JPanel manageCoursesPanel = createManageCoursesPanel();
        tabbedPane.addTab("Manage Courses", manageCoursesPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createAddStudentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Components
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(15);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        JLabel courseLabel = new JLabel("Course:");
        JComboBox<String> courseComboBox = new JComboBox<>(courses.toArray(new String[0]));
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField(15);
        JButton addButton = new JButton("Add");

        // Layout setup
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panel.add(idLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(idField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(courseLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(courseComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(gradeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(gradeField, gbc);

        gbc.gridx = 1; gbc.gridy = 4; gbc.anchor = GridBagConstraints.EAST;
        panel.add(addButton, gbc);

        // Add button action
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String course = (String) courseComboBox.getSelectedItem();
            String grade = gradeField.getText();
            if (id.isEmpty() || name.isEmpty() || course == null || grade.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = findStudentById(id);
            if (student == null) {
                student = new Student(id, name);
                students.add(student);
            }
            student.addCourse(course, grade);
            updateStudentTable();
            idField.setText("");
            nameField.setText("");
            courseComboBox.setSelectedIndex(-1);
            gradeField.setText("");
        });

        return panel;
    }

    private JPanel createUpdateStudentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Components
        JLabel idLabel = new JLabel("ID to Update:");
        JTextField idField = new JTextField(15);
        JLabel nameLabel = new JLabel("New Name:");
        JTextField nameField = new JTextField(15);
        JLabel courseLabel = new JLabel("New Course:");
        JComboBox<String> courseComboBox = new JComboBox<>(courses.toArray(new String[0]));
        JLabel gradeLabel = new JLabel("New Grade:");
        JTextField gradeField = new JTextField(15);
        JButton updateButton = new JButton("Update");

        // Layout setup
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panel.add(idLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(idField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(courseLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(courseComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(gradeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(gradeField, gbc);

        gbc.gridx = 1; gbc.gridy = 4; gbc.anchor = GridBagConstraints.EAST;
        panel.add(updateButton, gbc);

        // Update button action
        updateButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String course = (String) courseComboBox.getSelectedItem();
            String grade = gradeField.getText();
            Student student = findStudentById(id);
            if (student != null) {
                if (!name.isEmpty()) student.setName(name);
                if (course != null && !course.isEmpty()) student.updateCourse(course, grade);
                updateStudentTable();
                JOptionPane.showMessageDialog(panel, "Student updated successfully.");
            } else {
                JOptionPane.showMessageDialog(panel, "Student ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel createViewStudentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        studentTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Courses and Grades"}, 0);
        studentTable = new JTable(studentTableModel);
        panel.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> updateStudentTable());

        studentDetailsArea = new JTextArea();
        studentDetailsArea.setEditable(false);
        studentDetailsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(new JScrollPane(studentDetailsArea), BorderLayout.EAST);

        studentTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow != -1) {
                String studentId = (String) studentTable.getValueAt(selectedRow, 0);
                Student student = findStudentById(studentId);
                if (student != null) {
                    StringBuilder details = new StringBuilder();
                    details.append("ID: ").append(student.getId()).append("\n");
                    details.append("Name: ").append(student.getName()).append("\n");
                    details.append("Courses and Grades:\n");
                    for (Map.Entry<String, String> entry : student.getCoursesAndGrades().entrySet()) {
                        details.append("Course: ").append(entry.getKey()).append(", Grade: ").append(entry.getValue()).append("\n");
                    }
                    studentDetailsArea.setText(details.toString());
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createEnrollStudentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Components
        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField(15);
        JLabel courseLabel = new JLabel("Course:");
        JComboBox<String> courseComboBox = new JComboBox<>(courses.toArray(new String[0]));
        JButton enrollButton = new JButton("Enroll");

        // Layout setup
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panel.add(studentIdLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(studentIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(courseLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(courseComboBox, gbc);

        gbc.gridx = 1; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        panel.add(enrollButton, gbc);

        // Enroll button action
        enrollButton.addActionListener(e -> {
            String studentId = studentIdField.getText();
            String course = (String) courseComboBox.getSelectedItem();
            Student student = findStudentById(studentId);
            if (student != null && course != null) {
                student.addCourse(course, "Not Assigned");
                updateStudentTable();
                JOptionPane.showMessageDialog(panel, "Student enrolled in course successfully.");
            } else {
                JOptionPane.showMessageDialog(panel, "Student ID or course not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel createAssignGradePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Components
        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField(15);
        JLabel courseLabel = new JLabel("Course:");
        JComboBox<String> courseComboBox = new JComboBox<>(courses.toArray(new String[0]));
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField(15);
        JButton assignButton = new JButton("Assign Grade");

        // Layout setup
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panel.add(studentIdLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(studentIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(courseLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(courseComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(gradeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(gradeField, gbc);

        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        panel.add(assignButton, gbc);

        // Assign button action
        assignButton.addActionListener(e -> {
            String studentId = studentIdField.getText();
            String course = (String) courseComboBox.getSelectedItem();
            String grade = gradeField.getText();
            Student student = findStudentById(studentId);
            if (student != null && course != null && !grade.isEmpty()) {
                student.updateCourse(course, grade);
                updateStudentTable();
                JOptionPane.showMessageDialog(panel, "Grade assigned successfully.");
            } else {
                JOptionPane.showMessageDialog(panel, "Student ID, course, or grade not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private JPanel createManageCoursesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JList<String> courseList = new JList<>(courses.toArray(new String[0]));
        panel.add(new JScrollPane(courseList), BorderLayout.CENTER);

        JTextField newCourseField = new JTextField();
        JButton addCourseButton = new JButton("Add Course");

        // Add course button action
        addCourseButton.addActionListener(e -> {
            String newCourse = newCourseField.getText();
            if (!newCourse.isEmpty()) {
                courses.add(newCourse);
                updateCourseCombos();
                courseList.setListData(courses.toArray(new String[0]));
                newCourseField.setText("");
            }
        });

        JPanel addCoursePanel = new JPanel(new BorderLayout());
        addCoursePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        addCoursePanel.add(new JLabel("New Course:"), BorderLayout.WEST);
        addCoursePanel.add(newCourseField, BorderLayout.CENTER);
        addCoursePanel.add(addCourseButton, BorderLayout.EAST);

        panel.add(addCoursePanel, BorderLayout.SOUTH);

        return panel;
    }

    private void updateCourseCombos() {
        // Update course ComboBoxes in all relevant panels
        Component[] components = getComponentsRecursively(getContentPane());
        for (Component comp : components) {
            if (comp instanceof JComboBox) {
                JComboBox<String> comboBox = (JComboBox<String>) comp;
                comboBox.setModel(new DefaultComboBoxModel<>(courses.toArray(new String[0])));
            }
        }
    }

    private Component[] getComponentsRecursively(Container container) {
        ArrayList<Component> components = new ArrayList<>();
        getComponentsRecursivelyHelper(container, components);
        return components.toArray(new Component[0]);
    }

    private void getComponentsRecursivelyHelper(Container container, ArrayList<Component> components) {
        for (Component comp : container.getComponents()) {
            components.add(comp);
            if (comp instanceof Container) {
                getComponentsRecursivelyHelper((Container) comp, components);
            }
        }
    }

    private void updateStudentTable() {
        studentTableModel.setRowCount(0);
        for (Student student : students) {
            studentTableModel.addRow(new Object[]{student.getId(), student.getName(),
                formatCoursesAndGrades(student.getCoursesAndGrades())});
        }
    }

    private String formatCoursesAndGrades(Map<String, String> coursesAndGrades) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : coursesAndGrades.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    private Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementSystem().setVisible(true));
    }
}