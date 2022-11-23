package week3.day2.Assign;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesII {

	public static void main(String[] args) {
//		Declare a String as PayPal India
		String input = "PayPal";

//		Convert it into a character array
		char[] inputAry = input.toCharArray();

//		Declare a Set as charSet for Character
		Set<Character> charSet = new LinkedHashSet<Character>();

//		Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet = new LinkedHashSet<Character>();

//		Iterate character array and add it into charSet
		for (int i = 0; i < inputAry.length; i++) {
//			if the character is already in the charSet then, add it to the dupCharSet
			if (charSet.contains(inputAry[i])) {
				dupCharSet.add(inputAry[i]);
			} else {
				charSet.add(inputAry[i]);
			}
		}

		System.out.println(charSet);
		System.out.println(dupCharSet);

		/*
		 * Iterate using charSet Check the iterator variable isn't equals to an empty
		 * space Print it
		 */

		for (Character chrSet : charSet) {
			if (chrSet != ' ') {
				System.out.print(chrSet + ", ");
			}

		}

	}

}
