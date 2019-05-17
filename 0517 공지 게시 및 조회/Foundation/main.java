package Foundation;

import java.util.*;

import User.*;
import UI.*;
import Tools.Board;
import java.io.*;

public class main {
	public static int userNum = 0;
	public static Student std = new Student("");
	public static Manager mng = new Manager();
	public static Board brd;

	public static void main(String[] args) {
		UI_login login = new UI_login();
		login.setVisible(true);

		int loginNumber = 0;
		String ID, PW, IDNumber;
		String savedID = null, savedPW = null, savedIDNumber = null;
		String line = null;
		String line2 = null;
		int num = 0;
		int err = 0;
		int check_login = 0;

		String loginInfo = "loginInfo.txt";

		File file = new File(loginInfo);
		FileWriter fw = null;

		try {
			fw = new FileWriter(file, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {// login check

			check_login = login.getCheck_login();
			System.out.printf("check_login : %d \n", check_login);
			if (check_login == 1) {
				ID = login.getId();
				PW = login.getPw();
				System.out.printf("ID %s PW %s\n", ID, PW);
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));

					while ((line = br.readLine()) != null) {

						int idx = line.indexOf("@");

						int idx2 = line.indexOf("#");
						savedIDNumber = line.substring(0, idx);
						savedID = line.substring(idx + 1, idx2);
						savedPW = line.substring(idx2 + 1);

						if (savedID.equals(ID) && savedPW.equals(PW)) {
							err = 1;
							break;
						}
					}
					if (err == 0) {
						login.login_fault();
						continue;
					} else {
						System.out.println("로그인 성공");
						userNum = Integer.parseInt(savedIDNumber);
						brd = new Board();
						
						if (userNum == 1) {
							login.setVisible(false);
							
							std.setID(savedID); // test를 위한 객체 생성
							std.setPW(savedPW);
							std.setName("경예지");
							std.setStudentNumber("2015110229");
							std.setGrade(4);
							std.setScore(4.3);
							std.setIncome(2);
							System.out.println("학생 객체 생성 성공");
							
							UI_main_student std_main = new UI_main_student(std, brd);
							std_main.setVisible(true);
						}
						else {
							login.setVisible(false);
							
							mng.setID(savedID); // test를 위한 객체 생성
							mng.setPW(savedPW);
							System.out.println("관리자 객체 생성 성공");
							
							UI_main_manager mng_main = new UI_main_manager(mng, brd);
							mng_main.setVisible(true);
						}
						break;
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null)
						try {
							br.close();
						} catch (IOException e) {
						}
				}
			}
		}
	}

	public static Board getBrd() {
		return brd;
	}

	public static void setBrd(Board brd) {
		main.brd = brd;
	}
}