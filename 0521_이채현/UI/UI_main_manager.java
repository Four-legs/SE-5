package UI;

import User.Manager;
import Tools.Board;
import Operation.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_main_manager extends JFrame {

   private JPanel contentPane;
   private ManagerOperation manopr;
   private Board brd;
   /**
    * Create the frame.
    */
   public UI_main_manager(ManagerOperation mng_oper) {

      this.brd = mng_oper.getBrd();
      this.manopr = mng_oper;
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 500);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JButton btn_notice_posting = new JButton("\uACF5\uC9C0 \uAC8C\uC2DC");
      btn_notice_posting.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn_notice_posting) {
               System.out.println("공지 게시 버튼 클릭");
               
               dispose();
               UI_notice_posting notice_posting = new UI_notice_posting(brd,mng_oper);
               notice_posting.setVisible(true);
            }
         }
      });
      
      JButton btn_notice_view = new JButton("\uACF5\uC9C0 \uC870\uD68C");
      btn_notice_view.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn_notice_view) {
               System.out.println("공지 조회 버튼 클릭");
               
               dispose();
               
               
               
              // oper.ViewNotice();
               
               //UI_notice_mng_view notice_mng_view = new UI_notice_mng_view(brd);
               //notice_mng_view.setVisible(true);
            }
         }
      });
      
      JButton btn_manage_student = new JButton("\uC7A5\uD559\uC0DD \uAD00\uB9AC");
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGap(151)
               .addComponent(btn_notice_posting)
               .addGap(79)
               .addComponent(btn_notice_view)
               .addGap(87)
               .addComponent(btn_manage_student)
               .addContainerGap(172, Short.MAX_VALUE))
      );
      gl_contentPane.setVerticalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGap(188)
               .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                  .addComponent(btn_notice_posting)
                  .addComponent(btn_notice_view)
                  .addComponent(btn_manage_student))
               .addContainerGap(251, Short.MAX_VALUE))
      );
      contentPane.setLayout(gl_contentPane);
   }
}