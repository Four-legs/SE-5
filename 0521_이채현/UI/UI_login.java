package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.UserListData;
import Operation.ManagerOperation;
import Operation.StudentOperation;
import Tools.Board;
import User.Manager;
import User.Student;
import User.User;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UI_login extends JFrame {
	
	private JPanel contentPane;
	private JTextField t_id;
	private JTextField t_pw;
	private String id,pw;
	private int check_login=0;
	private Board brd = new Board();
	
	JLabel L_notice = new JLabel("* YES \uD1B5\uD569 \uC2DC\uC2A4\uD15C ID/PW \uB85C \uB85C\uADF8\uC778 \uD558\uC138\uC694 *");
	/**
	 * Create the frame.
	 */
	public UI_login(UserListData ud) {
		ArrayList<User> Ulist = ud.getUlist();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel SAMSIcon = new JLabel("New label");
		SAMSIcon.setIcon(new ImageIcon("sams.png"));
		
		JLabel L_id = new JLabel("ID");
		
		JLabel L_pw = new JLabel("PW");
		
		t_id = new JTextField();
		t_id.setColumns(10);
		t_pw = new JTextField();
		t_pw.setColumns(10);
		
		final JButton btnLogin = new JButton("Login");
		
		ActionListener btnl = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int login_success = 1;			//when login successes, this integer be set 0.
				
					
					//get id, pw
					pw = t_pw.getText();
					id = t_id.getText();
					
					//find account that has same id and pw.
					for(int i = 0; i < Ulist.size(); i++) {
						if(Ulist.get(i).ID.equals(id) && Ulist.get(i).PW.equals(pw)) {
							System.out.println(Ulist.get(i).ID);
							System.out.println(Ulist.get(i).PW);
							System.out.println(Ulist.get(i).getType());
							if(Ulist.get(i).getType() == 1) {	//if read User info is about Student,
								//make StudentOperation instance and attach Student information read.
								Student stdtemp = (Student) Ulist.get(i);
								StudentOperation sop = new StudentOperation(stdtemp, brd);
								login_success = 0;
								UI_main_student smain = new UI_main_student(sop);
								smain.setVisible(true);
								break;
							}
							else {		//if read info is about manager
								//make ManagerOperation instance and attach Manager information read.
								Manager mantemp = (Manager) Ulist.get(i);
								ManagerOperation mop = new ManagerOperation(mantemp, brd);
								login_success = 0;
								UI_main_manager mmain = new UI_main_manager(mop);
								mmain.setVisible(true);
								break;
							}
						}
					}
					if(login_success == 1) login_fault();
				}

		};
		btnLogin.addActionListener(btnl);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addComponent(SAMSIcon, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
					.addGap(88))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(117)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(L_pw)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(t_pw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(L_id)
							.addGap(18)
							.addComponent(t_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnLogin)
					.addContainerGap(153, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(L_notice)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(SAMSIcon, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(L_id)
								.addComponent(t_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(L_pw)
								.addComponent(t_pw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnLogin)
							.addGap(29)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(L_notice)
					.addGap(47))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public String getId() {
		return id;
	}
	
	public int getCheck_login() {
		return check_login;
	}
	
	public void setCheck_login(int check_login) {
		this.check_login = check_login;
	}

	public String getPw() {
		return pw;
	}
	
	public void login_fault() {
		L_notice.setText(" * 로그인 정보가 일치하지 않습니다 * ");
		
	}
	
	

	
}