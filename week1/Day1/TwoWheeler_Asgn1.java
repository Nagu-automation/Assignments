package week1.Day1;

public class TwoWheeler_Asgn1 {
	
	//Initiating & Declaring global variables
	int noOfWheels 		= 4;
	short noOfMirrors 	= 2;
	long chassisNumber 	= 224477523645789625L;
	boolean isPunctured = true;
	String bikeName 	= "Pulsar 220F";
	double runningKM 	= 79879.235689;

	public static void main(String[] args) {
		
		// Creating object to invoke global variables
		TwoWheeler_Asgn1 twoWheeler = new TwoWheeler_Asgn1();
		
		//Printing global variables value in output console		
		System.out.println("Printing number of wheels	: " + twoWheeler.noOfWheels);
		System.out.println("Printing number of mirrors	: " + twoWheeler.noOfMirrors);
		System.out.println("Printing Chassis Number		: " + twoWheeler.chassisNumber);
		System.out.println("Printing Status of Puncture	: " + twoWheeler.isPunctured);
		System.out.println("Printing Name of the vehicle	: " + twoWheeler.bikeName);
		System.out.println("Printing Kilometer ran		: " + twoWheeler.runningKM);
		

	}

}
