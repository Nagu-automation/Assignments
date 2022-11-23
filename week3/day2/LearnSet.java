package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class LearnSet {

	public static void main(String[] args) {

		String input = "google";
		char[] inputAry = input.toCharArray();

		Set<Character> uniqueChar = new LinkedHashSet<Character>();

		for (int i = 0; i < inputAry.length; i++) {

			uniqueChar.add(inputAry[i]);

		}

		System.out.print(uniqueChar);

	}

}
