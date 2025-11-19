package org.example;

import java.sql.*;
import java.util.ArrayList;

public class ResultService {

    // Add a new result
    public void addResult(Result result) {
        String sql = "INSERT INTO results (student_id, marks, grade) VALUES (?, ?, ?)";

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, result.getStudentId());
            pstmt.setDouble(2, result.getMarks());
            pstmt.setString(3, result.getGrade());

            pstmt.executeUpdate();
            System.out.println("✔ Result added successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to add result");
            e.printStackTrace();
        }
    }

    // Get all results
    public ArrayList<Result> getAllResults() {
        ArrayList<Result> list = new ArrayList<>();
        String sql = "SELECT * FROM results";

        try (Connection con = DatabaseManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Result r = new Result(
                        rs.getInt("student_id"),
                        rs.getDouble("marks")
                );
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch results");
            e.printStackTrace();
        }

        return list;
    }

    // Update marks and grade
    public void updateResult(int studentId, double newMarks) {
        String updateSql = "UPDATE results SET marks = ?, grade = ? WHERE student_id = ?";

        Result temp = new Result(studentId, newMarks);  // auto-calculates grade

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(updateSql)) {

            pstmt.setDouble(1, newMarks);
            pstmt.setString(2, temp.getGrade());
            pstmt.setInt(3, studentId);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("✔ Result updated successfully!");
            else
                System.out.println("⚠ No result found for Student ID: " + studentId);

        } catch (SQLException e) {
            System.out.println("❌ Failed to update result");
            e.printStackTrace();
        }
    }

    // Delete result
    public void deleteResult(int studentId) {
        String sql = "DELETE FROM results WHERE student_id = ?";

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);

            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("✔ Result deleted successfully!");
            else
                System.out.println("⚠ No result found for Student ID: " + studentId);

        } catch (SQLException e) {
            System.out.println("❌ Failed to delete result");
            e.printStackTrace();
        }
    }
}
