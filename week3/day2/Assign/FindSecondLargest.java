package week3.day2.Assign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {

		// Here is the input
		int[] data = { 3, 2, 11, 4, 6, 7, 2, 3, 3, 6, 7 };
		// output= 7;

		//Pseudo Code: 
		//a) Create a empty Set Using TreeSet 
		Set<Integer> dataSet = new TreeSet<Integer>();
		
		//b) Declare for loop iterator from 0 to data.length and add into Set 
		for (int i = 0; i < data.length; i++) {
			dataSet.add(data[i]);
		}
		
		//c) converted Set into List 
		List<Integer> dataList = new ArrayList<Integer>();
		
		for (Integer dataLst : dataSet) {
			dataList.add(dataLst);
			
		}
		
		//d) Print the second last element from List
		Collections.reverse(dataList);
		System.out.println("The second largest value in the given data is: " + dataList.get(1));

	}

}
