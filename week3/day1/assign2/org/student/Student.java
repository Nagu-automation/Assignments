package week3.day1.assign2.org.student;

import week3.day1.assign2.org.department.Department;

public class Student extends Department{
	
	public void studentName() {
		System.out.println("Name of the student");
	}
	
	public void studentDept() {
		System.out.println("Name of the student's department");
	}
	
	public void studentId() {
		System.out.println("Name of the student's id");
	}

	public static void main(String[] args) {

		Student stu = new Student();
		stu.collegeName();
		stu.collegeCode();
		stu.collegeRank();
		stu.deptName();
		stu.studentName();
		stu.studentId();
		stu.studentDept();
	}

}
