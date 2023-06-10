
public class PalindromeUsingReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num  =452;
		int numBckp = num;
		int reverse =0;
		
		while(num>0)
		{
			int remainder = num%10;
			reverse = reverse*10 + remainder;
			num /= 10;
		}
		
		if(numBckp==reverse)
			System.out.println("Palindrome");
		else
			System.out.println("not palindrome");
	}

}
