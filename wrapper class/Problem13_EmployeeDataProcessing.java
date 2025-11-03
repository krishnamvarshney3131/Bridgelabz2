import java.util.ArrayList;
import java.util.Collections;

public class Problem13_EmployeeDataProcessing {
    public static void main(String[] args) {
        int[] ages = {34, 22, 45, 60, 22, 38};

        ArrayList<Integer> ageList = new ArrayList<>();
        for (int age : ages) {
            ageList.add(age);
        }

        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        System.out.println("Employee Ages: " + ageList);
        System.out.println("Youngest Employee: " + youngest);
        System.out.println("Oldest Employee: " + oldest);
    }
}
