package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
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

	/**
	 * Create the frame.
	 */
	public UI_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel SAMSIcon = new JLabel("New label");
		SAMSIcon.setIcon(new ImageIcon("/Users/jihye/Desktop/sams.png"));
		
		JLabel L_id = new JLabel("ID");
		
		JLabel L_pw = new JLabel("PW");
		
		t_id = new JTextField();
		t_id.setColumns(10);
		
		t_pw = new JTextField();
		t_pw.setColumns(10);
		
		JLabel L_notice = new JLabel("* YES 통합 시스템 ID와 PW로 로그인 하세요 *");
		
		JButton btnLogin = new JButton("Login");
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
					.addGap(102)
					.addComponent(L_notice)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(SAMSIcon, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(L_id)
								.addComponent(t_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(L_pw)
								.addComponent(t_pw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(btnLogin)
							.addGap(35)))
					.addComponent(L_notice)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
