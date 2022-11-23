package javaMarathon;

public class Palindrome {

	public static void main(String[] args) {
		
		String inputValue = "A man, a plan, a canal: Panama";
		
		String inputValuelowCase = inputValue.toLowerCase();
		
		char[] valueTrim = inputValuelowCase.toCharArray();
		
		String strConcat = "";

		for (int i = 0; i < valueTrim.length; i++) {
			
			if(Character.isLetter(valueTrim[i]) || Character.isAlphabetic(valueTrim[i]))
			{
				strConcat = strConcat + valueTrim[i];
			}
			
		}
		
		char[] strConcatAry = strConcat.toCharArray();
		
		String strRevConcat = "";
		
		for (int i = strConcatAry.length-1; i >=0 ; i--) {
			
			
			strRevConcat = strRevConcat + strConcatAry[i];
		}
		
		if(strConcat.equalsIgnoreCase(strRevConcat))
		{
			System.out.println("The given string '" + inputValue + "' is palindrome: " + strRevConcat);
		}else
		{
			System.out.println("The given string '" + inputValue + "' is not palindrome: " + strRevConcat);
		}
		
		

	}

}
