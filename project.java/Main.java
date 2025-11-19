package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        ResultService resultService = new ResultService();

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("=========================================");
        System.out.println("   STUDENT RESULT MANAGEMENT SYSTEM");
        System.out.println("=========================================");

        while (choice != 9) {

            System.out.println("\n--------------- MENU ---------------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");

            System.out.println("5. Add Result");
            System.out.println("6. View All Results");
            System.out.println("7. Update Result");
            System.out.println("8. Delete Result");

            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter contact: ");
                    String contact = sc.nextLine();

                    Student student = new Student(name, course, contact);
                    studentService.addStudent(student);
                }

                case 2 -> {
                    ArrayList<Student> students = studentService.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n--- STUDENT LIST ---");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Enter Student ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter new contact: ");
                    String newContact = sc.nextLine();

                    studentService.updateStudent(id, newCourse, newContact);
                }

                case 4 -> {
                    System.out.print("Enter Student ID to delete: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    studentService.deleteStudent(id);
                }

                case 5 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    Result result = new Result(sid, marks);
                    resultService.addResult(result);
                }

                case 6 -> {
                    ArrayList<Result> results = resultService.getAllResults();

                    if (results.isEmpty()) {
                        System.out.println("No results found.");
                    } else {
                        System.out.println("\n--- RESULT LIST ---");
                        for (Result r : results) {
                            System.out.println(r);
                        }
                    }
                }

                case 7 -> {
                    System.out.print("Enter Student ID to update result: ");
                    int sid = sc.nextInt();

                    System.out.print("Enter new marks: ");
                    double newMarks = sc.nextDouble();

                    resultService.updateResult(sid, newMarks);
                }

                case 8 -> {
                    System.out.print("Enter Student ID to delete result: ");
                    int sid = sc.nextInt();

                    resultService.deleteResult(sid);
                }

                case 9 -> System.out.println("Exiting program...");

                default -> System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
