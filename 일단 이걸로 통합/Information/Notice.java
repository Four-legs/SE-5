package Information;

import java.util.Calendar;

import Tools.Recruit;

public class Notice {
	//attributes
	public String title;	//title of notice
	public String content;	//content(text) of notice
	public int accept;		//number of acceptable students
	public Scholar scholar;	//instance of scholarship
	public Calendar expiredate = Calendar.getInstance();	//instance of expire date
	public Recruit recruit;
	
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
	
	public void setExpiredate(Calendar exp) {
		this.expiredate = exp;
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
}
