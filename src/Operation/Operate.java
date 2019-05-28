package Operation;

import java.io.FileNotFoundException;
import java.io.IOException;

import Data.Datahandler;
import Data.Datahandler_manager;
import Tools.Board;

public class Operate {
	//operations of User
	//in this class, the methods are the common use-case of Student and Manager.
	
	//attributes
	public Board brd;
	public Datahandler datahandle;
	
	//constructor
	public Operate(Board b) {
		this.brd = b;
		this.datahandle = new Datahandler();
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
		try {
			this.brd = this.datahandle.board_load();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
