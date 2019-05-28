package Foundation;

import java.util.*;

import Data.Datahandler;
import Data.UserListData;
import Operation.ManagerOperation;
import Operation.StudentOperation;
import User.*;
import UI.*;
import Information.*;
import Tools.Board;
import java.io.*;

public class main {


	public static void main(String[] args) throws FileNotFoundException, IOException {

		UserListData ud = new UserListData();
		ud = load_accounts(ud);
		
		//createVerify();
		
		UI_login login = new UI_login(ud);
		login.setVisible(true);
		
	}
	
	
	public static void createAccount() throws FileNotFoundException, IOException {
		UserListData ud = new UserListData();
		
		String stdnum[] = {"2015111031", "2015110229","2015114934","2017232392","2015002934","2010002311","2012232312","2015223123","2016223912","2014232123","2012232421","2018992394","2019232322","2019293992","2012324422","2013222345","2011234923","2018888283","2013234429","2015232553","2016223423"};
		String id[] = {"jhye125","yeahzz","kyung","astro","upupup","zero123","park","jenny","nayon","jjeong","konggg","zzeong","rmrm","vviii","taemin","rose","risaa","irene","wendi","ryu12","son"};
		String pass[] = {"a123","b123","c123","d123","e123","f123","g123","h123","i123","j123","k123","l123","m123","n123","o123","p123","q123","r123","s123","t123","u123" };
		String name[] = {"김지혜","경예지","김경래","차은우","김우석","공지철","박보검","김제니","임나연","유정연","공승연","전정국","김남준","김태형","이태민","박채영","라리사","배주현","손승완","류현진","손흥민"};
		int grade[] = {1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,3};
		int income[] = {1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1,2,3,4,5};
		double score[] = {2.5,2.6, 2.7, 2.8, 2.9, 3.0, 3.1, 3.2, 3.3, 3.4, 3.5, 3.6, 3.7, 3.8, 3.9, 4.0, 4.1, 4.2, 4.3, 4.2, 4.1};
		for(int i=0; i<21; i++)
		{	
			Student std = new Student(id[i], pass[i], name[i], stdnum[i], grade[i], income[i], score[i]);		
			ud.Ulist.add(std);
		}
		
		Manager mn = new Manager("yoon", "za123", "최윤자");
		ud.Ulist.add(mn);
		
		save(ud);		
	}
	
	public static void createVerify() throws FileNotFoundException, IOException {
		Id_List list = new Id_List();
		
		String stdnum[] = {"2015111031", "2015110229","2015114934","2017232392","2015002934","2010002311","2012232312","2015223123","2016223912","2014232123","2012232421","2018992394","2019232322","2019293992","2012324422","2013222345","2011234923","2018888283","2013234429","2015232553","2016223423"};
		String verify[] = {"ahgPWkd","961123","1234","dktmxmfh","djqxpstus","ehRoql","qhrjaqhrwlqn","EnenEnen","xmdhkdltm","tttt123","kk1123","bts11","bts22","bts33","shines","rosee","123risa","redred","881123","lalalal","777777"};
		
		for(int i=0; i<21; i++)
		{
			Identity iden = new Identity(stdnum[i], verify[i]);
			list.IdList.add(iden);
		}
		
		ObjectOutputStream oos = null;
		oos= new  ObjectOutputStream(new FileOutputStream("Veryfication.dat"));
		oos.writeObject(list);
		oos.close();	
	}
	
	public static void save(UserListData ud) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = null;
		oos= new  ObjectOutputStream(new FileOutputStream("Accounts.dat"));
		oos.writeObject(ud);
		oos.close();
	}
	
	public static void saveb(Board b) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = null;
		oos= new  ObjectOutputStream(new FileOutputStream("Board.dat"));
		oos.writeObject(b);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static UserListData load_accounts(UserListData ud) throws FileNotFoundException, IOException
	{
		ObjectInputStream ois = null;
		ois = new  ObjectInputStream(new FileInputStream("Accounts.dat"));
		try {
			ud = (UserListData)ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
		
		return ud;
	}


}