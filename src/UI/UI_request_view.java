package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Operation.StudentOperation;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class UI_request_view extends JFrame {

   private JPanel contentPane;
   private int index;
   /**
    * Create the frame.
    */
   public UI_request_view(StudentOperation sop) {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 500);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JList request_list = new JList();
      request_list.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent e) {
            index = request_list.getSelectedIndex();
         }
      });
      
      request_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      DefaultListModel list_content = new DefaultListModel();
      // list title load
      for(int i = 0; i < sop.getStudent().getReqList().size(); i++)
      {
         //System.out.println("in for\n");
         //System.out.printf("신청 목록 : %s\n", sop.getStudent().getReqList().get(i).getSch().getName());
         list_content.addElement(sop.getStudent().getReqList().get(i).getSch().getName());
      }
      
      request_list.setModel(list_content);
      
      JLabel request_label = new JLabel("\uB098\uC758 \uC2E0\uCCAD \uBAA9\uB85D");
      
      JButton btn_cancel = new JButton("\uC2E0\uCCAD \uCDE8\uC18C");
      
      JButton btn_result_view = new JButton("\uC2E0\uCCAD \uACB0\uACFC");
      
      JLabel result_label = new JLabel("\uACB0\uACFC");
      
      JLabel request_result_label = new JLabel("New label");
      request_result_label.setForeground(Color.RED);
      request_result_label.setFont(new Font("굴림", Font.PLAIN, 30));
      
      JButton btn_back = new JButton("\uB4A4\uB85C \uAC00\uAE30");
      btn_back.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
         //back button click
         dispose();
         new UI_main_student(sop).setVisible(true);
      }
      });
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGap(23)
               .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                     .addComponent(btn_cancel)
                     .addComponent(request_list, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE))
                  .addComponent(request_label))
               .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                     .addGroup(gl_contentPane.createSequentialGroup()
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(btn_result_view)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(btn_back)
                        .addContainerGap(25, Short.MAX_VALUE))
                     .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(result_label)
                        .addGap(96)))
                  .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                     .addPreferredGap(ComponentPlacement.RELATED)
                     .addComponent(request_result_label)
                     .addGap(40))))
      );
      gl_contentPane.setVerticalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addGap(39)
                     .addComponent(request_label)
                     .addPreferredGap(ComponentPlacement.RELATED)
                     .addComponent(request_list, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addGap(48)
                     .addComponent(result_label)
                     .addPreferredGap(ComponentPlacement.RELATED)
                     .addComponent(request_result_label)))
               .addGap(18)
               .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                  .addComponent(btn_cancel)
                  .addComponent(btn_result_view)
                  .addComponent(btn_back))
               .addContainerGap(30, Short.MAX_VALUE))
      );
      contentPane.setLayout(gl_contentPane);
      
      
   }

}