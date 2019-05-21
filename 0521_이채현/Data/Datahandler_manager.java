package Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Tools.Board;

public class Datahandler_manager extends Datahandler{

	// board file save
	public void board_save(Board brd) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = null;
		oos= new  ObjectOutputStream(new FileOutputStream("student.dat"));
		oos.writeObject(brd);
		oos.close();
	}
}
