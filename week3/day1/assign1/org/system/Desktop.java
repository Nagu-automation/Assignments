package week3.day1.assign1.org.system;

//Creating a class desktop by extending the parent class computer
public class Desktop extends Computer {
	
	//Creating a method to implement desktop size
	public void desktopSize() {
		System.out.println("Size of the desktop");
	}

	public static void main(String[] args) {

		//Creating a object for dekstop class to invoke the methods in the current and parent class
		Desktop deskTop = new Desktop();
		
		deskTop.computerModel();
		deskTop.desktopSize();

	}

}
