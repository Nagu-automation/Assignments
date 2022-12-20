package javaMarathon;

import java.util.ArrayList;
import java.util.List;

public class JavaProblem_19 {

	public static void main(String[] args) {

		String[] words = { "cool", "lock", "cook" };

		String word1 = words[0].toString();
		char[] charArray = word1.toCharArray();
		List<Character> output = new ArrayList<Character>();

		for (int i = 0; i < charArray.length; i++) {
			int countFinal = 0;
			for (int j = 1; j < words.length; j++) {
				String wrd = words[j].toString();
				char[] charArray2 = wrd.toCharArray();
				int count = 0;
				for (int k = 0; k < charArray2.length; k++) {
					if (charArray[i] == charArray2[k]) {

						count++;
					}

				}

				if (count >= 1) {
					countFinal = countFinal + count;
				}

			}
			if (countFinal >= words.length - 1) {
				output.add(charArray[i]);
			}

		}

		System.out.println(output);

	}

}
