package week1.Assgn;

import org.apache.commons.lang3.ArraySorter;

public class MissingElementInAnArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };

		int[] arrSort = ArraySorter.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
				if(arrSort[i] != i+1)
				{
					System.out.println(i+1);
					break; 
				}
			
		}

	}

}
