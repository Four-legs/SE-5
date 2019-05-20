package User;

import java.util.ArrayList;
import Operation.StudentOperation;
import Tools.Request;

public class Student extends User {
	//attributes
	public String studentNumber;
	public int grade;
	public int income;
	public double score;
	public StudentOperation sop;
	public ArrayList<Request> ReqList = new ArrayList<Request>();
	
	//constructor
	public Student(String stdnum) {
		this.studentNumber = stdnum;
		this.type = 1;
	}
	
	public Student(String name, String studentNumber, String grade, String income, String score) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.grade = Integer.parseInt(grade);
		this.income = Integer.parseInt(income);
		this.score = Double.parseDouble(score);
		this.type = 1;
	}
	
	//methods
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public StudentOperation getSop() {
		return sop;
	}

	public void setSop(StudentOperation sop) {
		this.sop = sop;
	}

	public ArrayList<Request> getReqList() {
		return ReqList;
	}

	public void setReqList(ArrayList<Request> reqList) {
		ReqList = reqList;
	}
	
	
	
	//String applicationForm;
	//String 
}