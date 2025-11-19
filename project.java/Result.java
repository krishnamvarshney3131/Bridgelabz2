package org.example;

public class Result {

    private int studentId;
    private double marks;
    private String grade;

    // Constructor for reading from DB or updating
    public Result(int studentId, double marks) {
        this.studentId = studentId;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    // Grade calculation logic
    private String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    // Getters
    public int getStudentId() { return studentId; }
    public double getMarks() { return marks; }
    public String getGrade() { return grade; }

    // Setter with auto-grade update
    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    @Override
    public String toString() {
        return "Result {" +
                "StudentId=" + studentId +
                ", Marks=" + marks +
                ", Grade='" + grade + '\'' +
                '}';
    }
}
