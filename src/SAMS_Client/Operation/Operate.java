package Operation;

import java.io.FileNotFoundException;
import java.io.IOException;

import Tools.Board;

public class Operate {
	//operations of User
	//in this class, the methods are the common use-case of Student and Manager.
	
	//attributes
	protected Board brd;
		
	//constructor
	public Operate(Board b) {
		this.brd = b;
		initiate_Board();
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
	
	public void initiate_Board() {
	
	}
}
