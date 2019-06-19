package Information;

import java.io.Serializable;

public class Scholar implements Serializable{
	//attributes
	private String name;
	private double std_score;
	private int type; //1 : Working, 2 : Honor

	private static final long serialVersionUID = 1L;
	
	
	//methods
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getstd_score() {
		return std_score;
	}
	
	public void setstd_score(double std_score) {
		this.std_score = std_score;
	}	
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}