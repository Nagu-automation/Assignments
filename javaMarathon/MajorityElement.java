package javaMarathon;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MajorityElement {

	public static void main(String[] args) {

		//Getting the array of integer values
		int[] nums = { 2,2,1,1,1,2,2 };

		//Initializing map collection to get the array values in map
		Map<Integer, Integer> numsMap = new TreeMap<Integer, Integer>();
		
		for (int i : nums) {
			numsMap.put(i, numsMap.getOrDefault(i, 0)+1);
		}
		
		System.out.println(numsMap);
		
		//Creating a set object to get the map values by using entry set method
		Set<Entry<Integer, Integer>> numSet = numsMap.entrySet();
		
		int Key = 0;
		int value = 0;
		
		//Iterating the loop to check which element has majority count and assigning into the specified variable
		for (Entry<Integer, Integer> num : numSet) {
			if(num.getValue()>value)
			{
				Key = num.getKey();
				value = num.getValue();
			}
			
		}
		
		//Printing the majority element
		System.out.println("The majority element is: " + Key + " : " + value);

	}

}
