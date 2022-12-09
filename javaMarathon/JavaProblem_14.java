package javaMarathon;

public class JavaProblem_14 {

	public static void main(String[] args) {

		/*
		 * A sentence is a list of words that are separated by a single space with no
		 * leading or trailing spaces. Each word consists of lowercase and uppercase
		 * English letters.
		 * 
		 * A sentence can be shuffled by appending the 1-indexed word position to each
		 * word then rearranging the words in the sentence.
		 * 
		 * For example, the sentence "This is a sentence" can be shuffled as
		 * "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3". Given a shuffled
		 * sentence s containing no more than 9 words, reconstruct and return the
		 * original sentence.
		 */

		// Getting the shuffled sentences
		String s = "Myself2 Me1 I4 and3";
		String[] sArray;

		// Splitting the each word and storing it in the array
		sArray = s.split(" ");
		String[] sSplitArray = new String[sArray.length];
		
		// Storing the splitted word in the another array variable by using the integer that is appended at end of each word
		for (int i = 0; i < sArray.length; i++) {
			sSplitArray[(Integer.parseInt(sArray[i].substring(sArray[i].length() - 1))) - 1] = sArray[i].substring(0,
					sArray[i].length() - 1);

		}

		// Printing the each word from the array
		System.out.print("The sentence after shuffling: ");
		for (int i = 0; i < sSplitArray.length; i++) {
			System.out.print(sSplitArray[i] + " ");

		}

	}

}
