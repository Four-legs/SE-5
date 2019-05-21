package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


import Tools.Board;

public class Datahandler {

	private Board brd = new Board();
	
	// board file load
	public Board board_load() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream oos = null;
		oos = new  ObjectInputStream(new FileInputStream("student.dat"));
		brd = (Board) oos.readObject();
		oos.close();
		
		return brd;
	}
}
