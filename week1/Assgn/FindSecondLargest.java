package week1.Assgn;

import org.apache.commons.lang3.ArraySorter;

public class FindSecondLargest {

	public static void main(String[] args) {
		
		int value[] = {3,2,11,4,6,7};
		
		int[] valueSort = ArraySorter.sort(value);
		
		System.out.println("The Second largest value is: " + valueSort[value.length-2]);

	}

}