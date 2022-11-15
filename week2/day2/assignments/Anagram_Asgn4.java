package week2.day2.assignments;

import java.util.Arrays;

public class Anagram_Asgn4 {

	public static void main(String[] args) {

//		  Pseudo Code

//		 Declare a String 
		String str1 = "act";

//		 Declare another String
		String str2 = "cat";

//		  a) Check length of the strings are same then (Use A Condition)

		if (str1.length() == str2.length()) {
//			  b) Convert both Strings in to characters
			char[] strArry1 = str1.toCharArray();
			char[] strArry2 = str2.toCharArray();
//			  c) Sort Both the arrays

			Arrays.sort(strArry1);
			Arrays.sort(strArry2);

//			  d) Check both the arrays has same value
			int count = 0;
			for (int i = 0; i < strArry1.length; i++) {
				for (int j = 0; j < strArry2.length; j++) {
					if (strArry1[i] == strArry2[i]) {
						count++;
						break;
					}
				}

			}

			if (count == strArry1.length) {
				System.out.println("Both String values are same");
			} else {
				System.out.println("Both String values are not same");
			}

		} else {
			System.out.println("The given string sizes are not same");
		}

	}

}
