package UI;

import User.Student;
import Tools.Board;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Operation.StudentOperation;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UI_main_student extends JFrame {

   private JPanel contentPane;
   private StudentOperation sop;
   private Board brd;
   /**
    * Create the frame.
    */
   public UI_main_student(StudentOperation sop) {
      this.sop = sop;
      this.brd = sop.getBrd();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 500);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JLabel label = new JLabel("\uC774\uB984");
      
      JLabel label_1 = new JLabel("\uD559\uBC88");
      
      JButton btnLogout = new JButton("Logout");
      
      JButton btn_notice = new JButton("공지 조회");
      btn_notice.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn_notice) {
               dispose();
               
               UI_notice_student notice_student = new UI_notice_student(brd, sop);
               notice_student.setVisible(true);
            }
         }
      });
      
      JLabel label_2 = new JLabel("");
      label_2.setIcon(new ImageIcon("/Users/jihye/Downloads/KakaoTalk_Photo_2019-05-14-20-03-20.png"));
      
      JButton btn_result = new JButton("\uC2E0\uCCAD \uACB0\uACFC \uC870\uD68C");
      
      JButton btn_benefit = new JButton("\uC218\uD61C \uB0B4\uC5ED");
      
      JLabel std_name = new JLabel(sop.getStudent().getName());
      JLabel std_stdnum = new JLabel(sop.getStudent().getStudentNumber());
      
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addGap(118)
                     .addComponent(btn_notice)
                     .addGap(102)
                     .addComponent(btn_result)
                     .addGap(97)
                     .addComponent(btn_benefit))
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addContainerGap()
                     .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                     .addGap(12)
                     .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                           .addComponent(label_1)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(std_stdnum))
                        .addGroup(gl_contentPane.createSequentialGroup()
                           .addComponent(label)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(std_name))))
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addContainerGap()
                     .addComponent(btnLogout)))
               .addContainerGap(142, Short.MAX_VALUE))
      );
      gl_contentPane.setVerticalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addGap(19)
                     .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label)
                        .addComponent(std_name))
                     .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label_1)
                        .addComponent(std_stdnum)))
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addContainerGap()
                     .addComponent(label_2, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(btnLogout)
               .addGap(251)
               .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                  .addComponent(btn_notice)
                  .addComponent(btn_result)
                  .addComponent(btn_benefit))
               .addGap(97))
      );
      contentPane.setLayout(gl_contentPane);
   }
}