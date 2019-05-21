package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Operation.ManagerOperation;
import Tools.Board;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class UI_notice_manager extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UI_notice_manager(Board brd,ManagerOperation mng_oper) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnback = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		
		JList list = new JList();
		
		JLabel l_title = new JLabel("\uC81C\uBAA9");
		
		JTextPane t_title = new JTextPane();
		t_title.setEditable(false);
		JTextPane t_content = new JTextPane();
		t_content.setEditable(false);
		
		JLabel l_notice = new JLabel("\uACF5\uC9C0\uC0AC\uD56D");
		
		JButton btnview = new JButton("\uBCF4\uAE30");
		
		JButton btnposting = new JButton("\uACF5\uC9C0 \uAC8C\uC2DC");
		btnposting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnposting)
				{
					UI_notice_posting notice_post = new UI_notice_posting(brd,mng_oper);
					notice_post.setVisible(true);
					
				}
			}
		});
		
		JButton btnreq = new JButton("\uC120\uBC1C");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(l_title)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(t_title))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(t_content, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(l_notice))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(180)
					.addComponent(btnview)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnposting)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnreq)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnback)
					.addContainerGap(252, Short.MAX_VALUE))
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
						.addComponent(btnreq)
						.addComponent(btnback))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
		
	
		
	
		
		
		
	
	}
}
