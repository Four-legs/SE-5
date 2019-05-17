package Operation;

import java.util.Calendar;

import Information.*;
import Tools.Board;
import Tools.Recruit;
import User.Manager;

public class ManagerOperation extends Operate{
	//operation manager can do.
	//Write notices, modify&delete notices, ...
	//manager id has this.

	//attributes
	public Manager manager;
	
	//constructor
	public ManagerOperation(Board b, Manager m) {
		super(b);
		this.manager = m;
		// TODO Auto-generated constructor stub
	}
	
	//methods
	public Notice CreateNotice(Scholar sch, String title, String cont, Calendar c, int accept) {
		Notice n = new Notice(sch, accept);
		n.setTitle(title);
		n.setContent(cont);
		n.setExpiredate(c);
		return n;
	}//make notice instance with inputs from GUI text boxes.
	
	public Notice recruiting(Notice n) {
		//get recruit information
		Recruit rec = n.getRecruit();
		int count = 0;
		
		//get scholarship information and requested Student list from recruit
		//select students satisfies standard of scholarship.
		//(number of accept)
		while(count <= rec.accept) {
			//re-sort student array of recruit with ascending order of standard elements(score, income ..)
			
			//if number of selected student is over acceptable number, break while.
		}
		
		
		//let selected students know they are selected. 
		
		
		return n;
	}
	
	public void NoticePosting(Notice n) {
		super.brd.addNotice(n);
	}
	
	public void NoticeDelete(Notice n) {
		super.brd.delNotice(n);
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
}
