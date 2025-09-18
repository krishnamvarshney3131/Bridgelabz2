import java.util.*;

class Faculty {
    String name;
    Faculty(String name) { this.name = name; }
}

class Department {
    String name;
    Department(String name) { this.name = name; }
}

class University {
    String name;
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();
    University(String name) { this.name = name; }
    void addDepartment(Department d) { departments.add(d); }
    void addFaculty(Faculty f) { faculties.add(f); }
    void deleteUniversity() { departments.clear(); }
}

public class Problem2 {
    public static void main(String[] args) {
        University uni = new University("XYZ University");

        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Mechanical");

        Faculty f1 = new Faculty("Dr. Sharma");
        Faculty f2 = new Faculty("Dr. Verma");

        uni.addDepartment(d1);
        uni.addDepartment(d2);
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        System.out.println("Departments before deletion: " + uni.departments.size());
        uni.deleteUniversity();
        System.out.println("Departments after deletion: " + uni.departments.size());
        System.out.println("Faculty count (still exists): " + uni.faculties.size());
    }
}

