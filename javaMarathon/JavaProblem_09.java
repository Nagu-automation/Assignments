package javaMarathon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaProblem_09 {

	public static int findingNonRepeatCharacter(String name) {

		// Getting the input as string
		String s = name;
		int output = 0;
		// Convert the string to char array
		char[] sArray = s.toCharArray();
		System.out.println(sArray);

		// Get the count of each characters in Linked Has Map to maintain order of
		// insertion
		Map<Character, Integer> sMap = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < sArray.length; i++) {

			sMap.put(sArray[i], sMap.getOrDefault(sArray[i], 0) + 1);

		}

		System.out.println(sMap);

		// Check each character count whether its > 1 by iterating and break the loop if
		// the first match found
		Set<Entry<Character, Integer>> sMapSet = sMap.entrySet();

		for (Entry<Character, Integer> entry : sMapSet) {
			if (entry.getValue() == 1) {
				output = s.indexOf(entry.getKey());
				break;
			} else {
				output = -1;
			}
		}
		return output;
	}

	public static void main(String[] args) {

		int value = findingNonRepeatCharacter("aabb");
		if (value > 0) {
			System.out.println("The index is '" + value + "'");
		} else {
			System.out.println("The index is '" + value + "'");
		}

	}

}
