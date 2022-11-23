package week3.day1.assign3;

public class AxisBank extends BankInfo {

	public void deposit() {
		System.out.println("Deposit account of Axis bank");
	}

	public static void main(String[] args) {

		AxisBank axisBank = new AxisBank();
		axisBank.saving();
		axisBank.fixed();
		axisBank.deposit();

	}

}
