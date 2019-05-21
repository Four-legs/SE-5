package Operation;

import java.io.Serializable;

import Tools.Board;

public class Operate implements Serializable {
	//operations of User
	//in this class, the methods are the common use-case of Student and Manager.
	
	//attributes
	public Board brd;
	
	//constructor
	public Operate(Board b) {
		this.brd = b;
	}

	//methods
	public Board getBrd() {
		return brd;
	}

	public void setBrd(Board brd) {
		this.brd = brd;
	}
	
	public void ViewNotice() {
		//
	}
}
