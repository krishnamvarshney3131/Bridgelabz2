class Vehicle {
    private static double registrationFee = 5000.0;
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: " + registrationFee);
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name          : " + ownerName);
            System.out.println("Vehicle Type        : " + vehicleType);
            System.out.println("Registration Number : " + registrationNumber);
            System.out.println("Registration Fee    : " + registrationFee);
        } else {
            System.out.println("Not a valid Vehicle object.");
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Rahul Sharma", "Car", "UP32AB1234");
        Vehicle v2 = new Vehicle("Priya Verma", "Bike", "DL5CD6789");

        v1.displayVehicleDetails();
        System.out.println("----------------------");
        v2.displayVehicleDetails();

        System.out.println("======================");

        Vehicle.updateRegistrationFee(6000.0);

        v1.displayVehicleDetails();
        System.out.println("----------------------");
        v2.displayVehicleDetails();
    }
}

