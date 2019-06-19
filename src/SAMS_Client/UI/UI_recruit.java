package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.ChatClient;
import Information.Identity;
import Operation.ManagerOperation;
import Tools.Board;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class UI_recruit extends JFrame {

   private JPanel contentPane;
   private Board brd;
   private ChatClient connection;
   /**
    * Create the frame.
    */
   public UI_recruit(ManagerOperation mng_oper,ChatClient c) {
      this.brd = mng_oper.getBrd();
      this.connection = c;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 458, 329);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JList notice_list = new JList();
      
      // 일단 list에 모든 공지 다 넣어두도록 했음
      // 나중에 캘린더 사용해서 마감된 notice만 넣도록 조건 넣어주고 그 공지들 따로 ArrayList로 만들어서 관리?
       
      DefaultListModel list_content = new DefaultListModel();
         // list title load
         for(int i=0; i < brd.getNoticeList().size(); i++)
         {
            //System.out.printf("list : %s",brd.getNoticeList().get(i).getTitle());
            list_content.addElement(brd.getNoticeList().get(i).getTitle());
         }
         notice_list.setModel(list_content);
      
      JLabel n_label = new JLabel("\uB9C8\uAC10 \uACF5\uACE0");
      
      JButton recruit_btn = new JButton("\uC120\uBC1C");
      recruit_btn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                  // notice_list에는 기간이 마감된 공지만
                  // ManagerOperation에 recruiting method 실행
            	 for(int i=0; i<brd.getNoticeList().size(); i++)
            	 {
            		 mng_oper.recruiting(brd.getNoticeList().get(i));
            		 System.out.printf("notice : %s recruit student: %s\n ",brd.getNoticeList().get(i).getTitle(),brd.getNoticeList().get(i).getRecruit().getRequestedStdList());
            	 }
            	 }
          });
      
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addContainerGap()
                     .addComponent(notice_list, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addGap(178)
                     .addComponent(n_label))
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addGap(183)
                     .addComponent(recruit_btn)))
               .addContainerGap())
      );
      gl_contentPane.setVerticalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGap(5)
               .addComponent(n_label)
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(notice_list, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(recruit_btn))
      );
      contentPane.setLayout(gl_contentPane);
   }
}