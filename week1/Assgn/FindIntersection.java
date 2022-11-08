package week1.Assgn;

public class FindIntersection {

	public static void main(String[] args) {
		
		int[] setI = {3,2,11,4,6,7};
		int[] setII = {1,2,8,4,9,7};
		
		for (int i = 0; i < setI.length; i++) {
			
			for (int j = 0; j < setII.length; j++) {
				
				if(setI[i] == setII[j])
				{
					System.out.println(setI[i]);
				}
				
			}
			
		}

	}

}
