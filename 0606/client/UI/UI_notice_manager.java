package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Operation.ManagerOperation;
import Tools.Board;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import Client.ChatClient;
public class UI_notice_manager extends JFrame {

	/**
	 * Launch the application.
	 */
	int index;
	private JPanel contentPane;
	private Board b;
	private ChatClient connect;
	/**
	 * Create the frame.
	 */
	public UI_notice_manager(ManagerOperation mng_oper) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.b = mng_oper.getBrd();
		JButton btnback = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//back button click
					dispose();
					new UI_main_manager(mng_oper, connect).setVisible(true);
					
			}
		});
		
		
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				index = list.getSelectedIndex();
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel list_content = new DefaultListModel();
		// list title load
		for(int i=0; i < b.getNoticeList().size(); i++)
		{
			//System.out.printf("list : %s",brd.getNoticeList().get(i).getTitle());
			list_content.addElement(b.getNoticeList().get(i).getTitle());
		}
		list.setModel(list_content);
		
		
		JLabel l_title = new JLabel("\uC81C\uBAA9");
		
		JTextPane t_title = new JTextPane();
		t_title.setEditable(false);
		JTextPane t_content = new JTextPane();
		t_content.setEditable(false);
		
		JLabel l_notice = new JLabel("\uACF5\uC9C0\uC0AC\uD56D");
		
		JButton btnview = new JButton("\uBCF4\uAE30");
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// view button click
				t_title.setText(b.getNoticeList().get(index).getTitle()); // put title 
				String content = String.format("선발 인원 : " + b.getNoticeList().get(index).getAccept() + "\n마감일 : " + 
						b.getNoticeList().get(index).printExpdate() + "\n" + b.getNoticeList().get(index).getContent());
				t_content.setText(content); // put content 
			}
		});
		
		JButton btnposting = new JButton("\uACF5\uC9C0 \uAC8C\uC2DC");
		btnposting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnposting)
				{
					//posting button click
					UI_notice_posting notice_post = new UI_notice_posting(mng_oper);
					notice_post.setVisible(true);
					
				}
			}
		});
		
		JButton btnreq = new JButton("\uC120\uBC1C");
		 btnreq.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	             if(e.getSource() == btnreq)
	             {
	               UI_recruit recruit = new UI_recruit(mng_oper);
	                recruit.setVisible(true);
	             }
	          }
	       });
		
		JButton btnedit = new JButton("\uACF5\uC9C0 \uC218\uC815");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(l_title)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(t_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(t_content, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(l_notice))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(180)
							.addComponent(btnview)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnposting)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnedit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnreq)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnback)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(t_title, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(l_title))
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(l_notice)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(t_content, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
						.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnview)
						.addComponent(btnposting)
						.addComponent(btnback)
						.addComponent(btnreq)
						.addComponent(btnedit))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	
	}
}