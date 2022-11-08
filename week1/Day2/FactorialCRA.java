package week1.Day2;

public class FactorialCRA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input = 5;
		
		int fact = 1;
		
		for(int i=1; i<=input; i++) {
			fact  = fact*i;	
		}
		
		System.out.println("The factorial of given number is :" + fact);

	}

}
