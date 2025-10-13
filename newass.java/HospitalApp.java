package Abstract;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
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

    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private String[] records = new String[10];
    private int recordCount = 0;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount++] = record;
        }
    }

    public String viewRecords() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recordCount; i++) {
            sb.append(records[i]).append("\n");
        }
        return sb.toString();
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String[] records = new String[10];
    private int recordCount = 0;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount++] = record;
        }
    }

    public String viewRecords() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recordCount; i++) {
            sb.append(records[i]).append("\n");
        }
        return sb.toString();
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient("IP001", "John Doe", 45, 5, 1500),
            new OutPatient("OP002", "Jane Smith", 30, 500)
        };

        ((MedicalRecord) patients[0]).addRecord("Admitted with chest pain");
        ((MedicalRecord) patients[0]).addRecord("Underwent angioplasty");
        ((MedicalRecord) patients[1]).addRecord("Consulted for cold symptoms");

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.println("Bill Amount: " + p.calculateBill());
            System.out.println("Medical Records:\n" + ((MedicalRecord) p).viewRecords());
            System.out.println();
        }
    }
}
