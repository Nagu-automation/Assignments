package week2.day2.assignments;

public class FindTypes_Asgn4 {

	public static void main(String[] args) {
		// Here is the input
		String test = "$$ Welcome to 2nd Class of Automation $$ ";

		// Here is what the count you need to find
		int letter = 0, space = 0, num = 0, specialChar = 0;

		// Build the logic to find the count of each
		/*
		 * Pseudo Code: a) Convert the String to character array 
		 * b) Traverse through each character (using loop) 
		 * c) Find if the given character is what type using
		 * (if) i) Character.isLetter ii) Character.isDigit iii)Character.isSpaceChar
		 * iv) else -> consider as special character
		 */
		
		char[] testArray = test.toCharArray();
		
		for(int i=0; i<testArray.length;i++)
		{
			if(Character.isLetter(testArray[i]))
			{
				letter++;
			}else if (Character.isDigit(testArray[i])) {
				num++;
			}else if (Character.isSpaceChar(testArray[i]))
			{
				space++;
			}else
			{
				specialChar++;
			}
		}

		// Print the count here
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("specialCharcter: " + specialChar);

	}

}
