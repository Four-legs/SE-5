package User;

import Operation.ManagerOperation;

public class Manager extends User{
	//attributes
	public ManagerOperation mop;
	
	//constructor
	public Manager() {
		this.type = 2;
	}
	
	public Manager(String name) {
		this.name = name;
		this.type = 2;
	}
	
	//methods
}