package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.ChatClient;
import Information.Identity;
import Information.Id_List;
import Operation.StudentOperation;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UI_request extends JFrame {

	private JPanel contentPane;
	private String password;
	private ArrayList<Identity> pwlist;
	private JTextField t_pw;
	 private ChatClient connection;
	/**
	 * Create the frame.
	 */
	public UI_request(StudentOperation sop, ChatClient c,int index) {
		this.connection = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane t_title = new JTextPane();
		t_title.setEditable(false);
		t_title.setText(sop.getBrd().getNoticeList().get(index).getTitle());
		JLabel label = new JLabel("\uC744 \uC2E0\uCCAD\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		 
		JLabel lblNewLabel_1 = new JLabel("\uBCF8\uC778\uC778\uC99D\uBC88\uD638");
		JLabel alarm = new JLabel("\uC778\uC99D\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694");
		
		JButton btnrequest = new JButton("\uC2E0\uCCAD");
		t_pw = new JPasswordField();
		t_pw.setColumns(10);
		
		
		btnrequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//request button click
				password = t_pw.getText();
			
				//pwd check
 
			}
		});
		
		JButton btnexit = new JButton("\uB2EB\uAE30");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(t_title, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(t_pw)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(btnrequest)))
					.addGap(7))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(alarm)
					.addContainerGap(176, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(170)
					.addComponent(btnexit)
					.addContainerGap(195, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(t_title, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(t_pw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnrequest))
					.addGap(18)
					.addComponent(alarm)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnexit)
					.addGap(68))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
