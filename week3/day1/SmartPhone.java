package week3.day1;

public class SmartPhone extends AndroidPhone{
	
	public void connectWhatsApp() {
		System.out.println("Connecting to whatsapp");
	}
	
	public void takeVideo() {
		System.out.println("Recording a video from smartphone");
	}
	
	public static void main(String[] args) {
		
		SmartPhone smartPhone = new SmartPhone();
		
//		smartPhone.sendMsg();
//		smartPhone.makeCall();
//		smartPhone.saveContact();
		smartPhone.takeVideo();
//		smartPhone.connectWhatsApp();
		
	}

}
