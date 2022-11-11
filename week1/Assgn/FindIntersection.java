package week1.Assgn;

public class FindIntersection {

	public static void main(String[] args) {
		
		//Initializing and declaring the array variable & values
		int[] setI = {3,2,11,4,6,7};
		int[] setII = {1,2,8,4,9,7};
		
		//Iterating the loop to get the value one by one from first array variable
		for (int i = 0; i < setI.length; i++) {
			
			//Iterating the loop to get the value one by one from second array variable
			for (int j = 0; j < setII.length; j++) {
				
				//Checking the each value from first array variable with each value of second array variable
				if(setI[i] == setII[j])
				{
					System.out.println(setI[i]); //Printing the value if the matches with second array set
				}
				
			}
			
		}

	}

}
