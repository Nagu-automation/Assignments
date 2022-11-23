package week1.Assgn;

public class FibonacciSeries {

	public static void main(String[] args) {
		// 0,1,1,2,3,5,8,13,21 
		
		int range = 8;
		int firstNum = 0;
		int secNum = 1;
		
		System.out.println(firstNum);
		
		for(int i=1; i < range; i++)
		{
			int sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;
			System.out.println(sum);
			
		}

	}

}
