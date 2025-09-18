import java.util.*;

class Professor {
    String name;
    Professor(String name) { this.name = name; }
}

class UniCourse {
    String name;
    Professor professor;
    List<Student2> students = new ArrayList<>();
    UniCourse(String name) { this.name = name; }
    void assignProfessor(Professor p) { this.professor = p; }
    void enrollStudent(Student2 s) {
        students.add(s);
        s.courses.add(this);
    }
    void showDetails() {
        System.out.println("Course: " + name);
        if (professor != null) System.out.println("Professor: " + professor.name);
        System.out.println("Students:");
        for (Student2 s : students) System.out.println(s.name);
    }
}

class Student2 {
    String name;
    List<UniCourse> courses = new ArrayList<>();
    Student2(String name) { this.name = name; }
    void enrollCourse(UniCourse c) { c.enrollStudent(this); }
}

public class Problem5 {
    public static void main(String[] args) {
        Student2 s1 = new Student2("Neha");
        Student2 s2 = new Student2("Rahul");

        Professor p1 = new Professor("Dr. Gupta");

        UniCourse c1 = new UniCourse("Data Structures");
        c1.assignProfessor(p1);

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);

        c1.showDetails();
    }
}

