package week2.day2.assignments;

public class Palindrome_Asgn4 {

	public static void main(String[] args) {

		// Build a logic to find the given string is palindrome or not

//		  Pseudo Code

//		  a) Declare A String value as"madam"
		
		String value = "madam";
		
		char[] valueArray = value.toCharArray();

//		  b) Declare another String rev value as ""
		
		String stringRev = "";
		
//		  c) Iterate over the String in reverse order
		
		for (int i = value.length()-1; i >=0 ; i--) {
			
			stringRev = stringRev + valueArray[i];
			
		}
		
//		  d) Add the char into rev
//		  e) Compare the original String with the reversed String, if it is same then print palinDrome 

//		  Hint: Use .equals or .equalsIgnoreCase when you compare a String 
		
		if(value.equalsIgnoreCase(stringRev))
		{
			System.out.println("The given string '" + value + "' is palindrome");
		}else
		{
			System.out.println("The given string " + value + " is not palindrome");
		}

	}

}
