import java.util.Scanner;
public class NumberAnalysis {
    public static boolean isPositive(int n){ return n>=0; }
    public static boolean isEven(int n){ return n%2==0; }
    public static int compare(int a,int b){ return a>b?1:(a==b?0:-1); }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[5];
        for(int i=0;i<5;i++) arr[i]=sc.nextInt();
        for(int n:arr){
            if(isPositive(n)) System.out.println(n+" is Positive "+(isEven(n)?"Even":"Odd"));
            else System.out.println(n+" is Negative");
        }
        int cmp=compare(arr[0],arr[4]);
        System.out.println("First vs Last: "+(cmp==1?"Greater":cmp==-1?"Less":"Equal"));
    }
}