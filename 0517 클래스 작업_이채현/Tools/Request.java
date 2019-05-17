package Tools;

import Information.Scholar;

public class Request {
	//this class expresses a student's request information.
	//it doesn't actually 'do' request.
	//Student instance will request with this instance.
	
	//attributes
	public Scholar sch;	//instance of scholar.
	public boolean accepted;	//false : rejected, true : accepted
	
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
