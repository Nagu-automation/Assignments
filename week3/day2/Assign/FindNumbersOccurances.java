package week3.day2.Assign;

import java.util.Map;
import java.util.TreeMap;

public class FindNumbersOccurances {

	public static void main(String[] args) {

		// Input array numbers, each occurrences

		int[] input = { 2, 3, 5, 6, 3, 2, 1, 4, 2, 1, 6, -1 };

		// output: 2 -> 3 , 3 -> 2, 4 -> 1

		// Psuedcode:

		// 1) Create Map -> TreeMap
		Map<Integer, Integer> inputMap = new TreeMap<Integer, Integer>();

		// 2) For loop -> each number -> add to the map
		// 3) If it is exist -> update it with + 1; Else -> new entry with 1 as value

		for (int i = 0; i < input.length; i++) {
			/*
			 * if (!inputMap.containsKey(input[i])) { inputMap.put(input[i], 1); } else {
			 * inputMap.put(input[i], inputMap.get(input[i]) + 1); }
			 */

			inputMap.put(input[i], inputMap.getOrDefault(input[i], 0) + 1);

		}

		System.out.println(inputMap);

	}

}
