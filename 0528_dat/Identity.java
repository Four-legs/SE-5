package Information;

import java.io.Serializable;

public class Identity implements Serializable {
   
   public String StudentNumber;
   public String verify;
   
   private static final long serialVersionUID = 1L;
   
   public Identity(String StudentNumber, String verify) {
	   this.StudentNumber = StudentNumber;
	   this.verify = verify;
   }

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