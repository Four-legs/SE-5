// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package Client;

import Client.*;
import UI.UI_login;

import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  //ChatIF clientUI; 
	
	private Message RecentMessageFromServer;
	//recently received message from server
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public ChatClient(String host, int port) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    openConnection();
    //UI_login login = new UI_login(this);
    //login.setVisible(true);
 
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
	  System.out.println("handle part");
	  Message msgtemp;
	  msgtemp = (Message) msg;
	  System.out.println(msgtemp.getMsgtype());
	  this.setRecentMessageFromServer(msgtemp);
  }
  //set RecentMessageFromServer with response of server message.

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(Object message)
  {
    try
    {
      sendToServer(message);
    }
    catch(IOException e)
    {
     // clientUI.display
       // ("Could not send message to server.  Terminating client.");
      quit();
    }
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }


public Message getRecentMessageFromServer() {
	return RecentMessageFromServer;
}


public void setRecentMessageFromServer(Message recentMessageFromServer) {
	RecentMessageFromServer = recentMessageFromServer;
}



  
}
//End of ChatClient class
