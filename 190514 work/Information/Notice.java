package Information;

import java.util.Calendar;

import Scholarship.Scholar;

public class Notice {
   public String title;   //�Խñ� ����
   public String content;   //�Խñ� ����
   public int accept;      //���� �ο�
   public Scholar scholar;   //���б� ��ü
   public Calendar expiredate;   //���� �Ⱓ ��ü
   
   public Notice(Scholar s) {
      this.scholar = s;
   }
   
   
   
   public int getAccept() {
      return accept;
   }

   public void setAccept(int accept) {
      this.accept = accept;
   }
   
   

   public Scholar getScholar() {
      return scholar;
   }



   public void setScholar(Scholar scholar) {
      this.scholar = scholar;
   }



   public void setTitle(String t) {
      this.title = t;
   }
   public String getTitle() {
      return this.title;
   }
   
   public void setContent(String c) {
      this.content = c;
   }
   public String getContent() {
      return this.content;
   }
   
   public void setExpiredate(Calendar exp) {
      this.expiredate = exp;
   }
   public Calendar getExpiredate() {
      return this.expiredate;
   }
   
}