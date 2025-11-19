package org.example;

public class Student {

    private int id;
    private String name;
    private String course;
    private String contact;

    // Constructor used when reading from database (id is auto-generated)
    public Student(int id, String name, String course, String contact) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.contact = contact;
    }

    // Constructor WITHOUT ID (used when inserting new student)
    public Student(String name, String course, String contact) {
        this.name = name;
        this.course = course;
        this.contact = contact;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public String getContact() { return contact; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setContact(String contact) { this.contact = contact; }

    @Override
    public String toString() {
        return "Student {" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Course='" + course + '\'' +
                ", Contact='" + contact + '\'' +
                '}';
    }
}
