package Operation;

import Information.Notice;
import User.Student;
import Tools.Board;
import Tools.Request;

public class StudentOperation extends Operate {
	//operation student can do.
	//search notices, request scholarship, ...
	//student id has this.

	//attributes
	private Student student;
	
	//constructor
	public StudentOperation(Student s, Board b) {
		super(b);
		this.student = s;
	}
	
	//methods
	
	public Notice requesting(Notice n) {
		Request req = new Request(n.getScholar());
		n.getRecruit().addStudent(this.student);
		this.student.getReqList().add(req);
		
		return n;
	}
	//make request instance with scholarship information from notice.
	//and add request to request array of student class

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
