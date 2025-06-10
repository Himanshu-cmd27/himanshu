package ui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentForm extends JFrame {
    private JTextField nameField, emailField, ageField;
    private JButton saveButton;
    private final StudentDAO studentDAO = new StudentDAO();

    public StudentForm() {
        setTitle("Student Management System");
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        saveButton = new JButton("Save");
        add(new JLabel());  // Empty cell
        add(saveButton);

        saveButton.addActionListener(e -> saveStudent());

        setVisible(true);
    }

    private void saveStudent() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String ageText = ageField.getText().trim();

        // Validation
        if (name.isEmpty() || email.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return;
        }
        if (!ageText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Age must be a number.");
            return;
        }

        int age = Integer.parseInt(ageText);
        Student student = new Student(name, email, age);

        if (studentDAO.insertStudent(student)) {
            JOptionPane.showMessageDialog(this, "Student saved successfully.");
            nameField.setText("");
            emailField.setText("");
            ageField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error saving student. Check logs.");
        }
    }
}
private void saveStudent() {
    String name = nameField.getText().trim();
    String email = emailField.getText().trim();
    String ageText = ageField.getText().trim();

    // ✅ Check for empty fields
    if (name.isEmpty() || email.isEmpty() || ageText.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "All fields are required.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // ✅ Validate email format using regex
    if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
        JOptionPane.showMessageDialog(this,
                "Invalid email format. Please enter a valid email address.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // ✅ Validate age is a number and within reasonable range
    int age;
    try {
        age = Integer.parseInt(ageText);
        if (age <= 0 || age > 150) {
            JOptionPane.showMessageDialog(this,
                    "Age must be between 1 and 150.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Age must be a numeric value.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // ✅ Pass validated data to DAO
    Student student = new Student(name, email, age);
    boolean result = studentDAO.insertStudent(student);

    if (result) {
        JOptionPane.showMessageDialog(this,
                "Student saved successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        nameField.setText("");
        emailField.setText("");
        ageField.setText("");
    } else {
        JOptionPane.showMessageDialog(this,
                "Could not save student. Email may already exist.",
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

