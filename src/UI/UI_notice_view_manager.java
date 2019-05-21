package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;

public class UI_notice_view_manager extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UI_notice_view_manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane t_content = new JTextPane();
		t_content.setEditable(false);
		JList list = new JList();
		
		JButton btnview = new JButton("\uBCF4\uAE30");
		
		JButton btnback = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		
		JTextPane t_title = new JTextPane();
		t_title.setEditable(false);
		JLabel L_title = new JLabel("\uC81C\uBAA9");
		
		JButton btn_req = new JButton("\uC120\uBC1C");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(L_title)
							.addGap(18)
							.addComponent(t_title, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(t_content, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(24)
									.addComponent(btnview)
									.addGap(18)
									.addComponent(btn_req))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(99)
									.addComponent(btnback)))
							.addGap(699))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(692))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(t_title, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(L_title)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(t_content, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnback)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(list, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnview)
								.addComponent(btn_req))))
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

