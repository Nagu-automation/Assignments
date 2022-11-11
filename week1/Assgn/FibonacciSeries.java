package week1.Assgn;

public class FibonacciSeries {

	public static void main(String[] args) {
		// 0,1,1,2,3,5,8,13,21 
		//Initializing three variables and declaring the value for them
		int range = 8;
		int firstNum = 0;
		int secNum = 1;
		
		//Printing the first value of the series
		System.out.println(firstNum);
		
		//Iterating the loop to print the series of number till the range provided
		for(int i=1; i < range; i++)
		{
			int sum = firstNum + secNum; //Adding the n & n-1 value to get third value of the series and assigning to sum variable
			firstNum = secNum; //Swaping the second variable value to first variable value
			secNum = sum; //Swaping the sum variable value to second variable value, such that the series will continue till the range
			System.out.println(sum); //Printing the sum value
			
		}

	}

}
