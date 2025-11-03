public class Problem2_WrapperToPrimitive {
    public static void main(String[] args) {
        Double wrapperDouble = 45.67;

        double primitiveDouble = wrapperDouble.doubleValue();
        int primitiveInt = wrapperDouble.intValue();

        System.out.println("Wrapper Double: " + wrapperDouble);
        System.out.println("Primitive double: " + primitiveDouble);
        System.out.println("Primitive int (casted): " + primitiveInt);
    }
}
