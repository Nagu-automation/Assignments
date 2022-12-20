package javaMarathon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaProblem_18 {

	public static void main(String[] args) {

		String[] arr = { "a", "b", "a" };
		int k = 3;

		List<String> arrList = new ArrayList<String>();

		Map<String, Integer> arrMap = new LinkedHashMap<String, Integer>();

		for (int i = 0; i < arr.length; i++) {
			arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
		}

		Set<Entry<String, Integer>> entrySetValue = arrMap.entrySet();

		for (Entry<String, Integer> entry : entrySetValue) {

			if (entry.getValue() == 1) {
				arrList.add(entry.getKey());
			}

		}

		if (arrList.size() >= k) {
			System.out.println(arrList.get(k - 1));
		} else {
			System.out.println("''");
		}

	}

}
