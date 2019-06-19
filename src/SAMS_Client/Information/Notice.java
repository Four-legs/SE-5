package Information;

import java.io.Serializable;
import java.util.Calendar;

import Tools.Recruit;

public class Notice implements Serializable{
	//attributes
	private String title;	//title of notice
	private String content;	//content(text) of notice
	private int accept;		//number of acceptable students
	private Scholar scholar;	//instance of scholarship
	private Calendar expiredate = Calendar.getInstance();	//instance of expire date
	private Recruit recruit;
	private static final long serialVersionUID = 1L;
	
	//constructor
	public Notice(Scholar s, int accept) {
		this.scholar = s;
		this.accept = accept;
		this.recruit = new Recruit(this.scholar, this.accept);
	}
	
	//methods
	public int getAccept() {
		return accept;
	}

	public void setAccept(int accept) {
		this.accept = accept;
	}

	public Scholar getScholar() {
		return scholar;
	}

	public void setScholar(Scholar scholar) {
		this.scholar = scholar;
	}

	public void setTitle(String t) {
		this.title = t;
	}
	public String getTitle() {
		return this.title;
	}
	
	public void setContent(String c) {
		this.content = c;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setExpiredate(int y, int m, int d) {
		this.expiredate.set(y, m, d);
	}
	
	public Calendar getExpiredate() {
		return this.expiredate;
	}

	public Recruit getRecruit() {
		return recruit;
	}

	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}
	
	public String printExpdate() {
		return String.format(this.expiredate.get(Calendar.YEAR) + "-" + this.expiredate.get(Calendar.MONTH) + "-" + this.expiredate.get(Calendar.DATE) + "\n");
	}
	
	public String toString() {
		return String.format(title + "\n" + content);
	}
}
