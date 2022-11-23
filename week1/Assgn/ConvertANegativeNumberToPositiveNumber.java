package week1.Assgn;

public class ConvertANegativeNumberToPositiveNumber {

	public static void main(String[] args) {
		
		int value = -10;
		
		if(value < 0)
		{
			int conValue = value * -1;
			System.out.println("The give number " + value + " is converted to positive number " + conValue);
		}else
		{
			System.out.println("The give number " + value + " is already positive number");
		}

	}

}
