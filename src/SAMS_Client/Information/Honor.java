package Information;

import java.io.Serializable;

public class Honor extends Scholar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Honor(String name) {
		this.setName(name);
		this.setType(2);
		// TODO Auto-generated constructor stub
	}


}