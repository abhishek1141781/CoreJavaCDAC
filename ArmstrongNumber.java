//write a program to find the armstrong number in java

public class ArmstrongNumber {
    public static void main(String[] args) {
        int number, originalNumber, remainder, digits, result;
        
        for (number = 1; number <= 1000; number++) {
            originalNumber = number;
            digits = 0;
            result = 0;
            
            while (originalNumber != 0) {
                originalNumber /= 10;
                digits++;
            }
            
            originalNumber = number;
            
            while (originalNumber != 0) {
                remainder = originalNumber % 10;
                result += Math.pow(remainder, digits);
                originalNumber /= 10;
            }
            
            if (result == number) {
                System.out.println(number + " is an Armstrong number.");
            }
        }
    }
}
