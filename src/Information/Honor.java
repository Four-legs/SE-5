package Information;

import java.io.Serializable;

public class Honor extends Scholar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Honor(String name) {
		this.name = name;
		this.type = 2;
		// TODO Auto-generated constructor stub
	}


}