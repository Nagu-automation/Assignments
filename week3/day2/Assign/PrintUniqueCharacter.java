package week3.day2.Assign;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {

		// PrintUniqueCharacter
		/*
		 * Problem
		 * 
		 * a) Take your name as input b) Print all unique characters only (any order)
		 * 
		 * Input: babu Output: a u
		 * 
		 */

			String input = "Nagaraj Arumugam";
			String inputIgnoreCase = input.toLowerCase();
		  
		//a) Convert String to Character array 
			char[] inputAry = inputIgnoreCase.toCharArray();
			
		//b) Create a new Set -> HashSet 
			Set<Character> nameChar = new HashSet<Character>();			
			
		//c) Add each character to the Set and if it is already there, remove it 
			for (int i = 0; i < inputAry.length; i++) {
				if(inputAry[i] != ' ')
				{
				nameChar.add(inputAry[i]);
				}
			}
			
		//d) Finally, print the set
			System.out.println(nameChar);
		  
		 

	}

}
