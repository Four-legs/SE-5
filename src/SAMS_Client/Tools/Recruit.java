package Tools;

import java.io.Serializable;
import java.util.ArrayList;

import Information.Scholar;
import User.Student;

public class Recruit implements Serializable{
	//this class actually related with recruiting scholarship.
	//Manager Operation can recruit (each notices)
	//has information of scholarships, list of students who requested each scholarships.
	//this class doesn't have picking students up method. (the ManagerOperation class will have picking up method)
	//ManagerOperation class will supervise scholarship state through this class.
	
	//attributes
	private Scholar sch;	//scholarship instance
	private ArrayList<Student> RequestedStdList = new ArrayList<Student>();
		//Array of students requested this scholarship 
	private int accept;	//number of acceptable 
	private static final long serialVersionUID = 1L;
	
	//constructor
	public Recruit(Scholar sch, int acc) {
		this.sch = sch;
		this.accept = acc;
	}
	
	//method
	public Scholar getSch() {
		return sch;
	}
	
	public void setSch(Scholar sch) {
		this.sch = sch;
	}
	
	public ArrayList<Student> getRequestedStdList() {
		return RequestedStdList;
	}
	
	public void setRequestedStdList(ArrayList<Student> requestedStdList) {
		RequestedStdList = requestedStdList;
	}
	
	public int getAccept() {
		return accept;
	}
	
	public void setAccept(int accept) {
		this.accept = accept;
	}
	
	public void addStudent(Student std) {
		this.RequestedStdList.add(std);
	}//when student requests, add that student's information to array.
	
	public void delStudent(Student std) {
		this.RequestedStdList.remove(std);
	}//when student cancel a request, remove that student's information from array.
}
