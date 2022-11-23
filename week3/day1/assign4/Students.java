package week3.day1.assign4;

public class Students {
	
	public void getStudentInfo(int id) {
		System.out.println("Identify number of the student: " + id);
		
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Name of the student: " + name);
		System.out.println("Identify number of the student: " + id);		
	}
	
	public void getStudentInfo(long phoneNumber, String emailId) {
		System.out.println("Email ID of the student: " + emailId);
		System.out.println("Phone number of the student: " + phoneNumber);		
	}

	public static void main(String[] args) {
		
		Students stu = new Students();
		
		stu.getStudentInfo(101);
		stu.getStudentInfo(101, "Nagaraj");
		stu.getStudentInfo(9842712345L, "firstname.lastname@xyz.com");
	}

}
