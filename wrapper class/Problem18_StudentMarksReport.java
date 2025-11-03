import java.util.ArrayList;

public class Problem18_StudentMarksReport {
    public static void main(String[] args) {
        Object[] marksInput = {"85", 95, Integer.valueOf(88), "null", "abc", null, 78};
        ArrayList<Integer> validMarks = new ArrayList<>();

        for (Object input : marksInput) {
            if (input instanceof Integer) {
                validMarks.add((Integer) input);
            } else if (input instanceof String) {
                String strInput = (String) input;
                if (!strInput.equalsIgnoreCase("null")) {
                    try {
                        validMarks.add(Integer.parseInt(strInput));
                    } catch (NumberFormatException e) {
                        // Ignore invalid strings like "abc"
                    }
                }
            }
        }

        int sum = 0;
        for (int mark : validMarks) {
            sum += mark;
        }

        double average = (double) sum / validMarks.size();
        
        System.out.println("Valid Marks: " + validMarks);
        System.out.println("Average Mark: " + average);
    }
}
