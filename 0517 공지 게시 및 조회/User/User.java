package User;

public class User {
	public String ID;
	public String PW;
	int type;		
	// 1 : Student, 2 : Manager
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
}