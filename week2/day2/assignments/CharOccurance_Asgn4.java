package week2.day2.assignments;

public class CharOccurance_Asgn4 {

	public static void main(String[] args) {
		// Check number of occurrences of a char (eg 'e') in a String

		char chr = 'a';

		String str = "welcome to chennai";

		// declare and initialize a variable count to store the number of occurrences

		int count = 0;

		// convert the string into char array

		char[] strAry = str.toCharArray();

		// get the length of the array

		int strAryLength = strAry.length;

		// traverse from 0 till the array length

		for (int i = 0; i < strAryLength; i++) {
			// Check the char array has the particular char in it
			if (strAry[i] == chr) {
				// if is has increment the count
				count++;
			}

		}

		// print the count out of the loop

		System.out.println("The give char '" + chr + "' occurance in the string '" + str + "' is " + count);
	}

}
