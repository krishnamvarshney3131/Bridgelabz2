class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients in " + hospitalName + " = " + totalPatients);
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital   : " + hospitalName);
            System.out.println("Patient ID : " + patientID);
            System.out.println("Name       : " + name);
            System.out.println("Age        : " + age);
            System.out.println("Ailment    : " + ailment);
        } else {
            System.out.println("Not a valid Patient object.");
        }
    }

    public int getPatientID() {
        return patientID;
    }
}

public class PatientDemo {
    public static void main(String[] args) {
        Patient p1 = new Patient("Rahul Sharma", 30, "Fever", 101);
        Patient p2 = new Patient("Priya Verma", 25, "Fracture", 102);

        p1.displayPatientDetails();
        System.out.println("-------------------");
        p2.displayPatientDetails();

        System.out.println("===================");
        Patient.getTotalPatients();
    }
}


