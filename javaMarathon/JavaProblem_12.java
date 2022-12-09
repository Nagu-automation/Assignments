package javaMarathon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaProblem_12 {

	public static boolean occuranceDuplicate(int[] input) {
		// Getting the array of integers
		int[] arr = input;
		int count = 0;
		boolean out;
		// Storing the each value into Map collection along with count
		Map<Integer, Integer> arrMap = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);

		}

		List<Integer> mapValue = new ArrayList<Integer>();
		Set<Entry<Integer, Integer>> entrySet = arrMap.entrySet();

		for (Entry<Integer, Integer> entry : entrySet) {
			mapValue.add(entry.getValue());

		}

		// Checking whether all the integers available in the array are unique
		for (Integer mpVaue : mapValue) {
			for (Integer mpVaue2 : mapValue) {
				if (mpVaue.equals(mpVaue2)) {
					count++;
				}
				if (count == 2) {
					break;
				}

			}

		}
		
		//Returning true if the given array's contains characters are having unique count else false
		if (count == 2) {
			out = true;
		} else {
			out = false;
		}

		return out;
	}

	public static void main(String[] args) {

		/*
		 * Problem Statement:
		 * 
		 * Given an array of integers arr, return true if the number of occurrences of
		 * each value in the array is unique, or false otherwise.
		 * 
		 * Example 1:
		 * 
		 * Input: arr = [1,2,2,1,1,3] Output: true Explanation: The value 1 has 3
		 * occurrences, 2 has 2 and 3 has 1. No two values have the same number of
		 * occurrences.
		 */
		int[] inp = { 1, 1, 2, 2, 2 };
		boolean output = occuranceDuplicate(inp);
		System.out.println(output);

	}

}
