package StudentDataReadingApp;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student student1 = new Student(1, "Ram", "SBI");
		Student student2 = new Student(2, "Tony", "SBI");
		Student student3 = new Student(3, "Ria", "SBI");
		
		Student.instituteName = "RBI";
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
//		student1.studentId = scan.nextInt();
//		scan.nextLine();
//		student1.studentName = scan.nextLine();
//		student1.studentPhoneNo = scan.nextLong();
//		student1.studentBranch = scan.next();
//		student1.studentRollNo = scan.nextInt();
//		
//		System.out.println(student1);
	}

}



//create a javabased application 
//customer registration
//customer login