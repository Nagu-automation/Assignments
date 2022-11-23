package week3.day1;

public class Calculator {

	public void add(int num1, int num2) {
		System.out.println("Addition of 2 integers: " + (num1 + num2));
	}

	public void add(int num1, int num2, int num3) {
		System.out.println("Addition of 3 integers: " + (num1 + num2 + num3));
	}

	public void sub(double num1, double num2) {
		System.out.println("Subtraction of 2 double datatype values: " + (num1 - num2));
	}

	public void sub(int num1, int num2) {
		System.out.println("Subtraction of 2 integers: " + (num1 - num2));
	}

	public void mul(int x, double y) {
		System.out.println("Multiplication of 1 int and 1 double value: " + x * y);
	}

	public void mul(double a, double b) {
		System.out.println("Multiplication of 2 double values: " + a * b);
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();

		calc.add(10, 20);
		calc.add(10, 20, 30);
		calc.sub(10.5, 15.25);
		calc.sub(2, 3);
		calc.mul(5, 3.33);
		calc.mul(5.5, 3.33);
	}

}
