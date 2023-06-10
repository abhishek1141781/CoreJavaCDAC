import java.util.Scanner;

public class SumProdArray {
	public static void main(String[] args) {
		
		System.out.print("Enter the number of numbers to enter: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
//		int[] store = new int[n]{}; //don't use {} along with []
		int[] store = new int[n];
		
		for(int i=0; i<n; i++) {
			System.out.print("Enter number " + (i+1) + " : ");
			store[i] = sc.nextInt();
		}
		
//		printProductPosition(int[] store);
		printProductPosition(store,n);
		
		int sum =0,product=1;
		
		for(int i=0; i<n; i++) {
			sum = sum + store[i];	
		}
		
		for(int i=0; i<n; i++) {
			product = product * store[i];	
		}
				
		System.out.println("Sum of numbers entered: " + sum);
		System.out.println("Product of numbers entered: " + product);
		
	}
	
//	private static void printProductPosition(Object store) {
//		// TODO Auto-generated method stub
//		
//	}

	// method to print num and its position
	public static void printProductPosition(int[] store,int n) {
		for(int i=0; i<n; i++) {
			System.out.println("1st position: " + store[i] + " * " + (i+1) + " = "+ store[i]*(i+1));
//			store[i]*(i+1)
		}
	}
//sc.close();
}
