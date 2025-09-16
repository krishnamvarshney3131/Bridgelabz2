
class Employee {
    
    private static String companyName = "Tech Solutions Pvt. Ltd.";
    private static int totalEmployees = 0;

    
    private String name;
    private String designation;
    private final int id;   

    
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;                 
        this.designation = designation;
        totalEmployees++;             
    }

    
    public static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + " = " + totalEmployees);
    }

    
    public void displayDetails() {
        if (this instanceof Employee) {   
            System.out.println("Company    : " + companyName);
            System.out.println("Name       : " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Not a valid Employee object.");
        }
    }

    /
    public int getId() {
        return id;   
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {

        Employee e1 = new Employee("Rahul Sharma", 101, "Software Engineer");
        Employee e2 = new Employee("Priya Verma", 102, "Project Manager");

        e1.displayDetails();
        System.out.println("Returned ID: " + e1.getId());

        System.out.println("------------------------");

        e2.displayDetails();
        System.out.println("Returned ID: " + e2.getId());

        System.out.println("------------------------");

        Employee.displayTotalEmployees();
    }
}
