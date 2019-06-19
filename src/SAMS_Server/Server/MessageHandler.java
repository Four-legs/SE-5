package Server;

import Information.*;
import Tools.*;
import User.*;

public class MessageHandler {
	//[Message format]
		//Request 	: "Request", Notice obj, Student obj
		//Recruit 	: "Recruit", Notice obj, 
		//Student 	: "Student", Student obj
		//Manager 	: "Manager", Manager obj
		//Board		: "Board", Board obj
		//Notice	: "Notice", Notice obj;
		//Signal	: "Signal", Notice obj, dest(target client)
		//Login		: "Login", String id, String pw
	//when message passed, this class actually do something with the messages.
	//return response message object. server or client will send returned message.
	
	//reference
	public ConnectionToClient connection;
	
	//attributes
	public Message msg;
	
	//constructor
	public MessageHandler(Message msg, ConnectionToClient c) {
		this.msg = msg;
		this.connection = c;
	}
	
	//methods
	public Message Action(Message msg) {
		Message msgtemp = new Message();
		Notice notemp;
		Student stdtmp;
		Manager mantmp;
		
		if(msg.getMsgtype().equals("Request")) {
			  //client > server
			  //add sender's info to corresponding notice
			notemp = (Notice)msg.getMsgobj();
			stdtmp = (Student)msg.getMsgobj2();
			notemp.getRecruit().getRequestedStdList().add(stdtmp);
			msgtemp.setMsgtype("Request");
			msgtemp.setMsgobj(notemp);
			  
		  }
		  else if(msg.getMsgtype().equals("Recruit")) {
			  //client > server
			  notemp = (Notice)msg.getMsgobj();
			  
		  }
		  else if(msg.getMsgtype().equals("Student")) {
			  //client > server
			  stdtmp = (Student)msg.getMsgobj();
		  }
		  else if(msg.getMsgtype().equals("Manager")) {
			  mantmp = (Manager)msg.getMsgobj();
		  }
		  //save student or manager info to server (data)
		  else if(msg.getMsgtype().equals("Notice")) {
			  //client <-> server
			  //when manager post or delete notice
		  
		  }
		  else if(msg.getMsgtype().equals("Signal")) {
			  //client <-> client
			  //when manager recruit, the result must be send to corresponding students.
		  
		  }
		  else if(msg.getMsgtype().equals("Board")) {
			  //server > client
			  //send board information to clients (when board changes)
			  msgtemp.setMsgobj(this.connection.getBrd());
			  msgtemp.setMsgtype("Board");
		  
		  }
		  else if(msg.getMsgtype().equals("Login")) {
			  //at the login section, server finds that user information.
			  System.out.println("login request occured.");
			  msgtemp.setMsgtype("Login");
			  int find = 0;
			  for(int i = 0; i < connection.getUd().getUlist().size(); i++) {
				  if(connection.getUd().getUlist().get(i).ID.equals((String)msg.getMsgobj())
						  && connection.getUd().getUlist().get(i).PW.equals((String)msg.getMsgobj2())) {
						  msgtemp.msgobj = (boolean) true;
				  		  msgtemp.msgobj2 = (User) connection.getUd().getUlist().get(i);
				  		  find = 1;
				  		  break;
				  }
			  }
			  if(find == 0) {
				  msgtemp.msgobj = (boolean) false;
			  }
			  //if it doesn't exist, return false
		  }
		
		return msgtemp;
	}
	//make Message object corresponding to received message from client.
	
	public ConnectionToClient getConnection() {
		return connection;
	}

	public void setConnection(ConnectionToClient connection) {
		this.connection = connection;
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public Notice Action_request(Notice n, Student s) {
		Notice returnNotice = n;
		
		return returnNotice;
	}

}
