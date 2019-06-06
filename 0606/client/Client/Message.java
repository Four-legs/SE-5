package Client;

import java.io.Serializable;
import Information.*;
import Tools.*;
import User.*;

public class Message implements Serializable{
	//This class expresses the format of message that used to server-client data passing.
	//[Message format]
	//Request 	: "Request", Notice obj, Student obj
	//Recruit 	: "Recruit", Notice obj, 
	//Student 	: "Student", Student obj
	//Manager 	: "Manager", Manager obj
	//Board		: "Board"
	//Notice	: "Notice", Notice obj;
	//Signal	: "Signal", Notice obj, dest(target client)
	//UDL		: "UDL", UDL obj
	
	
	//attributes
	public String msgtype;	//type of message (request, recruit, ...etc)
	public Object msgobj;	//the object that message contains.
	public Object msgobj2;
	public String dest;		//destination of message (if "server", ignore it. it usually be the student number of "manager");
	
	//constructor
	public Message() {
		
	}
	
	public Message(String msgtype, Object msgobj, Object msgobj2) {
		this.msgtype = msgtype;
		this.msgobj = msgobj;
		this.msgobj2 = msgobj2;
	}
	//overload
	public Message(String msgtype, Object msgobj, Object msgobj2, String dest) {
		this.msgtype = msgtype;
		this.msgobj = msgobj;
		this.msgobj2 = msgobj2;
		this.dest = dest;
	}

	//methods
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Object getMsgobj() {
		return msgobj;
	}

	public void setMsgobj(Object msgobj) {
		this.msgobj = msgobj;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
	public Object getMsgobj2() {
		return msgobj2;
	}
	public void setMsgobj2(Object msgobj2) {
		this.msgobj2 = msgobj2;
	}
	
}
