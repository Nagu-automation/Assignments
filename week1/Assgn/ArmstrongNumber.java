package week1.Assgn;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int number = 407;
		int value = number;
		int sum = 0;
		int[] temp = new int[3];
		for(int i=0; number > 0; i++)
		{
			temp[i] = number % 10;
			number = number/10;
		}
		
		for(int i=0; i < temp.length; i++)
		{
			sum = sum + (temp[i]*temp[i]*temp[i]);
		}
		
		if(value == sum)
		{
			System.out.println("The give number " + value + " is Amstrong number " + sum);
		}else
		{
			System.out.println("The give number " + value + " is not Amstrong number " + sum);
		}

	}

}
