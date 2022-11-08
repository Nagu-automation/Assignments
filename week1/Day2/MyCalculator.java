package week1.Day2;

public class MyCalculator {

	public static void main(String[] args) {

		Calculator cal = new Calculator();

		int addition = cal.add(10, 20, 30);
		int subtraction = cal.sub(20, 10);
		double multiplication = cal.mul(5.25, 5.30);
		float division = cal.div(30F, 2.3F);

		System.out.println("The value of addition is 	:" + addition);
		System.out.println("The value of subtraction is 	:" + subtraction);
		System.out.println("The value of multiplication is 	:" + multiplication);
		System.out.println("The value of division is 	:" + division);

	}

}
