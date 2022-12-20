package javaMarathon;

public class JavaProblem_15 {

	public static boolean stringEquals(String[] input1, String[] input2) {

		// Getting two string array value and assigning them to local variable
		String[] word1 = input1;
		String[] word2 = input2;

		// Initializing the string variables to store the output values
		String string1 = "";
		String string2 = "";
		boolean out;

		// Iterating the loop to concatenating the array string value
		for (int i = 0; i < word1.length; i++) {

			string1 = string1 + word1[i];
		}

		for (int i = 0; i < word2.length; i++) {

			string2 = string2 + word2[i];
		}

		// Checking the both concatenating string values are same and return the status
		if (string1.contentEquals(string2)) {
			out = true;
		} else {
			out = false;
		}

		return out;
	}

	public static void main(String[] args) {

		String[] word1 = { "ab", "c" };
		String[] word2 = { "a", "bc" };

		boolean output = stringEquals(word1, word2);
		System.out.println(output);

	}

}
