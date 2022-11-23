package javaMarathon;

public class LastWordLength {

	public static void main(String[] args) {
		
		String strValue = "luffy is still joyboy";
		
		String[] strValueAry = strValue.split(" ");
		
		String lastWord = strValueAry[strValueAry.length - 1];
		
		System.out.println("The length of last word from the given string is '" + lastWord + "': " + lastWord.length());

	}

}