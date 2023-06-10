
public class PalindromeUsingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 4456544;
		int bckp = num;
		String empty = "";
		int x=0;
		while(num>0)
		{
			x = num%10;
			empty += x;
			num =num/10;
		}
		
		if (bckp == Integer.valueOf(empty))
			System.out.println("The no is palindrome");
		else
			System.out.println("not palindrome");		
	}
}
