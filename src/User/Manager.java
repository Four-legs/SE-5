package User;

import java.io.Serializable;

import Operation.ManagerOperation;

public class Manager extends User implements Serializable{
	//attributes
	public ManagerOperation mop;
	private static final long serialVersionUID = 1L;
	
	//constructor
	public Manager(String id, String pw, String name) {
		super(id, pw);
		this.name = name;
		this.type = 2;
	}
	
	//methods
}