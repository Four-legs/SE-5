package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Client.ChatClient;
import Information.Honor;
import Information.Notice;
import Information.Scholar;
import Information.Working;
import Operation.ManagerOperation;
import Tools.Board;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UI_notice_edit extends JFrame {
	   
	 private ChatClient connection;
	 private JPanel contentPane;
	 private JTextField title_field;
	 private JTextField accept_field;
	 private String title, content, type, detail; // type; working/honor   detail; type detail
	 private Calendar expiredate = Calendar.getInstance();
	 private int year,month,day; //expiredate
	 private int accept;
	 //private Board brd;
	 private Scholar s;
	 //  private ManagerOperation manopr;
	
	public UI_notice_edit(ManagerOperation mng_oper,ChatClient c, int index) {
		this.connection = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setBounds(100, 100, 800, 500);
	      contentPane = new JPanel();
	      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	      setContentPane(contentPane);
	      
	      JLabel label = new JLabel("\uC81C\uBAA9");
	      
	      title_field = new JTextField();
	      title_field.setColumns(10);
	      title_field.setText(mng_oper.getBrd().getNoticeList().get(index).getTitle());
	      JLabel label_1 = new JLabel("\uBAA8\uC9D1 \uC720\uD615");
	      
	      JLabel lblNewLabel = new JLabel("\uBAA8\uC9D1 \uC778\uC6D0");
	      
	      accept_field = new JTextField();
	      accept_field.setColumns(10);
	      //accept_field.setText(mng_oper.getBrd().getNoticeList().get(index).getAccept());
	      JLabel lblNewLabel_1 = new JLabel("\uBA85");
	      
	      JLabel lblNewLabel_2 = new JLabel("\uB9C8\uAC10 \uC77C\uC2DC");
	      //expiredate.clear();
	      JComboBox expire_year = new JComboBox();
	      expire_year.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JComboBox jcb = (JComboBox)e.getSource();
	            year = Integer.parseInt(jcb.getSelectedItem().toString());
	            //expiredate.set(Calendar.YEAR, Integer.parseInt(jcb.getSelectedItem().toString()));
	            System.out.printf("<<year: %d\n",year);
	         }
	      });
	      expire_year.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021", "2022", "2023"}));
	      
	      JComboBox expire_month = new JComboBox();
	      expire_month.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JComboBox jcb = (JComboBox)e.getSource();
	            //expiredate.set(expiredate.MONTH, Integer.parseInt(jcb.getSelectedItem().toString()));
	            month = Integer.parseInt(jcb.getSelectedItem().toString());
	            System.out.printf("<<m: %d\n",month);
	         }
	      });
	      expire_month.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
	      
	      JComboBox expire_day = new JComboBox();
	      expire_day.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JComboBox jcb = (JComboBox)e.getSource();
	            day = Integer.parseInt(jcb.getSelectedItem().toString());
	            //expiredate.set(expiredate.DAY_OF_MONTH, Integer.parseInt(jcb.getSelectedItem().toString()));
	            //System.out.printf("date: %d\n",expiredate.DAY_OF_MONTH);
	            System.out.printf("<<d: %d\n",day);
	         }
	      });
	      expire_day.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	      
	      JLabel label_2 = new JLabel("\uB0B4\uC6A9");
	      JComboBox recruit_detail = new JComboBox();
	      recruit_detail.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JComboBox jcb = (JComboBox)e.getSource();
	            detail = jcb.getSelectedItem().toString();
	            System.out.printf("detail: %s\n",detail);
	         }
	      });
	      
	      JTextArea content_field = new JTextArea();
	      content_field.setText(mng_oper.getBrd().getNoticeList().get(index).getContent());
	      
	      JButton btn_posting = new JButton("\uAC8C\uC2DC");
	      btn_posting.addActionListener(new ActionListener() {
	         //posting button click
	         public void actionPerformed(ActionEvent e) {
	            if(e.getSource() == btn_posting)
	            {
	               title = title_field.getText();
	               content = content_field.getText();
	               accept = Integer.parseInt(accept_field.getText());
	               System.out.printf("title : %s\n type : %s\n detail :%s\n expiredate : %d/%d/%d\n content:%s\n",title,type,detail,year,month,day,content);
	               
	               if (type.equals("근로장학생")) {
	                  Working wr = new Working("근로장학생");
	                 
	                  wr.setStd_income(3);
	                  wr.setWorking_type(detail);
	                  wr.setstd_score(4);
	                  
	                  Notice n = new Notice(wr, accept);
	                  
	                  n.setTitle(title);
	                  n.setAccept(accept);
	                  n.setContent(content);
	                 
	                  n.setExpiredate(year, month, day);
	                  
	                  System.out.print(n.toString());
	                  
	                  try {
	      				mng_oper.NoticePosting(n);
	      				dispose();
	      				new UI_notice_manager(mng_oper,c).setVisible(true);
	      			} catch (IOException e1) {
	      				// TODO Auto-generated catch block
	      			e1.printStackTrace();
	      			}
	               }
	               else if (type.equals("성적우수장학생")) {
	                  Honor hr = new Honor("성적우수장학생");
	                  Notice n = new Notice(hr, accept);
	                  
	                  n.setTitle(title);
	                  n.setAccept(accept);
	                  n.setContent(content);
	                  
	                  n.setExpiredate(year, month, day);
	                  
	                  System.out.print(n.toString());
	                  
	                  try {
	      				mng_oper.NoticePosting(n);
	      				dispose();
	      				new UI_notice_manager(mng_oper,c).setVisible(true);
	      			} catch (IOException e1) {
	      				// TODO Auto-generated catch block
	      			e1.printStackTrace();
	      			}
	               }
	            }
	         }
	      });
	      
	      JButton btn_back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
	      btn_back.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		if(btn_back == e.getSource())
	      		{
	      			dispose();
	      			new UI_notice_manager(mng_oper,c).setVisible(true);
	      		}
	      	}
	      });
	      
	     
	      recruit_detail.setModel(new DefaultComboBoxModel(new String[] {"-", "\uC0AC\uBB34\uBCF4\uC870", "\uC2E4\uC2B5\uC2E4 \uAD00\uB9AC", "\uAC15\uC758\uC2E4 \uAD00\uB9AC"}));
	      GroupLayout gl_contentPane = new GroupLayout(contentPane);
	      gl_contentPane.setHorizontalGroup(
	      	gl_contentPane.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_contentPane.createSequentialGroup()
	      			.addContainerGap()
	      			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	      				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
	      					.addComponent(label)
	      					.addGap(14)
	      					.addComponent(title_field, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
	      				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
	      					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	      						.addComponent(lblNewLabel)
	      						.addComponent(label_1)
	      						.addComponent(lblNewLabel_2))
	      					.addGap(18)
	      					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	      						.addGroup(gl_contentPane.createSequentialGroup()
	      							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	      								.addGroup(gl_contentPane.createSequentialGroup()
	      									.addGap(6)
	      									.addComponent(accept_field, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
	      								.addComponent(expire_year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	      							.addGap(0)
	      							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	      								.addGroup(gl_contentPane.createSequentialGroup()
	      									.addComponent(expire_month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      									.addPreferredGap(ComponentPlacement.UNRELATED)
	      									.addComponent(expire_day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	      								.addComponent(lblNewLabel_1)))
	      						.addComponent(recruit_detail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	      					.addPreferredGap(ComponentPlacement.RELATED, 474, Short.MAX_VALUE))
	      				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
	      					.addComponent(label_2)
	      					.addGap(18)
	      					.addComponent(content_field, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE))
	      				.addGroup(gl_contentPane.createSequentialGroup()
	      					.addComponent(btn_posting)
	      					.addGap(3)
	      					.addComponent(btn_back)))
	      			.addContainerGap())
	      );
	      gl_contentPane.setVerticalGroup(
	      	gl_contentPane.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_contentPane.createSequentialGroup()
	      			.addContainerGap()
	      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(title_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(label))
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(recruit_detail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(label_1))
	      			.addGap(18)
	      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(lblNewLabel)
	      				.addComponent(accept_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(lblNewLabel_1))
	      			.addGap(27)
	      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(lblNewLabel_2)
	      				.addComponent(expire_year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(expire_month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(expire_day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	      			.addGap(18)
	      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(content_field, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(label_2))
	      			.addGap(18)
	      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(btn_posting)
	      				.addComponent(btn_back))
	      			.addContainerGap())
	      );
	      contentPane.setLayout(gl_contentPane);
	   }
}


