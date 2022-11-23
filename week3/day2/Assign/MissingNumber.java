package week3.day2.Assign;

import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {

		// Getting the random numbers range between 1 to 10 in an array
		int[] input = { 1, 8, 1, 5, 1, 3, 8, 1 };

		/*
		 * Creating a set interface by implementing TreeSet class; Reason to use the Set
		 * is to eliminate duplicate values; Reason to use tree set is to organize the
		 * data/items in ascending order
		 */

		Set<Integer> inputSet = new TreeSet<Integer>();

		// Iterating the loop to store the array values into set variable
		for (int i = 0; i < input.length; i++) {

			inputSet.add(input[i]);

		}

		// Printing the unique inputs that we received
		System.out.println(inputSet);

		// Checking and printing the numbers that are not available in the set variable
		System.out.print("The missing numbers are: ");

		for (int i = 1; i <= 10; i++) {
			if (!inputSet.contains(i)) {
				System.out.print(i + ", ");
			}
		}

	}

}
