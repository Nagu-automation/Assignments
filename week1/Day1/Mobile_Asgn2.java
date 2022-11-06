package week1.Day1;

public class Mobile_Asgn2 {
	
	//Initiating & Declaring global variables	
	String mobileBrandName	= "Xiaomi Mi A1";
	char mobileLogo			= 'M';
	short noOfMobilePiece	= 100;
	int modelNumber			= 124578;
	long mobileImeiNumber	= 1234567890123456L;
	float mobilePrice		= 100.65F;
	boolean isDamaged		= false;

	public static void main(String[] args) {
		// Creating object to invoke global variables
		Mobile_Asgn2 mobile = new Mobile_Asgn2();
		
		//Printing global variables value in output console	
		System.out.println("Mobile Brand Name			:" + mobile.mobileBrandName);
		System.out.println("Mobile Logo				:" + mobile.mobileLogo);
		System.out.println("Mobile No of mobiles in pcs		:" + mobile.noOfMobilePiece);
		System.out.println("Mobile Model Number			:" + mobile.modelNumber);
		System.out.println("Mobile IMEI number			:" + mobile.mobileImeiNumber);
		System.out.println("Mobile Price				:" + mobile.mobilePrice);
		System.out.println("Mobile is Damaged?			:" + mobile.isDamaged);

	}

}
