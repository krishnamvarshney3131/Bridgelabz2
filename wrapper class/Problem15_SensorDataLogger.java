import java.util.ArrayList;

public class Problem15_SensorDataLogger {

    private ArrayList<Double> sensorReadings = new ArrayList<>();

    public void logData(double primitiveTemp) {
        System.out.println("Logging primitive: " + primitiveTemp);
        sensorReadings.add(primitiveTemp);
    }

    public void logData(Double wrapperTemp) {
        System.out.println("Logging wrapper: " + wrapperTemp);
        sensorReadings.add(wrapperTemp);
    }

    public void printReadings() {
        System.out.println("\nSensor Data:");
        for (double temp : sensorReadings) {
            System.out.println("Reading: " + temp);
        }
    }

    public static void main(String[] args) {
        Problem15_SensorDataLogger logger = new Problem15_SensorDataLogger();
        
        double temp1 = 22.5;
        Double temp2 = Double.valueOf(23.1);

        logger.logData(temp1);
        logger.logData(temp2);

        logger.printReadings();
    }
}
