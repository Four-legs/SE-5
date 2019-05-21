package Data;

import java.io.Serializable;
import java.util.ArrayList;

import User.*;

public class UserListData implements Serializable{
	private static final long serialVersionUID = 1L;
	public ArrayList<User> Ulist = new ArrayList<User>();
	
	
	public ArrayList<User> getUlist() {
		if (Ulist == null) return null;
		return Ulist;
	}
	public void setUlist(ArrayList<User> ulist) {
		Ulist = ulist;
	}

	
}
