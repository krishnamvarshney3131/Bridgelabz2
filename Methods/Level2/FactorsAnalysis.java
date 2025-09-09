import java.util.Scanner;
public class FactorsAnalysis {
    public static int[] findFactors(int n) {
        int count = 0;
        for(int i=1;i<=n;i++) if(n%i==0) count++;
        int[] factors = new int[count];
        int index = 0;
        for(int i=1;i<=n;i++) if(n%i==0) factors[index++] = i;
        return factors;
    }
    public static int sumFactors(int[] arr) { int sum=0; for(int n:arr) sum+=n; return sum; }
    public static int sumSquareFactors(int[] arr) { int sum=0; for(int n:arr) sum+=Math.pow(n,2); return sum; }
    public static int productFactors(int[] arr) { int prod=1; for(int n:arr) prod*=n; return prod; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] factors = findFactors(n);
        System.out.println("Factors:");
        for(int f: factors) System.out.print(f+" ");
        System.out.println("\nSum:"+sumFactors(factors)+" SumSquare:"+sumSquareFactors(factors)+" Product:"+productFactors(factors));
    }
}