package week1.Assgn;

import org.apache.commons.lang3.ArraySorter;

public class FindSecondLargest {

	public static void main(String[] args) {
		
		int value[] = {3,2,11,4,6,7}; //Intializing and declaring the array value
		
		int[] valueSort = ArraySorter.sort(value); //Sorting the array value and assigning that to a new variable
		
		System.out.println("The Second largest value is: " + valueSort[value.length-2]); //Printing the second largest value with the help of subtracting the total array length -2 to get the right index value

	}

}
