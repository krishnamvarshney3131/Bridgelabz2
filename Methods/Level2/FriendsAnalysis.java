import java.util.Scanner;
public class FriendsAnalysis {
    public static int youngest(int[] ages){ int min=ages[0]; for(int i:ages) if(i<min) min=i; return min; }
    public static int tallest(int[] heights){ int max=heights[0]; for(int i:heights) if(i>max) max=i; return max; }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] ages=new int[3]; int[] heights=new int[3];
        for(int i=0;i<3;i++){ ages[i]=sc.nextInt(); heights[i]=sc.nextInt(); }
        System.out.println("Youngest Age:"+youngest(ages)+" Tallest Height:"+tallest(heights));
    }
}