
class Student {
    // Attributes
    private String name;
    private int rollNumber;
    private int marks;

    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public char calculateGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 50) {
            return 'C';
        } else if (marks >= 35) {
            return 'D';
        } else {
            return 'F'; // Fail
        }
    }

    public void displayDetails() {
        System.out.println("---- Student Report ----");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("------------------------");
    }
}

public class StudentReport {
public static void main(String
