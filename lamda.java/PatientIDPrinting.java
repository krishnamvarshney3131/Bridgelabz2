import java.util.*;

public class PatientIDPrinting {
    public static void main(String[] args) {
        List<String> ids = Arrays.asList("P101", "P102", "P103");

        ids.forEach(System.out::println);  // method reference
    }
}

