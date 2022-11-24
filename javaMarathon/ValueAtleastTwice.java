package javaMarathon;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class ValueAtleastTwice {

	public static void main(String[] args) {

		// Getting the array of integer values
		int[] nums = { 1, 2 };

		// Initializing map collection to get the array values in map
		Map<Integer, Integer> numsMap = new TreeMap<Integer, Integer>();

		for (int i : nums) {
			numsMap.put(i, numsMap.getOrDefault(i, 0) + 1);
		}

		System.out.println(numsMap);

		// Creating a set object to get the map values by using entry set method
		Set<Entry<Integer, Integer>> numSet = numsMap.entrySet();

		int count = 0;
		int value = 2;

		// Iterating the loop to get the count of each value occurrence
		for (Entry<Integer, Integer> num : numSet) {
			if (num.getValue() > value) {
				
				// Printing the statement if any of the value available in the array has more
				// than one occurrence
				System.out.println("True, the given array has a value atleast twice");
				count++;
				break;
			}

		}

		if (count == 0) {
			// Printing the statement if the array has distinct value
			System.out.println("False, the given array has distinct values");
		}

	}

}
