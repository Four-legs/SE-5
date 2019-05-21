package Foundation;

import java.util.*;

import Data.Datahandler;
import Operation.ManagerOperation;
import User.*;
import UI.*;
import Tools.Board;
import java.io.*;

public class main {
	public static int userNum = 0;
	public static Student std = new Student("");
	public static Manager mng = new Manager();
	public static Board brd = new Board();

	public static void main(String[] args) throws ClassNotFoundException {
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
						
						//login sucess
						//datahandler add
						//Datahandler dh = new Datahandler();
						
						System.out.println("肺弊牢 己傍");
						userNum = Integer.parseInt(savedIDNumber);
						
						//board load
						//brd = dh.board_load();
						
						String lmsInfo = "lmsInfo.txt";
						File file1 = new File(lmsInfo);
						FileWriter fw1 = null;

						try {
							fw1 = new FileWriter(file1, true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						BufferedReader br1 = null;
						br1 = new BufferedReader(new FileReader(file1));
						int j = 0;
							
						if (userNum == 1) {
							login.setVisible(false);
							
							while ((line = br1.readLine()) != null) {

								String[] txtArr = line.split("@");
								
								if(txtArr[j++].equals(savedID))
									std = new Student( txtArr[j++], txtArr[j++], txtArr[j++], txtArr[j++],
										txtArr[j++]);
								j = 0;
								
							}
							
							System.out.println("切积 按眉 积己 己傍");
							
							UI_main_student std_main = new UI_main_student(std, brd);
							std_main.setVisible(true);
						}
						else {
							login.setVisible(false);
							
							while ((line = br1.readLine()) != null) {

								String[] txtArr = line.split("@");
								
								if(txtArr[j++].equals(savedID))
									mng = new Manager(txtArr[j++]);
								j = 0;
								
							}
							
							System.out.println("包府磊 按眉 积己 己傍");
							
							ManagerOperation mng_oper = new ManagerOperation(brd,mng);
							UI_main_manager mng_main = new UI_main_manager(brd,mng_oper);
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