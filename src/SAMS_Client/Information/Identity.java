package Information;

import java.io.Serializable;

public class Identity implements Serializable {
   
	private String StudentNumber;
	private String verify;
   
   private static final long serialVersionUID = 1L;
   
   public String getStudentNumber() {
      return StudentNumber;
   }
   
   public void setStudentNumber(String studentNumber) {
      StudentNumber = studentNumber;
   }
   
   public String getVerify() {
      return verify;
   }
   public void setVerify(String verify) {
      this.verify = verify;
   }

}