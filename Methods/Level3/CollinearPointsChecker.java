public class CollinearPointsChecker {
    public static void main(String[] args) {
        double x1 = 2, y1 = 4;
        double x2 = 4, y2 = 6;
        double x3 = 6, y3 = 8;

        System.out.println("Point A: (" + x1 + ", " + y1 + ")");
        System.out.println("Point B: (" + x2 + ", " + y2 + ")");
        System.out.println("Point C: (" + x3 + ", " + y3 + ")");

        boolean collinearBySlope = checkCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean collinearByArea = checkCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear by slope method: " + collinearBySlope);
        System.out.println("Collinear by area method: " + collinearByArea);
    }

    public static boolean checkCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        if (x2 - x1 == 0 && x3 - x2 == 0) return true;
        if (x2 - x1 == 0 || x3 - x2 == 0) return false;

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return Math.abs(slopeAB - slopeBC) < 0.0001 && Math.abs(slopeAB - slopeAC) < 0.0001;
    }

    public static boolean checkCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * Math.abs((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)));
        return Math.abs(area) < 0.0001;
    }
}