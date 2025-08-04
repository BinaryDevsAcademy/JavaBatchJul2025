package StudentDataReadingApp;

public class Student {
	int studentId;
	String studentName;
//	int studentRollNo;
//	long studentPhoneNo;
//	String studentBranch;
	static String instituteName;
	
	public Student(int id, String name, String institute) {
		this.studentId = id;
		this.studentName = name;
		this.instituteName = institute;
	}
	
	public void takeAttendence() {
		System.out.println(this.studentName+" taking attendence");
	}
	
	public void takeAttendence(String studentName) {
		System.out.println(studentName + " is taking attendence");
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", instituteName=" + instituteName
				+ "]";
	}
	
	
	
//	@Override
//	public String toString() {
//		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentRollNo=" + studentRollNo
//				+ ", studentPhoneNo=" + studentPhoneNo + ", studentBranch=" + studentBranch + "]";
//	}	
}
