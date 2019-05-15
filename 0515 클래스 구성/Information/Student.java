package Information;

public class Student extends User {
	public String name;
	public String studentNumber;
	public String grade;
	public int income;
	
	public Student(String stdnum) {
		this.studentNumber = stdnum;
		this.type = 1;
	}
	
	
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	//String applicationForm;
	//String 
}