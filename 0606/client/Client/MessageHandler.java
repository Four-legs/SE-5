package Client;

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
	private ChatClient connection;
	
	//attributes
	private Message msg;
	
	//constructor
	public MessageHandler(Message msg, ChatClient c) {
		this.msg = msg;
		this.connection = c;
	}
	
	//methods
	public Message Action(Message msg) {
		Message msgtemp = null;
		Notice notemp;
		Student stdtmp;
		Manager mantmp;
		
		if(msg.getMsgtype().equals("Request")) {
			  //client > server
			  //add sender's info to corresponding notice

			  
		  }
		  else if(msg.getMsgtype().equals("Recruit")) {
			  //client > server

			  
		  }
		  else if(msg.getMsgtype().equals("Student")) {
			  //client > server
			  
		  }
		  else if(msg.getMsgtype().equals("Manager")) {

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
		  
		  }
		  else if(msg.getMsgtype().equals("Login")) {
			  msgtemp = msg;
		  }
		
		return msgtemp;
	}
	//make Message object corresponding to received message from client.
	
	public ChatClient getConnection() {
		return connection;
	}

	public void setConnection(ChatClient connection) {
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
