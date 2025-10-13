package Abstract;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    public String getInsuranceDetails() {
        return "Policy: " + insurancePolicy;
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    public String getInsuranceDetails() {
        return "Policy: " + insurancePolicy;
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.2;
    }

    public String getInsuranceDetails() {
        return "Policy: " + insurancePolicy;
    }
}

public class RentalApp {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("CAR123", 2000, "C-INS-789"),
            new Bike("BIKE456", 500, "B-INS-123"),
            new Truck("TRUCK789", 3500, "T-INS-456")
        };

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(rentalDays);
            double insurance = ((Insurable) v).calculateInsurance();
            String insuranceDetails = ((Insurable) v).getInsuranceDetails();

            System.out.println("Vehicle: " + v.getType());
            System.out.println("Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost (" + rentalDays + " days): " + rentalCost);
            System.out.println("Insurance: " + insurance);
            System.out.println("Insurance Details: " + insuranceDetails);
            System.out.println();
        }
    }
}