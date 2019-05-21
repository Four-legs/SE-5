package Information;

import java.io.Serializable;

public class Scholar implements Serializable {
	//attributes
	public String name;
	public double std_score;
	public int type; //1 : Working, 2 : Honor
	
	
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

}