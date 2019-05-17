package Information;

import java.util.Calendar;

public class Notice {
   public String title;   // �Խñ� ����
   public String content;   // �Խñ� ����
   public int accept;      // ���� �ο�
   public Scholar scholar;   // ���б� ��ü
   //public Calendar expiredate;   // ���� �Ⱓ ��ü
   public int expire_year, expire_month,expire_day;
   
   public int getExpire_year() {
	return expire_year;
}

public void setExpire_year(int expire_year) {
	this.expire_year = expire_year;
}

public int getExpire_month() {
	return expire_month;
}

public void setExpire_month(int expire_month) {
	this.expire_month = expire_month;
}

public int getExpire_day() {
	return expire_day;
}

public void setExpire_day(int expire_day) {
	this.expire_day = expire_day;
}

public Notice(Scholar s) {
      this.scholar = s;
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
}
