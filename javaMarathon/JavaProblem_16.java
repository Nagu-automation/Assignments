package javaMarathon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaProblem_16 {

	public static int findLuckyNumber(int[] value) {
		int[] arrvalue = value;
		int out = 0;
		List<Integer> finalKeyValue = new ArrayList<Integer>();
		Map<Integer, Integer> arrMap = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < arrvalue.length; i++) {
			arrMap.put(arrvalue[i], arrMap.getOrDefault(arrvalue[i], 0) + 1);

		}

		Set<Entry<Integer, Integer>> entrySetvalue = arrMap.entrySet();

		for (Entry<Integer, Integer> entryValue : entrySetvalue) {

			if (entryValue.getKey() == entryValue.getValue()) {
				finalKeyValue.add(entryValue.getKey());
			}

		}

		Collections.sort(finalKeyValue);

		if (finalKeyValue.size() > 0) {
			System.out.println("The lucky number is '" + finalKeyValue.get(finalKeyValue.size() - 1)
					+ "' and their frequency is '" + arrMap.get(finalKeyValue.get(finalKeyValue.size() - 1)) + "'");
		} else {
			out = -1;
		}

		return out;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 2, 2, 3, 3 };
		int output = findLuckyNumber(arr);
		if (output == -1) {
			System.out.println(output);
		}

	}

}
