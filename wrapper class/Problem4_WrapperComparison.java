public class Problem4_WrapperComparison {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println("a == b: " + (a == b));
        System.out.println("c == d: " + (c == d));
        System.out.println("a.equals(b): " + (a.equals(b)));
        System.out.println("c.equals(d): " + (c.equals(d)));

        System.out.println("\nExplanation:");
        System.out.println("a == b is true because Java caches Integer objects for values from -128 to 127.");
        System.out.println("c == d is false because 200 is outside the cache, so 'c' and 'd' are distinct objects in memory.");
        System.out.println(".equals() always compares the actual int values, so it is true for both pairs.");
    }
}
