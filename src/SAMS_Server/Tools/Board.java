package Tools;

import Information.Notice;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable{
	//has an array of Notice instance.
	//Student and Manager 'Observe' this instance. (this can be the part of using observer pattern.)
	//Student can look up notices and request scholarship through this class.
	//Manager can handle notices through this class.
	
	//attributes
	public ArrayList<Notice> NoticeList = new ArrayList<Notice>();
	private static final long serialVersionUID = 1L;
	
	//Constructor
	public Board() {
		//need nothing
	}
	
	//methods

	public ArrayList<Notice> getNoticeList() {
		return NoticeList;
	}

	public void setNoticeList(ArrayList<Notice> noticeList) {
		NoticeList = noticeList;
	}
	
	public void addNotice(Notice n) {
		NoticeList.add(n);
	} //add a notice in a board
	
	public void delNotice(Notice n) {
		NoticeList.remove(n);
	} //delete a notice from a board
}
