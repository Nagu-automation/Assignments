package javaMarathon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaProblem_17 {

	public static void main(String[] args) {

		int count = 0;
		int[] nums = { 1,2,3,4,5};
		Map<Integer, Integer> numMap = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
		}

		Set<Entry<Integer, Integer>> entrySetNum = numMap.entrySet();
		for (Entry<Integer, Integer> entry : entrySetNum) {
			if (entry.getValue() == 1) {
				count = count + entry.getKey();
			}

		}

		if (count > 0) {
			System.out.println("The sum of unique integer in the given array is: " + count);
		} else {
			System.out.println("The given array doesnt have unique value: " + count);
		}

	}

}
