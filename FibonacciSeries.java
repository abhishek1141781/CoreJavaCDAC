//write a program to print Fibonacci Series up to 50 numbers in java 
public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 50;
        
        System.out.println("Fibonacci Series up to " + n + " numbers:");
        long[] fibonacci = new long[n];
        
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci[i] + " ");
        }
    }
}
