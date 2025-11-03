import java.util.ArrayList;

public class Problem19_PerformanceImpact {
    public static void main(String[] args) {
        int size = 1_000_000;

        // --- Test 1: ArrayList<Integer> ---
        ArrayList<Integer> list = new ArrayList<>(size);
        long start1 = System.nanoTime();
        
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        
        long sum1 = 0;
        for (int val : list) {
            sum1 += val;
        }
        long end1 = System.nanoTime();
        long duration1 = (end1 - start1) / 1_000_000;
        System.out.println("ArrayList<Integer> sum: " + sum1);
        System.out.println("ArrayList<Integer> time: " + duration1 + " ms");

        
        // --- Test 2: int[] ---
        int[] array = new int[size];
        long start2 = System.nanoTime();
        
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        
        long sum2 = 0;
        for (int val : array) {
            sum2 += val;
        }
        long end2 = System.nanoTime();
        long duration2 = (end2 - start2) / 1_000_000;
        System.out.println("int[] sum: " + sum2);
        System.out.println("int[] time: " + duration2 + " ms");
    }
}
