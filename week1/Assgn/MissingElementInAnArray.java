package week1.Assgn;

import org.apache.commons.lang3.ArraySorter;

public class MissingElementInAnArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 7, 6, 8 }; //Initializing and declaring the array variable with value

		int[] arrSort = ArraySorter.sort(arr); //Sorting the value and storing it in new variable
		
		for (int i = 0; i < arr.length; i++) //Iterating the loop to check the each value from array with loop value
		{
				if(arrSort[i] != i+1) //Checking the loop value with array value
				{
					System.out.println(i+1); //Printing the value if it not matches
					break; //Breaks the loop if the missing value is found
				}
			
		}

	}

}
