package week2.day2.assignments;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// Build a logic to reverse the even position words (output: I ma a erawtfos
		// tester)

		// Pseudo Code:

		// Declare the input as Follow
		String test = "I am a software tester";
		// a) split the words and have it in an array

		String[] strArray = test.split(" ");

		// b) Traverse through each word (using loop)
		for (int i = 0; i < strArray.length; i++) {
			// c) find the odd index within the loop (use mod operator)
			if (i % 2 == 1) {
				// d)split the words and have it in an array
				String splitWord = strArray[i];
				char[] splitWordCharAry = splitWord.toCharArray();
				String revSplitWord = "";

				// e)print the even position words in reverse order using another loop (nested
				// loop)
				for (int j = splitWordCharAry.length - 1; j >= 0; j--) {
					revSplitWord = revSplitWord + splitWordCharAry[j];
				}
				// f) Convert words to character array if the position is even else print the
				// word as it is(concatenate space at the end).
				System.out.print(revSplitWord + " ");
			} else {
				System.out.print(strArray[i] + " ");
			}

		}

	}

}
