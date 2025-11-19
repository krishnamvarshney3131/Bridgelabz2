package org.example;

import java.sql.*;
import java.util.ArrayList;

public class StudentService {

    // Add a new Student
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, course, contact) VALUES (?, ?, ?)";

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getCourse());
            pstmt.setString(3, student.getContact());

            pstmt.executeUpdate();
            System.out.println("✔ Student added successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to add student");
            e.printStackTrace();
        }
    }

    // Get all students
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DatabaseManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getString("contact")
                );
                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch students");
            e.printStackTrace();
        }

        return list;
    }

    // Update a student
    public void updateStudent(int id, String newCourse, String newContact) {
        String sql = "UPDATE students SET course = ?, contact = ? WHERE id = ?";

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, newCourse);
            pstmt.setString(2, newContact);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("✔ Student updated successfully!");
            else
                System.out.println("⚠ No student found with ID: " + id);

        } catch (SQLException e) {
            System.out.println("❌ Failed to update student");
            e.printStackTrace();
        }
    }

    // Delete a student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("✔ Student deleted successfully!");
            else
                System.out.println("⚠ No student found with ID: " + id);

        } catch (SQLException e) {
            System.out.println("❌ Failed to delete student");
            e.printStackTrace();
        }
    }
}
