package week3.day2.Assign;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {

		// Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";
		
		//Splitting the each word by using Split method and storing it in String array
		String[] textString = text.split(" ");

		//Creating an object for Set interface by implementing 'linkedhashset' class
		Set<String> textSet = new LinkedHashSet<String>();

		/*
		 * Iterating the loop to add the split string into Set the reason to use set
		 * is that doesn't hold duplicate values Using linked hash set is maintain the
		 * value as order of insertion
		 */
		for (int i = 0; i < textString.length; i++) {

			textSet.add(textString[i]);

		}

		//Printing the each value available in the set variable
		for (String iniText : textSet) {

			System.out.print(iniText + " ");

		}

	}

}
