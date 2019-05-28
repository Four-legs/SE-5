package Foundation;

import java.util.*;

import Data.Datahandler;
import Data.UserListData;
import Operation.ManagerOperation;
import Operation.StudentOperation;
import User.*;
import UI.*;
import Information.*;
import Tools.Board;
import java.io.*;

public class main {


	public static void main(String[] args) throws FileNotFoundException, IOException {

		UserListData ud = new UserListData();
		ud = load_accounts(ud);
		
		UI_login login = new UI_login(ud);
		login.setVisible(true);
		
	}
	
	public static void save(UserListData ud) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = null;
		oos= new  ObjectOutputStream(new FileOutputStream("Accounts.dat"));
		oos.writeObject(ud);
		oos.close();
	}
	
	public static void saveb(Board b) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = null;
		oos= new  ObjectOutputStream(new FileOutputStream("Board.dat"));
		oos.writeObject(b);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static UserListData load_accounts(UserListData ud) throws FileNotFoundException, IOException
	{
		ObjectInputStream ois = null;
		ois = new  ObjectInputStream(new FileInputStream("Accounts.dat"));
		try {
			ud = (UserListData)ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
		
		return ud;
	}


}