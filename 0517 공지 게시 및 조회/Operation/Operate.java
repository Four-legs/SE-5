package Operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

import Information.Notice;
import Tools.Board;

public class Operate {
	//operations of User
	//in this class, the methods are the common use-case of Student and Manager.
	
	//attributes
	public Board brd;
	
	//constructor
	public Operate(Board b) {
		this.brd = b;
	}

	//methods
	public Board getBrd() {
		return brd;
	}

	public void setBrd(Board brd) {
		this.brd = brd;
	}
	
	public void ViewNotice() {
		try {
			notice_read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void notice_read() throws IOException{
		try
		{
			File file = new File("notice.txt");
			FileReader file_reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(file_reader);
			String line = "";
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
			// brd.addNotice(a);
		} catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
	}
}