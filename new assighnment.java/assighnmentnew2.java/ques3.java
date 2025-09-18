import java.util.*;

class Subject {
    String name;
    int marks;
    Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

class Student {
    String name;
    List<Subject> subjects = new ArrayList<>();
    Student(String name) {
        this.name = name;
    }
    void addSubject(Subject s) {
        subjects.add(s);
    }
}

class GradeCalculator {
    char calculateGrade(Student s) {
        int total = 0;
        for (Subject sub : s.subjects) {
            total += sub.marks;
        }
        int avg = total / s.subjects.size();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 50) return 'C';
        else return 'D';
    }
}

public class SchoolResultsApp {
    public static void main(String[] args) {
        Student student1 = new Student("Student1_John");
        student1.addSubject(new Subject("Subject_Maths", 90));
        student1.addSubject(new Subject("Subject_Science", 85));

        GradeCalculator gradeCalculator1 = new GradeCalculator();
        char grade = gradeCalculator1.calculateGrade(student1);

        System.out.println("Student: " + student1.name);
        for (Subject s : student1.subjects) {
            System.out.println("Subject: " + s.name + ", Marks: " + s.marks);
        }
        System

