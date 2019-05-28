package User;

import java.io.Serializable;
import java.util.ArrayList;
import Operation.StudentOperation;
import Tools.Request;

public class Student extends User implements Serializable{
	//attributes
	public String studentNumber;
	public int grade;
	public int income;
	public double score;
	public StudentOperation sop;
	public ArrayList<Request> ReqList = new ArrayList<Request>();
	private static final long serialVersionUID = 1L;
	
	//constructor
	public Student(String id, String pw, String name, String StudentNumber, int grade, int income, double score) {
		super(id, pw);
		this.name = name;
		this.studentNumber = StudentNumber;
		this.grade = grade;
		this.income = income;
		this.score = score;
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