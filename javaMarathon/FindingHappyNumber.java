package javaMarathon;

public class FindingHappyNumber {

	public static void main(String[] args) {

		int input = 130;
		//int rem = 0;
		int countSpe = input;
		int count = 0;

		
		while (input > 1) {
			
			do {
				countSpe = countSpe / 10;
				count++;
			} while (countSpe > 0);

			int[] splitValue = new int[count];

			int nextValue = 0;

			int i = 0;

			do {
				splitValue[i] = input % 10;
				input = input / 10;
				i++;
			} while (input >= 1);

			for (int j = 0; j < splitValue.length; j++) {
				nextValue = (int) (nextValue + Math.pow(splitValue[j], 2));
			}
			input = nextValue;
			count = i-1;
				
		}

		//System.out.println(input);
	}

}
