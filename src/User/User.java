package User;

import java.io.Serializable;

public class User implements Serializable{
	public String ID;
	public String PW;
	public String name;
	int type;			//1 : Student, 2 : Manager
	private static final long serialVersionUID = 1L;
	
	public User() {
		
	}
	
	public User(String id, String pw) {
		this.ID = id;
		this.PW = pw;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}