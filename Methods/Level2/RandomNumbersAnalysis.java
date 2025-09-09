import java.util.Scanner;
import java.util.Arrays;
public class RandomNumbersAnalysis {
    public static int[] generate4DigitRandomArray(int size){
        int[] arr=new int[size];
        for(int i=0;i<size;i++) arr[i]=(int)(Math.random()*9000)+1000;
        return arr;
    }
    public static double[] findAverageMinMax(int[] numbers){
        int min=numbers[0],max=numbers[0],sum=0;
        for(int n:numbers){ sum+=n; if(n<min) min=n; if(n>max) max=n; }
        return new double[]{sum/(double)numbers.length,min,max};
    }
    public static void main(String[] args){
        int[] arr=generate4DigitRandomArray(5);
        double[] res=findAverageMinMax(arr);
        System.out.println("Numbers: "+Arrays.toString(arr));
        System.out.println("Average:"+res[0]+" Min:"+res[1]+" Max:"+res[2]);
    }
}