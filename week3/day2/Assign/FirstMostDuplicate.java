package week3.day2.Assign;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstMostDuplicate {

	public static void main(String[] args) {
		String input = "abbaba";

		// output: b

		// Psuedocode

		// 1) Map -> HashMap
		Map<Character, Integer> chrMap = new LinkedHashMap<Character, Integer>();

		// 2) String -> ch[] -> Get all the character -> occurance
		char[] inputChr = input.toCharArray();
		
		for (int i = 0; i < inputChr.length; i++) {
			chrMap.put(inputChr[i], chrMap.getOrDefault(inputChr[i], 0)+1);
			
		}
		
		Set<Entry<Character, Integer>> entryMapSet = chrMap.entrySet();
		
		// 3) Keep comparing the occurance with other values -> max value -> character
		char key = 0;
		int maxOccurance = 0; 
		for (Entry<Character, Integer> entry : entryMapSet) {
			if(entry.getValue()>maxOccurance)
			{
				key = entry.getKey();
				maxOccurance = entry.getValue();
			}else {
				 key=entry.getKey();
				 maxOccurance=entry.getValue();
			}
		}
			System.out.println(key);
			System.out.println(maxOccurance);
			
		
		
		

	}

}
