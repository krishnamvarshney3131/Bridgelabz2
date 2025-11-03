import java.util.ArrayList;
import java.util.Objects;

public class Problem16_ProductRatingsAnalyzer {
    public static void main(String[] args) {
        int[] oldRatings = {4, 5, 3};
        
        ArrayList<Integer> newRatings = new ArrayList<>();
        newRatings.add(5);
        newRatings.add(null);
        newRatings.add(4);

        ArrayList<Integer> allRatings = new ArrayList<>();
        
        for (int rating : oldRatings) {
            allRatings.add(rating);
        }
        allRatings.addAll(newRatings);

        int validSum = 0;
        int validCount = 0;

        for (Integer rating : allRatings) {
            if (Objects.nonNull(rating)) {
                validSum += rating;
                validCount++;
            }
        }

        double averageRating = (double) validSum / validCount;

        System.out.println("All Ratings (with nulls): " + allRatings);
        System.out.println("Average Valid Rating: " + averageRating);
    }
}
