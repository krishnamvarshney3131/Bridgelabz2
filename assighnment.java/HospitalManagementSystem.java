import java.util.*;

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyRate, String diagnosis) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.diagnosis = diagnosis;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(medicalHistory);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, double consultationFee, String diagnosis) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.diagnosis = diagnosis;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(medicalHistory);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient ip = new InPatient(101, "Alice", 30, 5, 2000, "Pneumonia");
        ip.addRecord("Admitted for 5 days");
        ip.addRecord("Prescribed antibiotics");

        OutPatient op = new OutPatient(102, "Bob", 25, 500, "Fever");
        op.addRecord("Visited for fever");
        op.addRecord("Prescribed paracetamol");

        patients.add(ip);
        patients.add(op);

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill Amount: " + p.calculateBill());
            if (p instanceof MedicalRecord) {
                System.out.println("Medical Records: " + ((MedicalRecord) p).viewRecords());
            }
            System.out.println("----------------------");
        }
    }
}

