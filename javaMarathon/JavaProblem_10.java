package javaMarathon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaProblem_10 {

	public static void main(String[] args) {

		// Getting the stones and jewel values
		String jewels = "aA";
		String stones = "aAAbbbb";
		int count = 0;
		// Converting the stones and jewel values into character array
		char[] jewelsArray = jewels.toCharArray();
		char[] stonesArray = stones.toCharArray();

		// Storing the each stones values into map collection
		Map<Character, Integer> stonesMap = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < stonesArray.length; i++) {
			stonesMap.put(stonesArray[i], stonesMap.getOrDefault(stonesArray[i], 0) + 1);
		}

		// Iterating the loop to get the count of jewels in stones
		Set<Entry<Character, Integer>> stonesEntrySet = stonesMap.entrySet();
		for (int i = 0; i < jewelsArray.length; i++) {
			for (Entry<Character, Integer> stoneEntry : stonesEntrySet) {
				if (jewelsArray[i] == stoneEntry.getKey()) {
					// Sum up the each jewels available in the stones
					count = count + stoneEntry.getValue();
					break;
				}

			}

		}

		// Displaying the count of jewels in the stones

		System.out.println("The jewels count in the stones is: '" + count + "'");

	}

}
