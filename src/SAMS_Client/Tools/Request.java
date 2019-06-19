package Tools;

import java.io.Serializable;

import Information.Scholar;

public class Request implements Serializable{
	//this class expresses a student's request information.
	//it doesn't actually 'do' request.
	//Student instance will request with this instance.
	
	//attributes
	private Scholar sch;	//instance of scholar.
	private boolean accepted;	//false : rejected, true : accepted
	private static final long serialVersionUID = 1L;
	
	//constructor
	public Request(Scholar sch) {
		this.sch = sch;
	}
	
	//methods
	public Scholar getSch() {
		return sch;
	}
	
	public void setSch(Scholar sch) {
		this.sch = sch;
	}
	
	public boolean isAccepted() {
		return accepted;
	}
	
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
