package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Information.Identity;
import Information.Id_List;
import Tools.Board;

public class Datahandler_student extends Datahandler{
	
	//SAVE
	public void board_save(Board brd) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = null;
		oos= new  ObjectOutputStream(new FileOutputStream("Board.dat"));
		oos.writeObject(brd);
		oos.close();
	}
	
	
	//load Identity list
	 
	   
	   // board file load
	   public Id_List Identity_veryfication() throws FileNotFoundException, IOException, ClassNotFoundException
	   {
		  Id_List id_list = null;
	      ObjectInputStream oos = null;
	      try {
	         oos = new  ObjectInputStream(new FileInputStream("Veryfication.dat"));
	         id_list = (Id_List) oos.readObject();
	         oos.close();
	        
	      }
	      catch(FileNotFoundException e) {
	         return null;
	      }
	      return id_list;
	   }


}
