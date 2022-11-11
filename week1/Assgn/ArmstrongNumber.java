package week1.Assgn;

public class ArmstrongNumber {

	public static void main(String[] args) {
		//Initializing and declaring the value to the variable
		int number = 407;
		int value = number;
		int sum = 0;
		
		//Initializing the array and declaring the size of it
		int[] temp = new int[3];
		
		//Iterating the loop to separate the value 
		for(int i=0; number > 0; i++)
		{
			temp[i] = number % 10;
			number = number/10;
		}
		
		//Iterating the loop to sum the each cube value
		for(int i=0; i < temp.length; i++)
		{
			sum = sum + (temp[i]*temp[i]*temp[i]);
		}
		
		//Checking that the sum value is equal to given value
		if(value == sum)
		{
			System.out.println("The give number " + value + " is Amstrong number " + sum); //Printing this statement if the given and calculated values are same
		}else
		{
			System.out.println("The give number " + value + " is not Amstrong number " + sum); //Printing this statement if the given and calculated values are not same
		}

	}

}
