package javaMarathon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaProblem_11 {

	public static void main(String[] args) {

		// Getting the input string
		String s = "abcdd";
		int count = 0;
		// Convert into char array
		char[] sArray = s.toCharArray();

		// Store the characters into Map with the count
		Map<Character, Integer> sMap = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < sArray.length; i++) {
			sMap.put(sArray[i], sMap.getOrDefault(sArray[i], 0) + 1);

			// Retrieving the character that appears twice first
			Set<Entry<Character, Integer>> sEntrySet = sMap.entrySet();
			for (Entry<Character, Integer> sEntry : sEntrySet) {
				if (sEntry.getValue() == 2) {
					System.out.println("The character that appears twice first is: " + sEntry.getKey());
					count++;
					break;
				}

			}
			if (count == 1) {
				break;
			}

		}

	}

}
