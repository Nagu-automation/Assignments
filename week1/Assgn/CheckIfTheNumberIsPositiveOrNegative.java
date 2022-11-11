package week1.Assgn;

public class CheckIfTheNumberIsPositiveOrNegative {

	public static void main(String[] args) {
		
		int number = 0; //initializing and declaring the value
		
		if(number > 0) //Checking that the given number is greater than 0
		{
			System.out.println("The number " + number + " is postive number"); //Printing the statement as positive if the given value is greater than zero
		}
		else if(number < 0) //Checking that the given number is greater than 0
		{
			System.out.println("The number " + number + " is negative number"); //Printing the statement as negative if the given value is less than zero
		}
		else
		{
			System.out.println("The number " + number + " is neither postive nor negative number"); //Printing the statement if the given value is zero
		}

	}

}
