package Operation;

import Tools.Board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Information.Notice;
import UI.UI_notice_posting;

public class ManagerOperation extends Operate{
	//operation manager can do.
	//Write notices, modify&delete notices, ...
	//manager id has this.

	//attributes
	
	//constructor
	public ManagerOperation(Board b) {
		super(b);
		// TODO Auto-generated constructor stub
	}
	
	//method
	public void NoticePosting(Notice n) {
		super.brd.addNotice(n);
		
		for (int i = 0; i < brd.getNoticeList().size(); i++) {
				System.out.printf("제목 : %s\n", brd.getNoticeList().get(i).getTitle());
				System.out.printf("내용 : %s\n", brd.getNoticeList().get(i).getContent());
				System.out.printf("모집 유형: %s\n", brd.getNoticeList().get(i).getScholar().getName());
				System.out.printf("모집 인원 : %d\n", brd.getNoticeList().get(i).getAccept());
				System.out.printf("마감 일시 : %d/%d/%d\n", brd.getNoticeList().get(i).getExpire_year(), brd.getNoticeList().get(i).getExpire_month(), brd.getNoticeList().get(i).getExpire_day());
		}
		
		try {
			notice_save(n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void notice_save(Notice n) throws IOException{
		
		File file = new File("notice.txt");
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file, true);
			writer.write(n.getTitle() + "\r\n");
			writer.write(n.getScholar().getName() + "\r\n");
			writer.write(n.getContent() + "\r\n");
			writer.write(n.getAccept() + "\r\n");
			//writer.write("마감 일시 : " );
			writer.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (writer != null) writer.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	
	public void DeleteNotice(Notice n) {
		super.brd.delNotice(n);
	}
}
