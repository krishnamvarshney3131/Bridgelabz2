import java.util.*;

class Course {
    String name;
    List<Student> students = new ArrayList<>();
    Course(String name) { this.name = name; }
    void enrollStudent(Student s) {
        students.add(s);
        s.courses.add(this);
    }
    void showStudents() {
        for (Student s : students) System.out.println(s.name);
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();
    Student(String name) { this.name = name; }
    void showCourses() {
        for (Course c : courses) System.out.println(c.name);
    }
}

class School {
    String name;
    List<Student> students = new ArrayList<>();
    School(String name) { this.name = name; }
    void addStudent(Student s) { students.add(s); }
}

public class Problem1 {
    public static void main(String[] args) {
        School school = new School("ABC School");

        Student s1 = new Student("Aman");
        Student s2 = new Student("Riya");

        Course c1 = new Course("Math");
        Course c2 = new Cours
