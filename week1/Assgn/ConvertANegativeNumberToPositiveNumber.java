package week1.Assgn;

public class ConvertANegativeNumberToPositiveNumber {

	public static void main(String[] args) {
		
		int value = -10; //Initializing and declaring the value
		
		if(value < 0) //Checking the given value is less than zero
		{
			int conValue = value * -1; //If the condition satisfies, then the given value is multiplied with -1 to convert the negative value to positive value
			System.out.println("The give number " + value + " is converted to positive number " + conValue); //Printing the coverted value
		}else
		{
			System.out.println("The give number " + value + " is already positive number"); // The statement will print if the given value is a positive value
		}

	}

}
